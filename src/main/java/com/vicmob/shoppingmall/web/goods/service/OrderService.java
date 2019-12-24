package com.vicmob.shoppingmall.web.goods.service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.vicmob.shoppingmall.constant.Constant;
import com.vicmob.shoppingmall.constant.ResponseStatus;
import com.vicmob.shoppingmall.utils.ListToMapUtil;
import com.vicmob.shoppingmall.utils.ResultData;
import com.vicmob.shoppingmall.web.distribution.service.CommissionRecordService;
import com.vicmob.shoppingmall.web.goods.dao.OrderMapper;
import com.vicmob.shoppingmall.web.goods.dao.SpecificationMapper;
import com.vicmob.shoppingmall.web.goods.entity.GoodsDetail;
import com.vicmob.shoppingmall.web.goods.entity.Order;
import com.vicmob.shoppingmall.web.goodsAPI.wxclient.WXMessageClient;
import com.vicmob.shoppingmall.web.goodsAPI.wxclient.WXPayClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {
    private final Logger log = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private WXMessageClient wxMessageClient;
    @Autowired
    @Lazy
    private WXPayClient wxPayClient;
    @Autowired
    private SpecificationMapper specificationMapper;
    @Autowired
    private CommissionRecordService commissionRecordService;

    @Autowired
    private GoodsService goodsService;


    public List<Order> getOrderList(Order order, Integer minaId, Integer page, Integer size){
        PageHelper.startPage(page, size,"orderId desc");
        List<Order> orderList =  orderMapper.getOrderList(minaId, order);
        return orderList;
    }

    public ResultData getByOrderId(Integer orderId) {
        Order order = orderMapper.getByOrderId(orderId);
        if (order == null) {
            log.error("获取订单详情失败，orderId ==>{}", orderId);
            return new ResultData("获取订单详情失败", ResponseStatus.FAIL.getValue());
        }
        return new ResultData("success", ResponseStatus.SUCCESS.getValue(),order);
    }

    public ResultData getByOrderNo(String orderNumber) {
        Order order = orderMapper.getByOrderNo(orderNumber);
        if (order == null) {
            log.error("获取订单详情失败，orderNumber ==>{}", orderNumber);
            return new ResultData("获取订单详情失败", ResponseStatus.FAIL.getValue());
        }
        return new ResultData("success", ResponseStatus.SUCCESS.getValue(),order);
    }


    @Transactional(rollbackFor = Exception.class)
    public ResultData orderCancel(Integer orderId,String cancelReason){
        try {
            Order order = orderMapper.getByOrderId(orderId);
            if (order == null) {
                log.error("订单不存在,无法取消，orderId ==>{}", orderId);
                throw new Exception("订单不存在,无法取消");
            }
            if(order.getOrderStatus() != Constant.OrderType.ORDER){
                log.error("订单状态为" + order.getOrderStatus() +"，无法取消订单");
                throw new Exception("订单状态为" + order.getOrderStatus() +"，无法取消订单");
            }
            if (orderMapper.orderCancel(orderId,cancelReason,Constant.OrderType.ORDER_CANCEL) != 1){
                log.error("订单更新失败，orderId ==>{}", orderId);
                throw new Exception("订单更新失败");
            }
            String service = order.getGoodsDetails();
            List<GoodsDetail> list = JSONObject.parseArray(service, GoodsDetail.class);
            for (GoodsDetail sd : list){
                if (specificationMapper.updateStock(sd.getSpecId(),sd.getNum()) != 1){
                    log.error("更新库存失败 specId ==>{},num ==>{}",sd.getSpecId(),sd.getNum());
                    throw new Exception("微信退款申请已成功,更新库存失败,请手动修改");
                }
            }
            order.setOrderStatus(Constant.OrderType.ORDER_CANCEL);
            order.setCancelReason(cancelReason);
            wxMessageClient.sendMessage(order);
            return new ResultData("success", ResponseStatus.SUCCESS.getValue(),order);
        }catch (Exception e) {
            log.error(e.getMessage(), e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new ResultData(e.getMessage(), ResponseStatus.FAIL.getValue());
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public ResultData refund(Integer orderId,Constant.OrderType status,String refuseReason)throws Exception{
        Order order = orderMapper.getByOrderId(orderId);
        if (order == null) {
            log.error("订单不存在，orderId ==>{},status ==>{},refuseReason==>{}",orderId,status,refuseReason);
            return new ResultData("订单不存在", ResponseStatus.FAIL.getValue());
        }
        if(order.getOrderStatus() != Constant.OrderType.REFUND_APPLY){
            log.error("订单状态为" + order.getOrderStatus() +"，无法修改退款状态");
            return new ResultData("订单状态为" + order.getOrderStatus() +"，无法修改退款状态", ResponseStatus.FAIL.getValue());
        }
        if (status == Constant.OrderType.REFUND_REFUSE){
            if(orderMapper.refund(orderId,status,refuseReason) != 1){
                log.error("修改退款状态失败，orderId ==>{},status ==>{},refuseReason==>{}",orderId,status,refuseReason);
                return new ResultData("修改退款状态失败", ResponseStatus.FAIL.getValue());
            }
            order.setOrderStatus(status);
            order.setRefuseReason(refuseReason);
            wxMessageClient.sendMessage(order);
            commissionRecordService.updateCommissionRecord(order);
            return new ResultData("success", ResponseStatus.SUCCESS.getValue(),order);
        }

        //同意退款
        ResultData result = wxPayClient.refund(order);
        if ( result.getStatus() == ResponseStatus.FAIL.value){
            return result;
        }
        if ( result.getStatus() == ResponseStatus.WXFAIL.value){
            status = Constant.OrderType.REFUND_FAILURE;
            if(orderMapper.refund(orderId,Constant.OrderType.REFUND_FAILURE,refuseReason) != 1){
                log.error("修改退款状态失败,微信拒绝退款，请手动修改，orderId ==>{},status ==>{},refuseReason==>{}",orderId,Constant.OrderType.REFUND_FAILURE,refuseReason);
                return new ResultData("修改退款状态失败,微信拒绝退款，请手动修改", ResponseStatus.FAIL.getValue());
            }
        }

        try{
            if (result.getStatus() == ResponseStatus.SUCCESS.value){
                status = Constant.OrderType.REFUND_SUCCESS;
                if(orderMapper.refund(orderId,Constant.OrderType.REFUND_SUCCESS,refuseReason) != 1){
                    log.error("修改退款状态失败,微信退款申请已成功,请手动修改，orderId ==>{},status ==>{},refuseReason==>{}",orderId,Constant.OrderType.REFUND_SUCCESS,refuseReason);
                    throw new Exception("修改退款状态失败,微信退款申请已成功，请手动修改");
                }
                String service = order.getGoodsDetails();
                List<GoodsDetail> list = JSONObject.parseArray(service, GoodsDetail.class);
                for (GoodsDetail sd : list){
                    if (specificationMapper.updateStock(sd.getSpecId(),sd.getNum()) != 1){
                        log.error("微信退款申请已成功,更新库存失败 specId ==>{},num ==>{}",sd.getSpecId(),sd.getNum());
                        throw new Exception("微信退款申请已成功,更新库存失败,请手动修改");
                    }
                }
                //更新销量
                Map<Integer, List<GoodsDetail>> map = ListToMapUtil.toMapServiceDetailByGoodsId(list);
                for(Integer goodsId :map.keySet()){
                    Integer num = 0;
                    for (GoodsDetail sd : map.get(goodsId)){
                        num += sd.getNum();
                    }
                    if (goodsService.reduceSailed(goodsId,num)!= 1){
                        log.error("微信退款申请已成功,更新销量失败 goodsId ==>{},num ==>{}",goodsId,num);
                        throw new Exception("微信退款申请已成功,更新销量失败");
                    }
                }
            }
            order.setOrderStatus(status);
            order.setRefuseReason(refuseReason);
            wxMessageClient.sendMessage(order);
            commissionRecordService.updateCommissionRecord(order);
            return new ResultData("success", ResponseStatus.SUCCESS.getValue(),order);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return  new ResultData(e.getMessage(), ResponseStatus.FAIL.getValue());
        }
    }

    @Async("taskExecutor")
    public ResultData updatePrepayId(Integer minaId, Integer orderId,String prepayId){
        if (orderMapper.updatePrepayId(minaId,orderId,prepayId,Constant.OrderType.PAYING) != 1) {
            log.error("更新订单prepayId 详情失败，minaId ==>{},orderId ==>{},prepayId ==>{}", minaId,orderId,prepayId);
            return new ResultData("获取订单详情失败", ResponseStatus.FAIL.getValue());
        }
        return new ResultData("success", ResponseStatus.SUCCESS.getValue());
    }

    public Integer updatPayedStatus(String orderNumber, Constant.OrderType status){
        return orderMapper.updatPayedStatus(orderNumber,status,new Date());
    }

    public ResultData updatOrderStatus(String orderNumber,Constant.OrderType status){
        if (orderMapper.updatOrderStatus(orderNumber,status) !=1){
            log.error("更新订单状态失败，orderNumber ==>{},status ==>{}", orderNumber,status);
            return new ResultData("更新订单状态失败", ResponseStatus.FAIL.getValue());
        }
        return new ResultData("success", ResponseStatus.FAIL.getValue());

    }

}
