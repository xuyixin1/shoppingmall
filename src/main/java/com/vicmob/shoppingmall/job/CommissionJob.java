package com.vicmob.shoppingmall.job;

import com.vicmob.shoppingmall.constant.CommissionConstant;
import com.vicmob.shoppingmall.constant.Constant;
import com.vicmob.shoppingmall.utils.DateUtils;
import com.vicmob.shoppingmall.utils.ListToMapUtil;
import com.vicmob.shoppingmall.web.distribution.entity.Commission;
import com.vicmob.shoppingmall.web.distribution.entity.CommissionRecord;
import com.vicmob.shoppingmall.web.distribution.entity.Customer;
import com.vicmob.shoppingmall.web.distribution.service.CommissionRecordService;
import com.vicmob.shoppingmall.web.distribution.service.CommissionService;
import com.vicmob.shoppingmall.web.distribution.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class CommissionJob {
    @Autowired
    private CommissionRecordService commissionRecordService;
    @Autowired
    private CommissionService commissionService;
    @Autowired
    private CustomerService customerService;


    @Scheduled(cron = "0 0 0 * * ?")
    public void accountFlagCalculate(){
        try{
            List<CommissionRecord> commissionRecords =  commissionRecordService.getCommissionRecordListByStatus(CommissionConstant.CommissionStatus.UNBOOKED);
            if(commissionRecords == null || commissionRecords.size()== 0){
                log.info("没有待入账的分销金额");
                return ;
            }
            Map<Integer,List<CommissionRecord>> records = ListToMapUtil.toMapCommissionRecordByMinaId(commissionRecords);
            List<Integer> ids = new ArrayList<>(commissionRecords.size());
            List<Commission> commissionList = commissionService.getCommissionByMinaIds(records.keySet());
            for(Integer minaId : records.keySet()){
                for(Commission commission : commissionList){
                    if (commission.getMinaId().equals(minaId)){
                        getCommissionRecordIds(records.get(minaId),commission,ids);
                    }
                }
            }
            if (ids.size() !=0 ){
                commissionRecordService.updateCommissionStatus(ids,CommissionConstant.CommissionStatus.BOOKED);
            }

        }catch (Exception e){
            log.error("佣金入账job错误");
            log.error(e.getMessage(),e);
        }
    }

    private void getCommissionRecordIds(List<CommissionRecord> records,Commission commission,List<Integer> ids){
        int days = commission.getClearingDays();
        if (days == 0){
            for(CommissionRecord commissionRecord: records){
                if (commissionRecord.getId() !=  null){
                    ids.add(commissionRecord.getId());
                }
            }
            return;
        }
        for(CommissionRecord commissionRecord: records){
            int expireDays = DateUtils.differentDaysByMillisecond(commissionRecord.getDate(),DateUtils.initDateByDay());
            if(expireDays == -1){
                log.error("日期相差时间获取错误 commissionRecord ==>{}",commissionRecord);
                return;
            }
            if (expireDays >= days && commissionRecord.getId() !=  null){
                ids.add(commissionRecord.getId());
            }
        }
    }


    @Scheduled(cron = "0 0 1 * * ?")
    public void userCommissionCalculate(){
        try {
            List<CommissionRecord> commissionRecords =  commissionRecordService.getCommissionRecordListByStatus(CommissionConstant.CommissionStatus.BOOKED);
            if(commissionRecords == null){
                log.info("没有入账的分销金额");
                return ;
            }
            Map<String,List<CommissionRecord>> records = ListToMapUtil.toMapCommissionRecordByDistributionUser(commissionRecords);
            List<Customer> customers = customerService.getCustomerListByOpenId(records.keySet());
            List<Customer> updateCustomers = new ArrayList<>();
            for(String distributionUser: records.keySet()){
                for(Customer customer : customers){
                    if(!StringUtils.isEmpty(customer.getOpenId()) && customer.getOpenId().equals(distributionUser)){
                        getCustomerInfo(records.get(distributionUser), customer, updateCustomers);
                    }
                }
            }
            if(updateCustomers.size() != 0){
                customerService.updateCommission(updateCustomers);
            }
        }catch (Exception e) {
            log.error("客户佣金更新错误");
            log.error(e.getMessage(), e);
        }
    }


    private void getCustomerInfo(List<CommissionRecord> records,Customer customer,List<Customer> updateCustomers){
        BigDecimal totalMoneny = BigDecimal.ZERO;
        for(CommissionRecord record : records){
            totalMoneny = totalMoneny.add(record.getCommission());
        }
        if (totalMoneny.compareTo(customer.getTotalCommission()) > 0){
            BigDecimal canWithdraw = totalMoneny.subtract(customer.getApply()).subtract(customer.getWithdrawed());
            customer.setTotalCommission(totalMoneny);
            customer.setCanWithdraw(canWithdraw);
            updateCustomers.add(customer);
        }
    }


    @Scheduled(cron = "0 20 1 * * ?")
    public void clearCustomerApplyNumber() {
        try {
            customerService.clearCustomerApplyNumber();
        } catch (Exception e) {
            log.error("清理客户申请提现次数错误");
            log.error(e.getMessage(), e);
        }
    }

}
