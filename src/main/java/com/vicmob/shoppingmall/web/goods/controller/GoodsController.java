package com.vicmob.shoppingmall.web.goods.controller;

import com.vicmob.shoppingmall.annotation.NotNullMin;
import com.vicmob.shoppingmall.constant.Constant;
import com.vicmob.shoppingmall.constant.ResponseStatus;
import com.vicmob.shoppingmall.utils.AesEncrypt;
import com.vicmob.shoppingmall.utils.ResultData;
import com.vicmob.shoppingmall.utils.ResultDataFactory;
import com.vicmob.shoppingmall.web.goods.entity.Goods;
import com.vicmob.shoppingmall.web.goods.entity.Specification;
import com.vicmob.shoppingmall.web.goods.service.GoodsService;
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

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;
@Api(tags = "商品相关接口")
@Validated
@RestController
@RequestMapping(value = "/onlineShop/goods")
public class GoodsController {
    private final Logger log = LoggerFactory.getLogger(GoodsController.class);

    @Autowired
    private GoodsService goodsService;

    @GetMapping(value = "")
    @ApiOperation(value="获取商品数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "classifyId", value = "一级分类id"),
            @ApiImplicitParam(name = "secondClassifyId", value = "二级分类id"),
            @ApiImplicitParam(name = "goodsName", value = "商品名称"),
            @ApiImplicitParam(name = "saleFlag", value = "上下架状态"),
            @ApiImplicitParam(name = "page", value = "当前页码", required = true),
            @ApiImplicitParam(name = "size", value = "每页条数", required = true),
            @ApiImplicitParam(name = "minaId", value = "小程序id", required = true)
    })
    public ResultData findGoodsList(@RequestParam(required=false) Integer classifyId,
                                    @RequestParam(required=false) Integer secondClassifyId,
                                    @RequestParam(required=false) String goodsName,
                                    @RequestParam(required=false) Constant.SaleFlag saleFlag,
                                    @RequestParam Integer page,
                                    @RequestParam Integer size,
                                    @RequestParam Integer minaId){
        Goods goods = null;
        try{
            goods = new Goods();
            if(classifyId != null) {
               goods.setClassifyId(classifyId);
            }
            if(secondClassifyId != null) {
                goods.setSecondClassifyId(secondClassifyId);
            }
            if(!StringUtils.isEmpty(goodsName)) {
                goods.setGoodsName(goodsName);
            }
            goods.setSaleFlag(saleFlag);
            goods.setDeleteFlag(Constant.DeleteFlag.NO);
            List<Goods> list = goodsService.getGoodsList(goods,minaId,page,size);
            return ResultDataFactory.getResultData(list);

        }catch(Exception e){
            log.error("获取商品列表失败,mianId ==>{}，goods ==>{}",minaId,goods);
            log.error(e.getMessage(), e);
            return  new ResultData("获取商品列表失败", ResponseStatus.FAIL.getValue());
        }
    }


    @GetMapping(value = "{goodsId}")
    @ApiOperation(value="获取商品数据")
    @ApiImplicitParam(name = "goodsId", value = "商品id",required = true)
    public ResultData getByGoodsId(@Min(value = 1,message ="商品id不能小于1")@PathVariable Integer goodsId){
        ResultData result = null;
        try{
           result = goodsService.getByGoodsId(goodsId);
        }catch(Exception e){
            log.error("获取商品详情失败,goodsId ==>{}",goodsId );
            log.error(e.getMessage(), e);
            result = new ResultData("获取商品分类详情失败", ResponseStatus.FAIL.getValue());
        }

        return result;
    }

    @ApiOperation(value="删除商品数据")
    @ApiImplicitParam(name = "goodsId", value = "商品id",required = true)
    @DeleteMapping(value = "{goodsId}")
    public ResultData deleteGoodsList(@PathVariable Integer goodsId){
        ResultData result = null;
        try{
            result = goodsService.deleteByGoodsId(goodsId);
        }catch(Exception e){
            log.error("删除商品失败,goodsId ==>{}",goodsId );
            log.error(e.getMessage(), e);
            result = new ResultData("删除商品失败", ResponseStatus.FAIL.getValue());
        }
        return result;
    }

    @GetMapping(value = "updateSaleFlag/{goodsId}")
    @ApiOperation(value="更新商品上下架状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "goodsId", value = "商品id",required = true),
            @ApiImplicitParam(name = "saleFlag", value = "上下架状态",required = true)
    })
    public ResultData updateSaleFlag(@PathVariable Integer goodsId,
                                     @RequestParam Constant.SaleFlag saleFlag){
        ResultData result = null;
        try{
            result = goodsService.updateSaleFlag(goodsId,saleFlag);
        }catch(Exception e){
            log.error("更新商品上下架状态失败,goodsId ==>{}，saleFlag ==>{}",goodsId,saleFlag );
            log.error(e.getMessage(), e);
            result = new ResultData("更新商品上下架状态失败", ResponseStatus.FAIL.getValue());
        }
        return result;
    }

    @GetMapping(value = "updateDistributionFlag/{goodsId}")
    @ApiOperation(value="更新商品分销状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "goodsId", value = "商品id",required = true),
            @ApiImplicitParam(name = "saleFlag", value = "上下架状态",required = true)
    })
    public ResultData updateDistributionFlag(@PathVariable Integer goodsId,
                                     @RequestParam Constant.Flag distributionFlag){
        ResultData result = null;
        try{
            result = goodsService.updateDistributionFlag(goodsId,distributionFlag);
        }catch(Exception e){
            log.error("更新商品分销状态失败,goodsId ==>{}，distributionFlag ==>{}",goodsId,distributionFlag );
            log.error(e.getMessage(), e);
            result = new ResultData("更新商品分销状态失败", ResponseStatus.FAIL.getValue());
        }
        return result;
    }

    @PostMapping(value = "")
    @ApiOperation(value="添加商品数据")
    public ResultData addGoods(@RequestBody @Valid Goods goods){

        ResultData result = null;
        try{
            if (goods.getSailed() == null){
                goods.setSailed(0);
            }
            result = goodsService.addGoods(goods);

        }catch(Exception e){
            log.error("添加商品失败,goods ==>{}",goods);
            log.error(e.getMessage(), e);
            result = new ResultData("添加商品失败", ResponseStatus.FAIL.getValue());
        }
        return result;
    }


    @PutMapping(value = "")
    @ApiOperation(value="更新商品数据")
    public ResultData updateGoods(@RequestBody @Valid Goods goods){

        ResultData result = null;
        try{
            if(goods.getGoodsId() == null ||goods.getGoodsId() <= 0){
                log.error("验证商品参数失败,goodsId不存在或者小于0，goods ==>{}",goods);
                result = new ResultData("验证商品参数失败,goodsId不存在或者小于0", ResponseStatus.FAIL.getValue());
            }else{
                if (goods.getSailed() == null){
                    goods.setSailed(0);
                }
                result = goodsService.updateGoods(goods);
            }
        }catch(Exception e){
            log.error("添加商品失败,goods ==>{}",goods);
            log.error(e.getMessage(), e);
            result = new ResultData("添加商品失败", ResponseStatus.FAIL.getValue());
        }
        return result;
    }

    @GetMapping(value ="/mp")
    @ApiOperation(value="获取商品数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name="minaStr",value="小程序id", required = true),
            @ApiImplicitParam(name="appId", value="appId", required = true),
            @ApiImplicitParam(name = "goodsName", value = "商品名称"),
            @ApiImplicitParam(name = "page", value = "当前页码", required = true),
            @ApiImplicitParam(name = "size", value = "每页条数", required = true),
    })
    public ResultData findGoodsList(@NotEmpty @RequestParam String minaStr,
                                    @NotEmpty @RequestParam String appId,
                                    @NotNullMin @RequestParam Integer page,
                                    @NotNullMin @RequestParam Integer size,
                                    @RequestParam(required = false) String goodsName){
        Goods goods = new Goods();
        try{
            minaStr = AesEncrypt.aesDecryption(appId, minaStr);
            if (StringUtils.isEmpty(minaStr)){
                return new ResultData("minaId解析失败", ResponseStatus.FAIL.value);
            }
            Integer minaId = Integer.valueOf(minaStr);
            goods.setDeleteFlag(Constant.DeleteFlag.NO);
            goods.setDistributionFlag(Constant.Flag.YES);
            goods.setGoodsName(goodsName);
            List<Goods> list = goodsService.getGoodsList(goods,minaId,page,size);
            return ResultDataFactory.getResultData(list);

        }catch(Exception e){
            log.error("获取商品列表失败,appId ==>{},minaStr ==>{},goods ==>{}",appId,minaStr,goods);
            log.error(e.getMessage(), e);
            return  new ResultData("获取商品列表失败", ResponseStatus.FAIL.getValue());
        }
    }
}




