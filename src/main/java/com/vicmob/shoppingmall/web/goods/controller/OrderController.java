package com.vicmob.shoppingmall.web.goods.controller;

import com.vicmob.shoppingmall.constant.Constant;
import com.vicmob.shoppingmall.constant.ResponseStatus;
import com.vicmob.shoppingmall.utils.MySqlUtils;
import com.vicmob.shoppingmall.utils.ResultData;
import com.vicmob.shoppingmall.utils.ResultDataFactory;
import com.vicmob.shoppingmall.web.goods.entity.Order;
import com.vicmob.shoppingmall.web.goods.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Api(tags="订单相关接口")
@Validated
@RestController
@RequestMapping(value = "/onlineShop/order")
public class OrderController {
    private final Logger log = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;


    @GetMapping(value = "")
    @ApiOperation(value="查询订单列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "minaId", value = "小程序id",required = true),
            @ApiImplicitParam(name = "orderNumber", value = "订单编号"),
            @ApiImplicitParam(name = "orderStatus", value = "订单状态"),
            @ApiImplicitParam(name = "page", value = "当前页码", required = true),
            @ApiImplicitParam(name = "size", value = "每页条数", required = true)
    })
    public ResultData findList(@NotNull(message ="minaId不能为空")@RequestParam Integer minaId,
                               @RequestParam(required = false) String orderNumber,
                               @RequestParam(required = false) Constant.OrderType orderStatus,
                               @NotNull(message ="page不能为空") @Min(value = 1,message ="page不能小于1") @RequestParam Integer page,
                               @NotNull(message ="size不能为空") @Min(value = 1,message ="size不能小于1") @RequestParam Integer size) {
        Order order = null;
        try{
            order = new Order();
            if (orderNumber != null) {
                order.setOrderNumber((MySqlUtils.specialStr(orderNumber)));
            }
            if(orderStatus != null) {
                order.setOrderStatus(orderStatus);
            }

            List<Order> orders = orderService.getOrderList(order,minaId,page,size);
            return ResultDataFactory.getResultData(orders);

        }catch(Exception e){
            log.error("获取订单列表失败，minaId ==> {},orderNumber ==> {},orderStatus ==> {}",minaId,orderNumber,orderStatus );
            log.error(e.getMessage(), e);
            return  new ResultData("获取订单列表失败", ResponseStatus.FAIL.getValue());
        }
    }

    @GetMapping(value ="{orderId}")
    @ApiOperation(value="查询订单数据")
    @ApiImplicitParam(name = "orderId", value = "订单id",required = true)
    public ResultData getByOrderId(@Min(value = 1,message ="订单id不能小于1")@PathVariable Integer orderId){
        ResultData result = null;
        try{
            result = orderService.getByOrderId(orderId);
        }catch(Exception e){
            log.error("查询订单详情失败,orderId ==>{}",orderId);
            log.error(e.getMessage(), e);
            result = new ResultData("查询订单详情失败", ResponseStatus.FAIL.getValue());
        }

        return result;
    }

    @GetMapping("cancel")
    @ApiOperation(value="取消订单")
    @ApiImplicitParam(name = "orderId", value = "订单id",required = true)
    public ResultData orderCancel(@Min(value = 1,message ="订单id不能小于1")@RequestParam Integer orderId,
                                  @NotEmpty(message ="取消订单原因不能为空") @RequestParam String cancelReason){
        ResultData result = null;
        try{
            result = orderService.orderCancel(orderId,cancelReason);
        }catch(Exception e){
            log.error("取消订单失败,orderId ==>{}",orderId);
            log.error(e.getMessage(), e);
            result = new ResultData("取消订单失败", ResponseStatus.FAIL.getValue());
        }
        return result;
    }

    @ApiOperation(value="修改退款状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId", value = "订单Id" ,required = true),
            @ApiImplicitParam(name = "status", value = "订单状态",required = true),
            @ApiImplicitParam(name = "refuseReason", value = "拒绝原因")
    })
    @GetMapping("refund")
    public ResultData refund(@Min(value = 1,message ="订单id不能小于1")@RequestParam Integer orderId,
                        @RequestParam Constant.OrderType status,
                        @RequestParam(required = false) String refuseReason){
        try {
            if (status != Constant.OrderType.REFUND_REFUSE && status != Constant.OrderType.REFUND_PAYING){
                log.error("状态不合法 orderId ==>{},status ==>{},refuseReason==>{}",orderId,status,refuseReason);
                return new ResultData("状态不合法", ResponseStatus.FAIL.getValue());
            }
            if (status == Constant.OrderType.REFUND_REFUSE){
                if (StringUtils.isEmpty(refuseReason)){
                    log.error("拒绝退款请填写拒绝理由 orderId ==>{},status ==>{},refuseReason==>{}",orderId,status,refuseReason);
                    return new ResultData("拒绝退款请填写拒绝理由", ResponseStatus.FAIL.getValue());
                }
            }
            if (status == Constant.OrderType.REFUND_PAYING){
                refuseReason = null;
            }
            return orderService.refund(orderId,status,refuseReason);
        }catch (Exception e){
            log.error("修改退款状态失败，orderId ==>{},status ==>{},refuseReason==>{}",orderId,status,refuseReason);
            log.error(e.getMessage(), e);
            return  new ResultData("修改退款状态失败", ResponseStatus.FAIL.getValue());
        }

    }
}
