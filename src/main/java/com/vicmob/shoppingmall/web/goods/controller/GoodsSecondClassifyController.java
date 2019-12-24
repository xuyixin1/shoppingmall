package com.vicmob.shoppingmall.web.goods.controller;

import com.vicmob.shoppingmall.constant.ResponseStatus;
import com.vicmob.shoppingmall.utils.MySqlUtils;
import com.vicmob.shoppingmall.utils.ResultData;
import com.vicmob.shoppingmall.utils.ResultDataFactory;
import com.vicmob.shoppingmall.web.goods.entity.GoodsSecondClassify;
import com.vicmob.shoppingmall.web.goods.service.GoodsSecondClassifyService;
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
import javax.validation.constraints.NotNull;
import java.util.List;

@Api(tags = "商品二级分类相关接口")
@Validated
@RestController
@RequestMapping(value = "/onlineShop/goodsSecondClassify")
public class GoodsSecondClassifyController {
    private final Logger log = LoggerFactory.getLogger(GoodsSecondClassifyController.class);

    @Autowired
    private GoodsSecondClassifyService goodsSecondClassifyService;

    @GetMapping(value = "findAllList")
    @ApiOperation(value="查询二级分类列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "secondClassifyName", value = "二级分类名称"),
            @ApiImplicitParam(name = "classifyId", value = "一级分类id", required = true),
            @ApiImplicitParam(name = "page", value = "当前页码", required = true),
            @ApiImplicitParam(name = "size", value = "每页条数", required = true)
    })
    public ResultData findAllList(@RequestParam(required=false) String secondClassifyName,
                               @NotNull(message ="classifyId不能为空") @Min(value = 1,message ="classifyId不能小于1") @RequestParam Integer classifyId,
                               @NotNull(message ="page不能为空") @Min(value = 1,message ="page不能小于1") @RequestParam Integer page,
                               @NotNull(message ="size不能为空") @Min(value = 1,message ="size不能小于1") @RequestParam Integer size) {
        try{
            GoodsSecondClassify goodsSecondClassify = new GoodsSecondClassify();
            if(!StringUtils.isEmpty(secondClassifyName)) {
                goodsSecondClassify.setSecondClassifyName(MySqlUtils.specialStr(secondClassifyName));
            }
            goodsSecondClassify.setClassifyId(classifyId);
            List<GoodsSecondClassify> list = goodsSecondClassifyService.getGoodsSecondClassifyList(goodsSecondClassify,page,size);
            return ResultDataFactory.getResultData(list);
        }catch(Exception e){
            log.error("获取二级分类列表失败,classifyName ==>{},classifyId ==>",secondClassifyName,classifyId);
            log.error(e.getMessage(), e);
            return  new ResultData("获取二级分类列表失败", ResponseStatus.FAIL.getValue());
        }
    }

    @GetMapping(value = "")
    @ApiOperation(value="查询二级分类数据（不分页）")
    @ApiImplicitParam(name = "classifyId", value = "一级分类id",required = true)
    public ResultData findList(@NotNull(message ="classifyId不能为空") @Min(value = 1,message ="classifyId不能小于1") @RequestParam Integer classifyId) {
        ResultData result = null ;
        try{
            GoodsSecondClassify goodsSecondClassify = new GoodsSecondClassify();
            goodsSecondClassify.setClassifyId(classifyId);
            result  = goodsSecondClassifyService.getGoodsSecondClassifyList(goodsSecondClassify);
        }catch(Exception e){
            log.error("获取二级分类列表失败 classifyId ==>",classifyId);
            log.error(e.getMessage(), e);
            result = new ResultData("获取二级分类列表失败", ResponseStatus.FAIL.getValue());
        }
        return  result;
    }

    @GetMapping(value = "{secondClassifyId}")
    @ApiOperation(value="查询二级分类数据")
    @ApiImplicitParam(name = "secondClassifyId", value = "二级分类id",required = true)
    public ResultData getClassify(@Min(value = 1,message ="secondClassifyId不能小于1")@PathVariable("secondClassifyId") Integer secondClassifyId) {
        ResultData result = null;
        try{
            GoodsSecondClassify goodsSecondClassify = goodsSecondClassifyService.getByClassifyId(secondClassifyId);
            if (goodsSecondClassify == null){
                log.error("获取二级分类详情失败,secondClassifyId ==>{}" ,secondClassifyId );
                result = new ResultData("获取二级分类详情失败", ResponseStatus.FAIL.getValue());
            }else{
                result = new ResultData("sucess", ResponseStatus.SUCCESS.getValue(),goodsSecondClassify);
            }
        }catch(Exception e){
            log.error("获取二级分类详情失败,secondClassifyId ==>{}",secondClassifyId );
            log.error(e.getMessage(), e);
            result = new ResultData("获取二级分类详情失败", ResponseStatus.FAIL.getValue());
        }
        return result;
    }

    /**
     * 添加
     * @return
     */
    @PostMapping(value = "")
    @ApiOperation(value="添加二级分类")
    public ResultData addGoodsSecondClassify(@RequestBody @Valid GoodsSecondClassify goodsSecondClassify) {
        ResultData result = null;
        try {
            result = goodsSecondClassifyService.addGoodsSecondClassify(goodsSecondClassify);
        } catch (Exception e) {
            log.error("二级分类插入失败 goodsSecondClassify =>{}",goodsSecondClassify);
            log.error(e.getMessage(), e);
            result = new ResultData("二级分类插入失败", ResponseStatus.FAIL.getValue());
        }
        return result;
    }

    @PutMapping(value = "")
    @ApiOperation(value="更新二级分类")
    public ResultData updateGoodsSecondClassify(@RequestBody @Valid GoodsSecondClassify goodsSecondClassify) {
        ResultData result = null;
        try {
            if(goodsSecondClassify.getSecondClassifyId() == null ||goodsSecondClassify.getSecondClassifyId()<= 0){
                log.error("验证二级分类参数失败,secondClassifyId不存在或者小于0，goodsSecondClassify ==>{}",goodsSecondClassify);
                result = new ResultData("验证二级分类参数失败,secondGoodsId不存在或者小于0", ResponseStatus.FAIL.getValue());
            }else {
                result = goodsSecondClassifyService.updateGoodsSecondClassify(goodsSecondClassify);
            }
        } catch (Exception e) {
            log.error("二级分类插入失败 goodsSecondClassify =>{}",goodsSecondClassify);
            log.error(e.getMessage(), e);
            result = new ResultData("二级分类插入失败", ResponseStatus.FAIL.getValue());
        }
        return result;
    }

    @DeleteMapping(value = "{secondClassifyId}")
    @ApiOperation(value="删除二级分类数据")
    @ApiImplicitParam(name = "secondClassifyId", value = "二级分类id",required = true)
    public ResultData deleteGoodsSecondClassify(@PathVariable("secondClassifyId") Integer secondClassifyId) {
        ResultData result = null;
        try {
            result = goodsSecondClassifyService.deleteGoodsSecondClassify(secondClassifyId);
        } catch (Exception e) {
            log.error("二级分类删除失败 secondClassifyId =>{}",secondClassifyId);
            log.error(e.getMessage(), e);
            result = new ResultData("二级分类删除失败", ResponseStatus.FAIL.getValue());
        }
        return result;
    }


}
