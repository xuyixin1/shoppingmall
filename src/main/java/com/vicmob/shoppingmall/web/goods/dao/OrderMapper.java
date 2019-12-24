package com.vicmob.shoppingmall.web.goods.dao;

import com.vicmob.shoppingmall.constant.Constant;
import com.vicmob.shoppingmall.web.goods.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface OrderMapper {

    public List<Order> getOrderList(@Param("minaId") Integer minaId,@Param("o") Order order);

    public Order getByOrderId(@Param("orderId") Integer orderId);

    public Order getByOrderNo(@Param("orderNumber") String orderNumber);

    public Integer updatePrepayId(@Param("minaId")Integer minaId, @Param("orderId")Integer orderId, @Param("prepayId")String prepayId,@Param("status") Constant.OrderType status);

    public Integer updatPayedStatus(@Param("orderNumber")String orderNumber,@Param("status") Constant.OrderType status,@Param("date") Date date);

    public Integer orderCancel(@Param("orderId") Integer orderId,@Param("cancelReason") String cancelReason,@Param("status") Constant.OrderType status);

    public Integer refund(@Param("orderId")Integer orderId, @Param("status")Constant.OrderType status, @Param("refuseReason")String refuseReason);

    public Integer updatOrderStatus(@Param("orderNumber")String orderNumber,@Param("status")Constant.OrderType status);
}
