package com.vicmob.shoppingmall.web.distribution.controller;


import com.vicmob.shoppingmall.annotation.NotNullMin;
import com.vicmob.shoppingmall.constant.ResponseStatus;
import com.vicmob.shoppingmall.utils.AesEncrypt;
import com.vicmob.shoppingmall.utils.ResultData;
import com.vicmob.shoppingmall.utils.ResultDataFactory;
import com.vicmob.shoppingmall.web.distribution.entity.Customer;
import com.vicmob.shoppingmall.web.distribution.service.CustomerService;
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
import java.util.List;

/**
 * @author  xuyx
 */
@RestController
@Validated
@Api(tags="分销用户详情")
@RequestMapping(value ="/customer")
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "")
    @ApiOperation(value="获取分销用户数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码", required = true),
            @ApiImplicitParam(name = "size", value = "每页条数", required = true),
            @ApiImplicitParam(name = "minaId", value = "小程序id", required = true),
            @ApiImplicitParam(name = "nickName", value = "微信昵称")
    })
    public ResultData getCustomerList(@NotNullMin @RequestParam Integer page,
                                      @NotNullMin @RequestParam Integer size,
                                      @NotNullMin @RequestParam Integer minaId,
                                      @RequestParam(required = false) String nickName){
        ResultData result;
        try {
            List<Customer> customerList = customerService.getCustomerList(minaId,nickName,page,size);
            result = ResultDataFactory.getResultData(customerList);

        }catch (Exception e){
            log.error("获取分销用户数据失败,minaId  ==>{}, nickName ==>{}",minaId,nickName);
            log.error(e.getMessage(), e);
            result = new ResultData("获取分销用户数据失败", ResponseStatus.FAIL.value);
        }
        return result;
    }


    @GetMapping(value = "/mp/{customerId}")
    @ApiOperation(value="获取分销用户数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "customerId", value = "客户id", required = true),
            @ApiImplicitParam(name="minaStr",value="小程序id", required = true),
            @ApiImplicitParam(name="appId", value="appId", required = true),
    })
    public ResultData getCustomerByCustomerId(@NotEmpty @RequestParam String minaStr,
                                              @NotEmpty @RequestParam String appId,
                                              @NotNullMin @PathVariable Integer customerId){
        try {
            minaStr = AesEncrypt.aesDecryption(appId, minaStr);
            if (StringUtils.isEmpty(minaStr)){
                return new ResultData("minaId解析失败", ResponseStatus.FAIL.value);
            }
            Integer minaId = Integer.valueOf(minaStr);
            Customer customer = customerService.getCustomerByCustomerId(minaId,customerId);
            if(customer == null){
                log.error("customer不存在,minaStr  ==>{}, appId ==>{}, customerId ==>{}",minaStr,appId,customerId);
                return new ResultData("customer不存在", ResponseStatus.SUCCESS.value,customer);
            }
            return new ResultData("success", ResponseStatus.SUCCESS.value,customer);

        }catch (Exception e){
            log.error("获取分销用户数据失败,minaStr  ==>{}, appId ==>{}, customerId ==>{}",minaStr,appId,customerId);
            log.error(e.getMessage(), e);
            return new ResultData("获取分销用户数据失败", ResponseStatus.FAIL.value);
        }
    }



}
