package com.vicmob.shoppingmall.web.goodsAPI.controller;

import com.vicmob.shoppingmall.web.goodsAPI.entity.MallOrderAddress;
import com.vicmob.shoppingmall.web.goodsAPI.entity.MallOrderWithBLOBs;
import com.vicmob.shoppingmall.web.goodsAPI.model.*;
import com.vicmob.shoppingmall.web.goodsAPI.service.PersonCenterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/minaAPI/shopShift")
@Slf4j
@Api(value="/minaAPI/personCenter", tags="个人中心")
public class PersonCenterController {

    @Autowired
    private PersonCenterService personCenterService;

    @PostMapping(value = "/getOrderList")
    @ApiOperation(value = "获取个人订单列表", notes = "获取个人订单列表", httpMethod = "POST")
    public ServerResponse<List<MallOrderVO>> getOrderList(@RequestBody OrderQueryVO vo) {
        List<MallOrderVO> list =  personCenterService.getOrderList(vo);
        if(list==null||list.isEmpty()){
           return ServerRespage.createByErrorMessage("未获取到相关数据！");
        }
        return ServerRespage.createBySuccessPage(list,vo.getPage());
    }

    @PostMapping(value = "/getOrderDetail")
    @ApiOperation(value = "获取订单详情", notes = "获取订单详情", httpMethod = "POST")
    public ServerResponse<MallOrderVO> getGoodsOrderDetail(@RequestBody OrderIdVO vo) {
        MallOrderVO order = personCenterService.getOrderDetail(vo.getOrderId());
        if(order==null){
            return ServerResponse.createByErrorMessage("未获取到相关数据！");
        }
        return ServerResponse.createBySuccess(order);
    }

    @PostMapping(value = "/updateOrderStatus")
    @ApiOperation(value = "修改订单状态", notes = "修改订单状态", httpMethod = "POST")
    public ServerResponse updateOrderStatus(@RequestBody OrderUpdateVO vo) {
        int result = personCenterService.updateOrderStatus(vo);
        if(result ==0){
            return ServerResponse.createByErrorMessage("修改订单状态失败!");
        }else{
            return ServerResponse.createBySuccess("修改订单状态成功!");
        }
    }

    @PostMapping(value = "/delOrder")
    @ApiOperation(value = "删除订单", notes = "删除订单", httpMethod = "POST")
    public ServerResponse delOrder(@RequestBody OrderUpdateVO vo) {
        int result = personCenterService.delOrder(vo);
        if(result ==0){
            return ServerResponse.createByErrorMessage("取消订单失败!");
        }else{
            return ServerResponse.createBySuccess("取消订单成功!");
        }
    }

    @PostMapping(value = "/getOrderAddressList")
    @ApiOperation(value = "获取个人收货地址列表", notes = "获取个人收货地址列表", httpMethod = "POST")
    public ServerRespage<List<MallOrderAddress>> getOrderAddressList(@RequestBody OrderQueryVO vo) {
        List<MallOrderAddress> list =  personCenterService.getOrderAddressList(vo);
        if(list==null||list.isEmpty()){
            return ServerRespage.createByErrorMessage("未获取到相关数据！");
        }
        return ServerRespage.createBySuccessPage(list,vo.getPage());
    }

    @PostMapping(value = "/getOrderAddressDetail")
    @ApiOperation(value = "获取详情收货地址", notes = "获取详情收货地址", httpMethod = "POST")
    public ServerResponse<MallOrderAddress> getOrderAddressDetail(@RequestBody AddressIdVO vo) {
        MallOrderAddress address =  personCenterService.getOrderAddressDetail(vo.getAddressId());
        if(address==null){
            return ServerRespage.createByErrorMessage("未获取到相关数据！");
        }
        return ServerResponse.createBySuccess(address);
    }

    @PostMapping(value = "/setDefaultAddress")
    @ApiOperation(value = "设置默认地址", notes = "设置默认地址", httpMethod = "POST")
    public ServerResponse setDefaultAddress(@Valid @RequestBody CustomerUpdateVO vo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ServerResponse.createByError(bindingResult);
        }
        int result = personCenterService.setDefaultAddress(vo);
        if(result ==0){
            return ServerResponse.createByErrorMessage("设置默认地址失败!");
        }else{
            return ServerResponse.createBySuccess("设置默认地址成功!");
        }
    }

    @PostMapping(value = "/addOrderAddress")
    @ApiOperation(value = "添加新的收货地址", notes = "获取收货地址详情", httpMethod = "POST")
    public ServerResponse addOrderAddress(@RequestBody MallOrderAddressVO vo) {
        int result = personCenterService.addOrderAddress(vo);
        if(result ==0){
            return ServerResponse.createByErrorMessage("添加新的地址失败!");
        }else{
            return ServerResponse.createBySuccess("添加新的地址成功!");
        }
    }

    @PostMapping(value = "/editOrderAddress")
    @ApiOperation(value = "编辑新的收货地址", notes = "编辑收货地址详情", httpMethod = "POST")
    public ServerResponse editOrderAddress(@RequestBody MallOrderAddressVO vo) {
        int result = personCenterService.editOrderAddress(vo);
        if(result ==0){
            return ServerResponse.createByErrorMessage("编辑新的地址失败!");
        }else{
            return ServerResponse.createBySuccess("编辑新的地址成功!");
        }
    }

    @PostMapping(value = "/delOrderAddress")
    @ApiOperation(value = "删除收货地址", notes = "删除收货地址详情", httpMethod = "POST")
    public ServerResponse delOrderAddress(@RequestBody AddressIdVO vo) {
        int result = personCenterService.delOrderAddress(vo.getAddressId());
        if(result ==0){
            return ServerResponse.createByErrorMessage("删除地址失败!");
        }else{
            return ServerResponse.createBySuccess("删除地址成功!");
        }
    }

    @PostMapping(value = "/getShowAddress")
    @ApiOperation(value = "获取订单的收货地址", notes = "获取订单的收货地址", httpMethod = "POST")
    public ServerResponse<MallOrderAddress> getShowAddress(@RequestBody OrderQueryVO vo) {
        MallOrderAddress address = personCenterService.getShowAddress(vo);
        if(address ==null){
            return ServerResponse.createByErrorMessage("用户没有设置收货地址!");
        }else{
            return ServerResponse.createBySuccess(address);
        }
    }
}
