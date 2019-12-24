package com.vicmob.shoppingmall.web.goods.controller;

import com.vicmob.shoppingmall.constant.ResponseStatus;
import com.vicmob.shoppingmall.utils.ResultData;
import com.vicmob.shoppingmall.web.goods.entity.GoodsAttribute;
import com.vicmob.shoppingmall.web.goods.service.GoodsAttributeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Api(tags="属性相关接口")
@Validated
@RestController
@RequestMapping(value = "/onlineShop/goodsAttribute")
public class GoodsAttributeController {
    private final Logger log = LoggerFactory.getLogger(GoodsAttributeController.class);

    @Autowired
    private GoodsAttributeService goodsAttributeService;

    @GetMapping(value = "")
    @ApiOperation(value="查询属性列表", notes="根据二级分类id查询属性值")
    @ApiImplicitParam(name = "secondClassifyId", value = "二级分类id")
    public ResultData getGoodsAttributeList(@NotNull(message ="二级分类id不能为空") @Min(value = 1,message ="二级分类id不能小于1")@RequestParam Integer secondClassifyId) {
        ResultData result = null;
        try{
            List<GoodsAttribute> goodsAttributes = goodsAttributeService.getGoodsAttributeList(secondClassifyId);
            result = new ResultData("success", ResponseStatus.SUCCESS.getValue(),goodsAttributes);

        }catch(Exception e){
            log.error("获取商品属性列表失败，secondClassifyId ==> {}",secondClassifyId );
            log.error(e.getMessage(), e);
            return  new ResultData("获取商品属性列表失败", ResponseStatus.FAIL.getValue());
        }
        return result;
    }

    @GetMapping(value = "{attributeId}")
    @ApiOperation(value="查询属性", notes="根据属性id查询属性值")
    @ApiImplicitParam(name = "attributeId", value = "属性id" ,required = true)
    public ResultData getGoodsAttribute( @Min(value = 1,message ="属性id不能小于1")@PathVariable("attributeId")  Integer attributeId) {
        ResultData result = null;
        try{
            result = goodsAttributeService.getByAttributeId(attributeId);
        }catch(Exception e){
            log.error("获取商品属性详情失败,attributeId ==>{}",attributeId );
            log.error(e.getMessage(), e);
            result = new ResultData("获取商品属性详情失败", ResponseStatus.FAIL.getValue());
        }
        return result;
    }

    /**
     * 添加
     * @return
     */
    @PostMapping(value = "")
    @ApiOperation(value="添加属性列表")
    public ResultData addGoodsAttribute(@RequestBody @Valid  GoodsAttribute goodsAttribute) {
        ResultData result = null;
        try {
            result = goodsAttributeService.addGoodsAttribute(goodsAttribute);
        } catch (Exception e) {
            log.error("商品属性添加失败 GoodsAttribute =>{}", goodsAttribute);
            log.error(e.getMessage(), e);
            result = new ResultData("商品属性添加失败", ResponseStatus.FAIL.getValue());
        }
        return result;
    }

    @PutMapping(value = "")
    @ApiOperation(value="更新属性列表")
    public ResultData updateGoodsAttribute(@RequestBody @Valid  GoodsAttribute goodsAttribute){
        ResultData result = null;
        try {
            result = goodsAttributeService.updateGoodsAttribute(goodsAttribute);
        } catch (Exception e) {
            log.error("商品属性修改失败 GoodsAttribute =>{}", goodsAttribute);
            log.error(e.getMessage(), e);
            result = new ResultData("商品属性修改失败", ResponseStatus.FAIL.getValue());
        }
        return result;
    }

    @DeleteMapping(value = "{attributeId}")
    @ApiOperation(value="删除商品属性")
    @ApiImplicitParam(name = "attributeId", value = "属性id",required = true)
    public ResultData deteleGoodsAttribute(@Min(value = 1,message ="attributeId不能小于1")@PathVariable("attributeId") Integer attributeId){
        ResultData result = null;
        try{
            result = goodsAttributeService.deleteGoodsAttribute(attributeId);
        } catch (Exception e) {
            log.error("删除商品属性 attributeId =>{}", attributeId);
            log.error(e.getMessage(), e);
            result = new ResultData("删除商品属性失败", ResponseStatus.FAIL.getValue());
        }
        return result;
    }

}
