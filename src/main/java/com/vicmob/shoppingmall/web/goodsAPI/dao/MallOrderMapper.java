package com.vicmob.shoppingmall.web.goodsAPI.dao;

import com.github.pagehelper.Page;
import com.vicmob.shoppingmall.web.goods.entity.Order;
import com.vicmob.shoppingmall.web.goodsAPI.entity.MallOrder;
import com.vicmob.shoppingmall.web.goodsAPI.entity.MallOrderExample;
import com.vicmob.shoppingmall.web.goodsAPI.entity.MallOrderWithBLOBs;
import com.vicmob.shoppingmall.web.goodsAPI.model.MallOrderVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface MallOrderMapper {
    int countByExample(MallOrderExample example);

    int deleteByExample(MallOrderExample example);

    List<MallOrderWithBLOBs> selectByExampleWithBLOBs(MallOrderExample example);

    List<MallOrder> selectByExample(MallOrderExample example);

    int updateByExampleSelective(@Param("record") MallOrderWithBLOBs record, @Param("example") MallOrderExample example);

    int updateByExampleWithBLOBs(@Param("record") MallOrderWithBLOBs record, @Param("example") MallOrderExample example);

    int updateByExample(@Param("record") MallOrder record, @Param("example") MallOrderExample example);

    List<MallOrderWithBLOBs> selectByExampleWithBLOBsAndPage(MallOrderExample example, RowBounds rowBound);

    List<MallOrder> selectByExampleAndPage(MallOrderExample example, RowBounds rowBound);

    int deleteByPrimaryKey(Integer orderid);

    int insert(MallOrderWithBLOBs record);

    int insertSelective(MallOrderWithBLOBs record);

    MallOrderWithBLOBs selectByPrimaryKey(Integer orderid);

    int updateByPrimaryKeySelective(MallOrderWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(MallOrderWithBLOBs record);

    int updateByPrimaryKey(MallOrder record);

    List<MallOrder> checkCreateOrder(@Param("customerId")Integer customerId,@Param("minaId")Integer minaId,@Param("goodsDetails")String goodsDetails);

    Order getMallOrderDetail(Integer orderId);

    List<Order> selectAllOrderList();

    List<Order> selectOrderByGoodsId(@Param("minaId")Integer minaId,@Param("goodsId")Integer goodsId);

    List<Order> selectOrderByCollageNo(@Param("collageNo")String collageNo);

    int updateByOrderNumber(@Param("orderNumber")String orderNumber,@Param("orderStatus")Integer orderStatus);

    int updateOrderByCollageNo(@Param("collageNo")String collageNo,@Param("orderStatus")Integer orderStatus);

    int updateByGoodsId(@Param("minaId")Integer minaId,@Param("goodsId")Integer goodsId);

    int updateOrderByCollageFull();

    Page<MallOrderVO> getOrderList(@Param("minaId")Integer minaId, @Param("customerId")Integer customerId, @Param("orderStatus")Integer orderStatus);

    MallOrderVO getOrderDetail(Integer orderId);
}