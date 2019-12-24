package com.vicmob.shoppingmall.web.distribution.controller;

import com.vicmob.shoppingmall.annotation.NotNullMin;
import com.vicmob.shoppingmall.constant.CommissionConstant;
import com.vicmob.shoppingmall.constant.ResponseStatus;
import com.vicmob.shoppingmall.utils.AesEncrypt;
import com.vicmob.shoppingmall.utils.ResultData;
import com.vicmob.shoppingmall.utils.ResultDataFactory;
import com.vicmob.shoppingmall.web.distribution.entity.CommissionRecord;
import com.vicmob.shoppingmall.web.distribution.entity.Withdraw;
import com.vicmob.shoppingmall.web.distribution.entity.WithdrawVO;
import com.vicmob.shoppingmall.web.distribution.entity.WithdrawVO1;
import com.vicmob.shoppingmall.web.distribution.service.WithdrawService;
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
import java.util.List;

/**
 * @author  xuyx
 */
@RestController
@Validated
@Api(tags="提现表")
@RequestMapping(value ="/withdraw")
@Slf4j
public class WithdrawController {
    @Autowired
    private WithdrawService withdrawService;

    @PostMapping("/mp/app")
    @ApiOperation("申请提现")
    public ResultData addWithdraw(@Valid @RequestBody WithdrawVO withdrawVO){
        try {
            Withdraw withdraw = new Withdraw();
            withdraw.fill(withdrawVO);
            return  withdrawService.addWithdraw(withdraw);
        }catch (Exception e){
            log.error("申请提现失败,withdrawVO ==》{}",withdrawVO);
            log.error(e.getMessage(), e);
            return new ResultData("获取分销用户数据失败", ResponseStatus.FAIL.value);
        }
    }


    @GetMapping(value = "")
    @ApiOperation(value="获取提现表数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码", required = true),
            @ApiImplicitParam(name = "size", value = "每页条数", required = true),
            @ApiImplicitParam(name = "minaId", value = "小程序id", required = true),
            @ApiImplicitParam(name = "withdrawNo", value = "申请编号"),
            @ApiImplicitParam(name = "phone", value = "电话号码"),
            @ApiImplicitParam(name = "status", value = "申请状态")
    })
    public ResultData getWithdrawList(@NotNullMin @RequestParam Integer page,
                                              @NotNullMin @RequestParam Integer size,
                                              @NotNullMin @RequestParam Integer minaId,
                                              @RequestParam(required = false) String withdrawNo,
                                              @RequestParam(required = false) String phone,
                                              @RequestParam(required = false) CommissionConstant.WithdrawStatus status){
        try {

            List<Withdraw> withdrawList = withdrawService.getWithdrawList("",withdrawNo,phone,status,minaId,page,size);
            return ResultDataFactory.getResultData(withdrawList);
        }catch (Exception e){
            log.error("获取提现表数据失败,withdrawNo ==>{},phone == >{},status ==>{},minaId ==>{}",withdrawNo,phone,status,minaId);
            log.error(e.getMessage(), e);
            return  new ResultData("获取提现表数据失败", ResponseStatus.FAIL.value);
        }
    }

    @GetMapping(value = "/mp/{distributionUser}")
    @ApiOperation(value="获取提现表数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码", required = true),
            @ApiImplicitParam(name = "size", value = "每页条数", required = true),
            @ApiImplicitParam(name = "distributionUser", value = "分销微信用户id", required = true),
            @ApiImplicitParam(name="minaStr",value="小程序id", required = true),
            @ApiImplicitParam(name="appId", value="appId", required = true),
            @ApiImplicitParam(name = "status", value = "申请状态")
    })
    public ResultData getWithdrawList(@NotNullMin @RequestParam Integer page,
                                      @NotNullMin @RequestParam Integer size,
                                      @NotNull @PathVariable String distributionUser,
                                      @NotEmpty @RequestParam String minaStr,
                                      @NotEmpty @RequestParam String appId,
                                      @RequestParam(required = false) CommissionConstant.WithdrawStatus status){
        try {
            minaStr = AesEncrypt.aesDecryption(appId, minaStr);
            if (StringUtils.isEmpty(minaStr)){
                return new ResultData("minaId解析失败", ResponseStatus.FAIL.value);
            }
            Integer minaId = Integer.valueOf(minaStr);
            List<Withdraw> withdrawList = withdrawService.getWithdrawList(distributionUser,"","",status,minaId,page,size);
            return ResultDataFactory.getResultData(withdrawList);
        }catch (Exception e){
            log.error("获取提现表数据失败,distributionUser ==>{},status ==>{},minaStr ==>{},appId ==>{}",distributionUser,status,minaStr,appId);
            log.error(e.getMessage(), e);
            return  new ResultData("获取提现表数据失败", ResponseStatus.FAIL.value);
        }
    }


    @PutMapping(value = "/updateAuditStatus")
    @ApiOperation(value="更新审核状态")
    public ResultData updateAuditStatus(@Valid @RequestBody WithdrawVO1 withdrawVO1){
        try {
            String message = withdrawVO1.check();
            if (!StringUtils.isEmpty(message)){
                return  new ResultData(message, ResponseStatus.FAIL.value);
            }
            return withdrawService.updateAuditStatus(withdrawVO1.getWithdrawNo(),withdrawVO1.getMinaId(),withdrawVO1.getStatus(),withdrawVO1.getReason());
        }catch (Exception e){
            log.error("更新审核状态失败,dwithdrawVO1 ==>{}",withdrawVO1);
            log.error(e.getMessage(), e);
            return  new ResultData("更新审核状态失败", ResponseStatus.FAIL.value);
        }
    }

    @PutMapping(value = "/pay")
    @ApiOperation(value="打款")
    public ResultData pay(@Valid @RequestBody WithdrawVO1 withdrawVO1){
        try {
            String message = withdrawVO1.payCheck();
            if (!StringUtils.isEmpty(message)){
                return  new ResultData(message, ResponseStatus.FAIL.value);
            }
            return withdrawService.pay(withdrawVO1.getWithdrawNo(),withdrawVO1.getMinaId(),withdrawVO1.getStatus());
        }catch (Exception e){
            log.error("更新审核状态失败,dwithdrawVO1 ==>{}",withdrawVO1);
            log.error(e.getMessage(), e);
            return  new ResultData("更新审核状态失败", ResponseStatus.FAIL.value);
        }
    }

    @PutMapping(value = "/businessCheck")
    @ApiOperation(value="商家确认是否支付")
    public ResultData businessCheck(@Valid @RequestBody WithdrawVO1 withdrawVO1){
        try {
            String message = withdrawVO1.businessCheck();
            if (!StringUtils.isEmpty(message)){
                return  new ResultData(message, ResponseStatus.FAIL.value);
            }
            return withdrawService.businessCheck(withdrawVO1.getWithdrawNo(),withdrawVO1.getMinaId(),withdrawVO1.getStatus());
        }catch (Exception e){
            log.error("商家确认是否支付失败,dwithdrawVO1 ==>{}",withdrawVO1);
            log.error(e.getMessage(), e);
            return  new ResultData("商家确认是否支付失败", ResponseStatus.FAIL.value);
        }
    }
}
