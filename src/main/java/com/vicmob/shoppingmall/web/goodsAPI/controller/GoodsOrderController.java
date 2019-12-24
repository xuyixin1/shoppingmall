package com.vicmob.shoppingmall.web.goodsAPI.controller;

import com.vicmob.shoppingmall.web.goodsAPI.model.*;
import com.vicmob.shoppingmall.web.goodsAPI.service.GoodsOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/minaAPI/goodsOrder")
@Slf4j
@Api(value="/minaAPI/goodsOrder", tags="商品订单控制层")
public class GoodsOrderController {

    @Autowired
    private GoodsOrderService goodsOrderService;

    @PostMapping(value = "/getGoodsDetail")
    @ApiOperation(value = "获取商品详情", notes = "获取商品详情", httpMethod = "POST")
    public ServerResponse<MallGoodsVO> getGoodsDetail(@RequestBody GoodsIdVO vo) {
        MallGoodsVO mallGoodsVO = goodsOrderService.getGoodsDetail(vo);
        if(mallGoodsVO == null){
            return ServerResponse.createByErrorMessage("未获取到相关数据！");
        }
        return ServerResponse.createBySuccess(mallGoodsVO);
    }

    @PostMapping(value = "/getGoodsCollageDetail")
    @ApiOperation(value = "获取某个拼团的详情信息", notes = "获取某个拼团的详情信息", httpMethod = "POST")
    public ServerResponse<MallGoodsCollageDetailVO> getGoodsCollageDetail(@RequestBody CollageIdVO vo) {
        MallGoodsCollageDetailVO mallGoodsCollageDetailVO = goodsOrderService.getGoodsCollageDetail(vo.getCollageId());
        if(mallGoodsCollageDetailVO == null){
            return ServerResponse.createByErrorMessage("未获取到相关数据！");
        }
        return ServerResponse.createBySuccess(mallGoodsCollageDetailVO);
    }

    @PostMapping(value = "/getGoodsSpecs")
    @ApiOperation(value = "获取商品属性规格", notes = "获取商品属性规格", httpMethod = "POST")
    public ServerResponse<GoodsSpecsListVO> getGoodsSpecs(@RequestBody GoodsIdVO vo) {
        GoodsSpecsListVO goodsSpecsListVO = goodsOrderService.getGoodsSpecs(vo);
        if(goodsSpecsListVO.getAttributeId1VOList()==null&&goodsSpecsListVO.getAttributeId2VOList()==null){
            return ServerResponse.createByErrorMessage("未获取到相关数据！");
        }
        return ServerResponse.createBySuccess(goodsSpecsListVO);
    }

    @PostMapping(value = "/getGoodsStock")
    @ApiOperation(value = "获取商品对应库存和价格信息", notes = "获取商品对应库存和价格信息", httpMethod = "POST")
    public ServerResponse<GoodsSpecsVO> getGoodsStock(@RequestBody GoodsSpecsQueryVO vo) {
        GoodsSpecsVO goodsSpecsVO = goodsOrderService.getGoodsStock(vo);
        if(goodsSpecsVO == null){
            return ServerResponse.createByErrorMessage("未获取到相关数据！");
        }
        return ServerResponse.createBySuccess(goodsSpecsVO);
    }

    @PostMapping(value = "/checkMallGoods")
    @ApiOperation(value = "下单或者加入购物车前判断商品是否删除,下架", notes = "下单或者加入购物车前判断商品是否删除,下架", httpMethod = "POST")
    public ServerResponse checkMallGoods(@RequestBody GoodsIdVO vo) {
        Integer num = goodsOrderService.checkMallGoods(vo);
        if(num == 1){
            return ServerResponse.createByErrorMessage("该商品已经下架!");
        }
        if(num == 2){
            return ServerResponse.createByErrorMessage("该商品已经不存在!");
        }
        return ServerResponse.createBySuccess();
    }

    @PostMapping(value = "/checkCollageUsed")
    @ApiOperation(value = "判断是否有正在进行的拼团", notes = "判断是否有正在进行的拼团", httpMethod = "POST")
    public ServerResponse checkCollageUsed(@RequestBody GoodsIdVO vo) {
        int num = goodsOrderService.checkCollageUsed(vo.getGoodsId(),vo.getCustomerId());
        if(num > 0){
            return ServerResponse.createByErrorMessage("已有进行的拼团!");
        }
        return ServerResponse.createBySuccess();
    }

    @PostMapping(value = "/getGoodsAllEvaluate")
    @ApiOperation(value = "获取商品所有的评价", notes = "获取商品所有的评价", httpMethod = "POST")
    public ServerResponse<MallEvaluateAllVO> getGoodsAllEvaluate(@RequestBody GoodsIdVO vo) {
        MallEvaluateAllVO mallEvaluateAllVO = goodsOrderService.getGoodsAllEvaluate(vo);
        if(mallEvaluateAllVO.getEvluateNum()==null&&mallEvaluateAllVO.getMallEvaluateVOlist()==null){
            return ServerResponse.createByErrorMessage("未获取到相关数据！");
        }
        return ServerResponse.createBySuccess(mallEvaluateAllVO);
    }

    @PostMapping(value = "/evaluateOrder")
    @ApiOperation(value = "对购买的订单商品进行评价", notes = "对购买的订单商品进行评价", httpMethod = "POST")
    public ServerResponse evaluateOrder(@RequestBody MallEvaluateAddVO vo) {
        int result =  goodsOrderService.evaluateOrder(vo);
        if(result ==0){
            return ServerResponse.createByErrorMessage("对购买的订单商品进行评价失败!");
        }else{
            return ServerResponse.createBySuccess("对购买的订单商品进行评价成功!");
        }
    }

}
