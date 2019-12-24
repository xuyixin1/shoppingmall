package com.vicmob.shoppingmall.web.distribution.controller;


import com.vicmob.shoppingmall.annotation.NotNullMin;
import com.vicmob.shoppingmall.constant.CommissionConstant;
import com.vicmob.shoppingmall.constant.ResponseStatus;
import com.vicmob.shoppingmall.utils.AesEncrypt;
import com.vicmob.shoppingmall.utils.ResultData;
import com.vicmob.shoppingmall.utils.ResultDataFactory;
import com.vicmob.shoppingmall.web.distribution.entity.CommissionRecord;
import com.vicmob.shoppingmall.web.distribution.service.CommissionRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * @author  xuyx
 */
@RestController
@Validated
@Api(tags="佣金详情")
@RequestMapping(value ="/commissionRecord")
@Slf4j
public class CommissionRecordController {

    @Autowired
    private CommissionRecordService commissionRecordService;

    @GetMapping(value = "{distributionUser}")
    @ApiOperation(value="获取佣金详情数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码", required = true),
            @ApiImplicitParam(name = "size", value = "每页条数", required = true),
            @ApiImplicitParam(name = "distributionUser", value = "分销微信用户id", required = true),
            @ApiImplicitParam(name = "minaId", value = "小程序id", required = true),
            @ApiImplicitParam(name = "orderNumber", value = "订单编号"),
            @ApiImplicitParam(name = "status", value = "佣金状态")
    })
    public ResultData getCommissionRecordList(@NotNullMin @RequestParam Integer page,
                                              @NotNullMin @RequestParam Integer size,
                                              @NotNull @PathVariable String distributionUser,
                                              @NotNullMin @RequestParam Integer minaId,
                                              @RequestParam(required = false) String orderNumber,
                                              @RequestParam(required = false) CommissionConstant.CommissionStatus status){
        try {
            List<CommissionConstant.CommissionStatus> list = getStatus(status);
            if (list == null ){
                return  new ResultData("非法的状态", ResponseStatus.FAIL.value);
            }
            List<CommissionRecord> commissionRecordList = commissionRecordService.getCommissionRecordList(distributionUser,orderNumber,list,minaId,page,size);
            return ResultDataFactory.getResultData(commissionRecordList);

        }catch (Exception e){
            log.error("获取佣金详情数据失败,distributionUser ==>{},orderNumber ==>{},status ==>{}",distributionUser,orderNumber,status);
            log.error(e.getMessage(), e);
            return  new ResultData("获取佣金详情数据失败", ResponseStatus.FAIL.value);
        }
    }


    @GetMapping(value = "/mp/{distributionUser}")
    @ApiOperation(value="获取佣金详情数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码", required = true),
            @ApiImplicitParam(name = "size", value = "每页条数", required = true),
            @ApiImplicitParam(name = "distributionUser", value = "分销微信用户id", required = true),
            @ApiImplicitParam(name="minaStr",value="小程序id", required = true),
            @ApiImplicitParam(name="appId", value="appId", required = true),
            @ApiImplicitParam(name = "status", value = "佣金状态")
    })
    public ResultData getCommissionRecordList(@NotNullMin @RequestParam Integer page,
                                              @NotNullMin @RequestParam Integer size,
                                              @NotEmpty @PathVariable String distributionUser,
                                              @NotEmpty @RequestParam String minaStr,
                                              @NotEmpty @RequestParam String appId,
                                              @RequestParam(required = false) CommissionConstant.CommissionStatus status){
        try {
            minaStr = AesEncrypt.aesDecryption(appId, minaStr);
            if (StringUtils.isEmpty(minaStr)){
                return new ResultData("minaId解析失败", ResponseStatus.FAIL.value);
            }
            Integer minaId = Integer.valueOf(minaStr);
            List<CommissionConstant.CommissionStatus> list = getStatus(status);
            if (list == null ){
                return  new ResultData("非法的状态", ResponseStatus.FAIL.value);
            }
            List<CommissionRecord> commissionRecordList = commissionRecordService.getCommissionRecordList(distributionUser,"",list,minaId,page,size);
            return ResultDataFactory.getResultData(commissionRecordList);

        }catch (Exception e){
            log.error("获取佣金详情数据失败,distributionUser ==>{},status ==>{},minaStr ==>{},appId ==>{}",distributionUser,status,minaStr,appId);
            log.error(e.getMessage(), e);
            return  new ResultData("获取佣金详情数据失败", ResponseStatus.FAIL.value);
        }
    }


    private List<CommissionConstant.CommissionStatus> getStatus(CommissionConstant.CommissionStatus status){
        if (status != null && status == CommissionConstant.CommissionStatus.PAYED){
            return  null;
        }
        List<CommissionConstant.CommissionStatus> list = new ArrayList<>();
        if (status != null){
            if(status == CommissionConstant.CommissionStatus.UNBOOKED){
                list.add(CommissionConstant.CommissionStatus.UNBOOKED);
                list.add(CommissionConstant.CommissionStatus.PAYED);
            }else {
                list.add(status);
            }
        }
        if (status == null){
            list.add(CommissionConstant.CommissionStatus.PAYED);
            list.add(CommissionConstant.CommissionStatus.INVALID);
            list.add(CommissionConstant.CommissionStatus.UNBOOKED);
            list.add(CommissionConstant.CommissionStatus.BOOKED);
        }
       return list;
    }

}
