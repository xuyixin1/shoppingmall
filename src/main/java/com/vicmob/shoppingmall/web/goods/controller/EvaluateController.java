package com.vicmob.shoppingmall.web.goods.controller;

import com.vicmob.shoppingmall.constant.Constant;
import com.vicmob.shoppingmall.constant.ResponseStatus;
import com.vicmob.shoppingmall.utils.ResultData;
import com.vicmob.shoppingmall.utils.ResultDataFactory;
import com.vicmob.shoppingmall.web.goods.entity.Evaluate;
import com.vicmob.shoppingmall.web.goods.service.EvaluateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Api(tags="评价相关接口")
@Validated
@RestController
@RequestMapping("onlineShop/evaluate")
public class EvaluateController {
    private final Logger log = LoggerFactory.getLogger(EvaluateController.class);

    @Autowired
    private EvaluateService evaluateService;
    @GetMapping("")
    @ApiOperation(value="查询评价列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "minaId", value = "小程序id", required = true),
            @ApiImplicitParam(name = "page", value = "当前页码", required = true),
            @ApiImplicitParam(name = "size", value = "每页条数", required = true),
            @ApiImplicitParam(name = "classifyId", value = "一级分类Id"),
            @ApiImplicitParam(name = "secondClassifyId", value = "二级分类Id"),
            @ApiImplicitParam(name = "orderNumber", value = "订单编号"),
            @ApiImplicitParam(name = "goodsNmae", value = "商品名"),
            @ApiImplicitParam(name = "type", value = "时间")
    })
    public ResultData findEvaluateList(@NotNull(message ="page不能为空") @Min(value = 1,message ="page不能小于1")@RequestParam Integer page,
                                       @NotNull(message ="size不能为空") @Min(value = 1,message ="size不能小于1")@RequestParam Integer size,
                                       @NotNull(message ="minaId不能为空") @RequestParam Integer minaId,
                                       @Min(value = 1,message ="classifyId不能小于1")@RequestParam(required = false) Integer classifyId,
                                       @Min(value = 1,message ="secondClassifyId不能小于1") @RequestParam(required = false) Integer secondClassifyId,
                                       @RequestParam(required = false) String orderNumber,
                                       @RequestParam(required = false) String goodsNmae,
                                       @RequestParam(required = false) Constant.TimeType type){
        Evaluate evaluate = null;
        try{
            evaluate = new Evaluate();
            evaluate.setMinaId(minaId);
            evaluate.setClassifyId(classifyId);
            evaluate.setSecondClassifyId(secondClassifyId);
            evaluate.setOrderNumber(orderNumber);
            evaluate.setGoodsName(goodsNmae);
            setSearchTime(evaluate,type);
            List<Evaluate> evaluateList = evaluateService.findEvaluateList(evaluate,page,size);
            return ResultDataFactory.getResultData(evaluateList);

        }catch (Exception e){
            log.error("获取评价列表失败,minaId ==> {},classifyId ==> {},secondClassifyId ==> {},orderNumber ==> {}, goodsNmae ==> {},type==> {}",minaId,classifyId,secondClassifyId,orderNumber,goodsNmae,type);
            log.error(e.getMessage(), e);
            return  new ResultData("获取评价列表失败", ResponseStatus.FAIL.getValue());
        }
    }

    @GetMapping(value = "{evaluateId}")
    @ApiOperation(value="获取评论详情")
    @ApiImplicitParam(name = "evaluateId", value = "主键id", required = true)
    public ResultData getEvaluateById(@Min(value = 1,message ="属性id不能小于1")@PathVariable("evaluateId")  Integer evaluateId){
        ResultData result = null;
        try{
            result = evaluateService.getByEvaluateId(evaluateId);
        }catch(Exception e){
            log.error("获取评价详情失败,evaluateId ==>{}",evaluateId );
            log.error(e.getMessage(), e);
            result = new ResultData("获取商品属性详情失败", ResponseStatus.FAIL.getValue());
        }

        return result;
    }

    @ApiOperation(value="商家回复")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "evaluateId", value = "主键id", required = true),
            @ApiImplicitParam(name = "storeReply", value = "商家回复", required = true),
    })
    @GetMapping("reply")
    public ResultData updateReply(@NotNull(message ="evaluateId不能为空") @Min(value = 1,message ="evaluateId不能小于1")@RequestParam Integer evaluateId,
                            @NotEmpty(message ="商家回复不能为空")@RequestParam String storeReply){
        ResultData result = null;
        try{
            result = evaluateService.updateReply(evaluateId,storeReply);

        }catch (Exception e){
            log.error("商家回复失败，evaluateId ==> {},storeReply ==> {}",evaluateId,storeReply);
            log.error(e.getMessage(), e);
            result =  new ResultData("商家回复失败", ResponseStatus.FAIL.getValue());
        }
        return result;
    }


    @DeleteMapping("")
    @ApiOperation(value="商家屏蔽评价")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "evaluateId", value = "主键id", required = true),
            @ApiImplicitParam(name = "deleteFlag", value = "屏蔽标识", required = true),
    })
    public ResultData deleteEvaluate (@NotNull(message ="evaluateId不能为空") @Min(value = 1,message ="evaluateId不能小于1")@RequestParam Integer evaluateId,
                                      @RequestParam Constant.DeleteFlag1 deleteFlag){
        ResultData result = null;
        try{
            if (deleteFlag == Constant.DeleteFlag1.CUSTOM_DELETE){
                log.error("删除标识错误 deleteFlag ==>{}",deleteFlag);
                result =  new ResultData("商家屏蔽消息失败", ResponseStatus.FAIL.getValue());
            }else{
                result = evaluateService.deleteEvaluate(evaluateId,deleteFlag);
            }
        }catch (Exception e){
            log.error("商家屏蔽消息失败，evaluateId ==> {},storeReply ==> {}",evaluateId,deleteFlag);
            log.error(e.getMessage(), e);
            result =  new ResultData("商家屏蔽消息失败", ResponseStatus.FAIL.getValue());
        }
        return result;
    }



    private  void setSearchTime(Evaluate evaluate,Constant.TimeType type ) {
        if (type == null){
            return;
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startTime = Constant.TimeType.getTime(type,df);
        String endTime = df.format(new Date());
        evaluate.setStartTime(startTime);
        evaluate.setEndTime(endTime);
    }

}
