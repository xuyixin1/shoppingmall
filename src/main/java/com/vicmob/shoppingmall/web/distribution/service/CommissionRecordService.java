package com.vicmob.shoppingmall.web.distribution.service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.vicmob.shoppingmall.constant.CommissionConstant;
import com.vicmob.shoppingmall.constant.Constant;
import com.vicmob.shoppingmall.constant.ResponseStatus;
import com.vicmob.shoppingmall.utils.ResultData;
import com.vicmob.shoppingmall.web.distribution.dao.CommissionRecordMapper;
import com.vicmob.shoppingmall.web.distribution.entity.Commission;
import com.vicmob.shoppingmall.web.distribution.entity.CommissionRecord;
import com.vicmob.shoppingmall.web.goods.entity.Goods;
import com.vicmob.shoppingmall.web.goods.entity.GoodsDetail;
import com.vicmob.shoppingmall.web.goods.entity.Order;
import com.vicmob.shoppingmall.web.goods.service.GoodsService;
import com.vicmob.shoppingmall.web.goods.service.OrderService;
import com.vicmob.shoppingmall.web.goodsAPI.wxclient.WXInfoClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Slf4j
public class CommissionRecordService {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private CommissionService commissionService;
    @Autowired
    private WXInfoClient wxInfoClient;
    @Autowired
    private CommissionRecordMapper commissionRecordMapper;
    @Autowired
    private CustomerService customerService;

    @Lazy
    @Autowired
    private OrderService orderService;
    public void addCommissionRecord(){
        updateCommissionRecord((Order)orderService.getByOrderNo("6000000125558226").getData());
    }

    /**
     * 分销订单只可能为同一种商品
     * @param order
     */
    @Async("taskExecutor")
    public void addCommissionRecord(Order order) {
        try{
            if (order.getDistributionUser() == null){
                return ;
            }
            if (order.getTotalMoney().compareTo(BigDecimal.ZERO) == 0){
                order.setOrderStatus(Constant.OrderType.ORDER_PAY);
            }
            String service = order.getGoodsDetails();
            List<GoodsDetail> list = JSONObject.parseArray(service, GoodsDetail.class);
            if(list == null || list.size() == 0){
                log.error("商品详情为空 order==>{}",order);
            }
            ResultData result = goodsService.getByGoodsId(list.get(0).getGoodsId());
            if (result.getStatus() != ResponseStatus.SUCCESS.value){
                log.error("获取goods失败 order=》{}",order);
                return ;
            }
            Goods goods = (Goods) result.getData();
            if (goods.getDistributionFlag() != Constant.Flag.YES){
                return ;
            }
            CommissionRecord commissionRecord = new CommissionRecord();
            fill(commissionRecord,order,goods,list.get(0));
            if(commissionRecordMapper.addCommissionRecord(commissionRecord) != 1){
                throw new Exception("佣金记录表添加失败");
            }
        }catch (Exception e){
            log.error(e.getMessage(), e);
            log.error("分销订单添加失败");
        }
    }

    @Async("taskExecutor")
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void updateCommissionRecord(Order order){
        try{
            Commission commission = commissionService.getCommissionByMinaId(order.getMinaId());
            if(commission == null){
                throw new Exception("佣金设置不存在");
            }

            CommissionRecord commissionRecord = commissionRecordMapper.getCommissionRecordByOrderNumber(order.getOrderNumber());
            if(commissionRecord == null){
                log.info("未参与分销");
                return;
            }
            CommissionConstant.CommissionStatus status = CommissionConstant.CommissionStatus.getByOrderStatus(order.getOrderStatus(),commission.getClearingDays());
            if (commissionRecordMapper.updateCommissionRecord(status,order.getOrderNumber()) != 1){
                log.info("更新失败 order==>{}",order);
                return;
            }
            if(status == CommissionConstant.CommissionStatus.BOOKED){
                customerService.updateCommissionTotalCommission(commissionRecord.getDistributionUser(),commissionRecord.getCommission());
            }
        }catch (Exception e){
            log.error("更新佣金记录表失败");
            log.error(e.getMessage(),e);
        }
    }

    public Integer updateCommissionStatus(List<Integer> ids,CommissionConstant.CommissionStatus status){
        return commissionRecordMapper.updateCommissionStatus(ids,status);
    }

    public List<CommissionRecord> getCommissionRecordListByStatus(CommissionConstant.CommissionStatus status){
        return commissionRecordMapper.getCommissionRecordListByStatus(status);
    }

    public List<CommissionRecord> getCommissionRecordList(String distributionUser,String orderNumber,List<CommissionConstant.CommissionStatus> statusList,Integer minaId,Integer page,Integer size){
        PageHelper.startPage(page, size, "date desc");
        List<CommissionRecord> commissionRecords =  commissionRecordMapper.getCommissionRecordList(distributionUser, orderNumber,statusList,minaId);
        return commissionRecords;
    }


    public void fill(CommissionRecord commissionRecord,Order order,Goods goods,GoodsDetail goodsDetail)throws Exception{
        commissionRecord.fill(order,goods);
        Commission commission = commissionService.getCommissionByMinaId(order.getMinaId());
        if(commission == null){
            throw new Exception("佣金设置不存在");
        }
        if(commissionRecord.getCommissionMode() == CommissionConstant.CommissionMode.FIXED){

        }
        BigDecimal money = CommissionConstant.CommissionMode.getCommission(commissionRecord.getCommissionMode(),commission.getMinAmount(),goods.getDistribution(),order.getTotalMoney(),goodsDetail.getNum());
        commissionRecord.setCommission(money);
        String openId =  wxInfoClient.getOpenId(order.getMinaId(),order.getCustomerId());
        if (openId == null){
            throw new Exception("customerId定义的openId不存在");
        }
        commissionRecord.setOpenId(openId);
        String distributionUser = wxInfoClient.getOpenId(order.getMinaId(),order.getDistributionUser());
        if (distributionUser == null){
            throw new Exception("distributionUser定义的openId不存在");
        }
        commissionRecord.setDistributionUser(distributionUser);
        commissionRecord.setStatus(CommissionConstant.CommissionStatus.getByOrderStatus(order.getOrderStatus(),commission.getClearingDays()));
    }

    public BigDecimal getUnBookCommission(Integer minaId,String distributionUser){
        return commissionRecordMapper.getUnBookCommission(minaId,distributionUser);
    }
}
