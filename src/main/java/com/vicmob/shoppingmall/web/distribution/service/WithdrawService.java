package com.vicmob.shoppingmall.web.distribution.service;

import com.github.pagehelper.PageHelper;
import com.vicmob.shoppingmall.constant.CommissionConstant;
import com.vicmob.shoppingmall.constant.ResponseStatus;
import com.vicmob.shoppingmall.utils.DateUtils;
import com.vicmob.shoppingmall.utils.ResultData;
import com.vicmob.shoppingmall.web.distribution.dao.WithdrawMapper;
import com.vicmob.shoppingmall.web.distribution.entity.Commission;
import com.vicmob.shoppingmall.web.distribution.entity.Customer;
import com.vicmob.shoppingmall.web.distribution.entity.Withdraw;
import com.vicmob.shoppingmall.web.goodsAPI.wxclient.WXPayWithEnterpriseClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class WithdrawService {
    @Autowired
    private CommissionService commissionService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private WithdrawMapper withdrawMapper;
    @Autowired
    private WXPayWithEnterpriseClient wxPayWithEnterpriseClient;

    @Transactional(rollbackFor = Exception.class)
    public ResultData addWithdraw(Withdraw withdraw) {
        try {
            ResultData result;
            String lock = withdraw.getDistributionUser() ;
            synchronized (lock){
                result = checkAndFillWithdraw(withdraw);
                if (result != null){
                    return result;
                }
                if (withdrawMapper.addWithdraw(withdraw) != 1){
                    throw new Exception("添加申请提现记录失败");
                }
                if (customerService.updateApplyNumberAndCash(withdraw.getMinaId(),withdraw.getDistributionUser(),withdraw.getCashApply())!= 1) {
                    throw new Exception("更新提现次数失败");
                }
            }
            return new ResultData("success", ResponseStatus.SUCCESS.getValue());

        }catch (Exception e){
            log.error("提现申请失败,withdraw ==>{}",withdraw);
            log.error(e.getMessage(), e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new ResultData(e.getMessage(), ResponseStatus.FAIL.getValue());
        }
    }

    private ResultData checkAndFillWithdraw(Withdraw withdraw){
        if(DateUtils.inTimes(23,2)){
            return new ResultData("当前时间不可申请提款", ResponseStatus.FAIL.value);
        }
        Customer customer = customerService.getCustomerByOpenId(withdraw.getDistributionUser(),withdraw.getMinaId());
        if(customer == null){
            return new ResultData("不存在的客户", ResponseStatus.FAIL.value);
        }
        Commission commission = commissionService.getCommissionByMinaId(withdraw.getMinaId());
        if (commission == null){
            return new ResultData("基础佣金不存在", ResponseStatus.FAIL.value);
        }

        if (customer.getCanWithdraw().compareTo(withdraw.getCashApply()) < 0){
            return new ResultData("申请金额已超过可申请金额", ResponseStatus.FAIL.value);
        }
        if(withdraw.getCashApply().compareTo(commission.getMaxLimit()) > 0 || withdraw.getCashApply().compareTo(commission.getMinLimit()) < 0){
            return new ResultData("申请金额大于最大可提现佣金或小于最小可提现佣金", ResponseStatus.FAIL.value);
        }

        if( customer.getApplyNumber() >= commission.getNumberLimit()){
            return new ResultData("今日申请次数已用完", ResponseStatus.FAIL.value);
        }
        BigDecimal commissionApply;
        BigDecimal freeAmount = commission.getFreeAmount();
        if(freeAmount.compareTo(withdraw.getCashApply()) >= 0 ){
            commissionApply = BigDecimal.ZERO;
        }else{
            commissionApply = withdraw.getCashApply().subtract(freeAmount).multiply(commission.getServiceCharge()).divide(new BigDecimal(100),2,BigDecimal.ROUND_DOWN);
        }
        withdraw.setCommissionApply(commissionApply);
        withdraw.setWithdrawNo("TX" + withdraw.getDistributionUser().substring(0,6) +  System.currentTimeMillis());
        return null;
    }

    public List<Withdraw> getWithdrawList(String distributionUser, String withdrawNo, String phone, CommissionConstant.WithdrawStatus status, Integer minaId, Integer page, Integer size){
        PageHelper.startPage(page, size, "applyTime desc");
        return withdrawMapper.getWithdrawList(distributionUser,withdrawNo,phone,status,minaId);
    }


    @Transactional(rollbackFor = Exception.class)
    public ResultData updateAuditStatus(String withdrawNo,Integer minaId,CommissionConstant.WithdrawStatus status,String reason){
        synchronized (withdrawNo){
            Withdraw withdraw = withdrawMapper.getWithdrawByWithdrawNo(withdrawNo,minaId);
            if(withdraw == null){
                return  new ResultData("不存在的数据", ResponseStatus.FAIL.value);
            }
            if(withdraw.getStatus() != CommissionConstant.WithdrawStatus.TO_BE_AUDITED){
                return  new ResultData("当前状态不合法", ResponseStatus.FAIL.value);
            }
            if(status == CommissionConstant.WithdrawStatus.TO_BE_PAY){
                reason = null;
            }
            withdrawMapper.updateAuditStatus(withdrawNo,minaId,status,reason,new Date(),null);
            if(status == CommissionConstant.WithdrawStatus.UNPASSED){
                customerService.updateCommissionWithUnpassed(withdraw.getMinaId(),withdraw.getDistributionUser(),withdraw.getCashApply());
            }
            return  new ResultData("success", ResponseStatus.SUCCESS.value);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public ResultData pay(String withdrawNo,Integer minaId,CommissionConstant.WithdrawStatus status){
        synchronized (withdrawNo){
            Withdraw withdraw = withdrawMapper.getWithdrawByWithdrawNo(withdrawNo,minaId);
            if(withdraw == null){
                return  new ResultData("不存在的数据", ResponseStatus.FAIL.value);
            }
            if(withdraw.getStatus() != CommissionConstant.WithdrawStatus.TO_BE_PAY){
                return  new ResultData("当前状态不合法", ResponseStatus.FAIL.value);
            }

            ResultData resultData = wxPayWithEnterpriseClient.payWithEnterprise(withdraw);
            if(resultData.getStatus() == ResponseStatus.WXFAIL.value){
                withdrawMapper.updateAuditStatus(withdrawNo,minaId,CommissionConstant.WithdrawStatus.CHECKPASSED,null,null,null);
            }
            if (resultData.getStatus() == ResponseStatus.FAIL.value){
                withdrawMapper.updateAuditStatus(withdrawNo,minaId,CommissionConstant.WithdrawStatus.UNPASSED,null,null,null);
                customerService.updateCommissionWithUnpassed(withdraw.getMinaId(),withdraw.getDistributionUser(),withdraw.getCashApply());
            }
            if (resultData.getStatus() == ResponseStatus.SUCCESS.value){
                withdrawMapper.updateAuditStatus(withdrawNo,withdraw.getMinaId(),CommissionConstant.WithdrawStatus.PAYED,null,null,new Date());
                customerService.updateCommissionWithPayed(withdraw.getMinaId(),withdraw.getDistributionUser(),withdraw.getCashApply());
            }

            return  resultData;
        }
    }


    @Transactional(rollbackFor = Exception.class)
    public ResultData businessCheck(String withdrawNo,Integer minaId,CommissionConstant.WithdrawStatus status)throws Exception{
        synchronized (withdrawNo){
            Withdraw withdraw = withdrawMapper.getWithdrawByWithdrawNo(withdrawNo,minaId);
            if(withdraw == null){
                return  new ResultData("不存在的数据", ResponseStatus.FAIL.value);
            }
            if(withdraw.getStatus() != CommissionConstant.WithdrawStatus.CHECKPASSED){
                return  new ResultData("当前状态不合法", ResponseStatus.FAIL.value);
            }

            if (status == CommissionConstant.WithdrawStatus.UNPASSED){
                if(withdrawMapper.updateAuditStatus(withdrawNo,minaId,status,null,null,null) != 1){
                    throw new Exception("更新提现明细表状态失败");
                }
                if(customerService.updateCommissionWithUnpassed(withdraw.getMinaId(),withdraw.getDistributionUser(),withdraw.getCashApply()) !=1){
                    throw new Exception("更新用户账户信息失败");
                }
            }
            if (status == CommissionConstant.WithdrawStatus.PAYED){
                if(withdrawMapper.updateAuditStatus(withdrawNo,withdraw.getMinaId(),status,null,null,new Date()) !=1){
                    throw new Exception("更新提现明细表状态失败");
                }
                if(customerService.updateCommissionWithPayed(withdraw.getMinaId(),withdraw.getDistributionUser(),withdraw.getCashApply()) !=1){
                    throw new Exception("更新用户账户信息失败");
                }
            }

            return  new ResultData("success",ResponseStatus.SUCCESS.value);
        }
    }
}
