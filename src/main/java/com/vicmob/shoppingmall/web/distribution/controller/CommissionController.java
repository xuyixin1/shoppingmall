package com.vicmob.shoppingmall.web.distribution.controller;

import com.vicmob.shoppingmall.constant.ResponseStatus;
import com.vicmob.shoppingmall.utils.AesEncrypt;
import com.vicmob.shoppingmall.utils.ResultData;
import com.vicmob.shoppingmall.web.distribution.entity.Commission;
import com.vicmob.shoppingmall.web.distribution.service.CommissionService;
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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * @author  xuyx
 */
@RestController
@Validated
@Api(tags="佣金设置")
@RequestMapping(value ="/commission")
@Slf4j
public class CommissionController {
    @Autowired
    private CommissionService commissionService;

    @GetMapping(value="")
    @ApiOperation(value="查询佣金设置")
    @ApiImplicitParam(name = "minaId", value = "小程序id", required = true)
    public ResultData getCommission(@Min(value = 1)@RequestParam("minaId")  Integer minaId){
        ResultData result;
        try{
            Commission commission = commissionService.getCommissionByMinaId(minaId);
            if (commission == null){
                result = new ResultData("佣金数据不存在", ResponseStatus.FAIL.getValue());
            }else{
                result = new ResultData("success", ResponseStatus.SUCCESS.getValue(),commission);
            }
        }catch (Exception e){
            log.error("获取佣金设置失败,minaId ==>{}",minaId );
            log.error(e.getMessage(), e);
            result = new ResultData("获取佣金设置失败", ResponseStatus.FAIL.getValue());
        }
        return result;
    }

    @PostMapping("")
    @ApiOperation(value="添加佣金设置")
    public ResultData addCommission( @RequestBody @Valid Commission commission){
        try{
            String messgae = commission.check();
            if(!StringUtils.isEmpty(messgae)){
                return new ResultData(messgae, ResponseStatus.FAIL.getValue());
            }
            return commissionService.addCommission(commission);
        }catch (Exception e) {
            log.error("获取佣金设置失败 commission==>{}",commission);
            log.error(e.getMessage(), e);
            return new ResultData("获取佣金设置失败", ResponseStatus.FAIL.getValue());
        }
    }

    @PutMapping("")
    @ApiOperation(value="修改佣金设置")
    public ResultData updateCommission(@Valid @RequestBody Commission commission){
        try{
            String messgae = commission.updateCheck();
            if(!StringUtils.isEmpty(messgae)){
                return new ResultData(messgae, ResponseStatus.FAIL.getValue());
            }
            return commissionService.updateCommission(commission);
        }catch (Exception e) {
            log.error("获取佣金设置失败 commission==>{}",commission);
            log.error(e.getMessage(), e);
            return new ResultData("获取佣金设置失败", ResponseStatus.FAIL.getValue());
        }
    }

   /* @DeleteMapping(value="{commissionId}")
    @ApiOperation(value="删除佣金设置列表")
    @ApiImplicitParam(name = "commissionId", value = "佣金id", required = true)*/
    public ResultData delCommission(@Min(value = 1,message ="佣金id不能小于1")@PathVariable("commissionId")  Integer commissionId,
                                    @Min(value = 1)@RequestParam("minaId")  Integer minaId){
        ResultData result;
        try{
            result = commissionService.delCommission(commissionId,minaId);
        }catch (Exception e){
            log.error("删除佣金设置失败,commissionId ==>{}",commissionId );
            log.error(e.getMessage(), e);
            result = new ResultData("删除佣金设置失败", ResponseStatus.FAIL.getValue());
        }
        return result;
    }


    @GetMapping(value="/mp")
    @ApiOperation(value="查询佣金设置")
    @ApiImplicitParams({
            @ApiImplicitParam(name="minaStr",value="小程序id", required = true),
            @ApiImplicitParam(name="appId", value="appId", required = true)
    })
    public ResultData getCommission(@NotEmpty @RequestParam String minaStr,
                                    @NotEmpty @RequestParam String appId){
        try{
            minaStr = AesEncrypt.aesDecryption(appId, minaStr);
            if (StringUtils.isEmpty(minaStr)){
                return new ResultData("minaId解析失败", ResponseStatus.FAIL.value);
            }
            Integer minaId = Integer.valueOf(minaStr);
            Commission commission = commissionService.getCommissionByMinaId(minaId);
            if (commission == null){
                return new ResultData("佣金数据不存在", ResponseStatus.FAIL.getValue());
            }
            return new ResultData("success", ResponseStatus.SUCCESS.getValue(),commission);
        }catch (Exception e){
            log.error("获取佣金设置失败,minaStr ==>{},appId ==>{}",minaStr,appId);
            log.error(e.getMessage(), e);
            return new ResultData("获取佣金设置失败", ResponseStatus.FAIL.getValue());
        }
    }


}
