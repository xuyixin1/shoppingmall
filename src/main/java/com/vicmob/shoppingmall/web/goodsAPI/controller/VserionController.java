package com.vicmob.shoppingmall.web.goodsAPI.controller;

import com.vicmob.shoppingmall.constant.ResponseStatus;
import com.vicmob.shoppingmall.utils.AesEncrypt;
import com.vicmob.shoppingmall.utils.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;

@RestController
@RequestMapping(value = "/vesionCheck")
@Slf4j
@Api(tags="版本检测")
public class VserionController {
    @Value("${version}")
    private String currentVersion;

    @GetMapping(value = "")
    @ApiOperation(value="获取当前版本")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "version", value = "版本号", required = true),
            @ApiImplicitParam(name="minaStr",value="小程序id", required = true),
            @ApiImplicitParam(name="appId", value="appId", required = true),
    })
    public ResultData getVserion(@NotEmpty @RequestParam String minaStr,
                                 @NotEmpty @RequestParam String appId,
                                 @NotEmpty @RequestParam String version
    ){
        ResultData result = null;
        try{
            minaStr = AesEncrypt.aesDecryption(appId, minaStr);
            if (StringUtils.isEmpty(minaStr)){
                return new ResultData("minaId解析失败", ResponseStatus.FAIL.value);
            }
            String[] versions = version.split("\\.");
            if(versions.length != 2){
                return new ResultData("版本号不合法", ResponseStatus.FAIL.value);
            }
            Integer bigVersion = Integer.valueOf(versions[0]);
            Integer currentBigVersion = Integer.valueOf(currentVersion.split("\\.")[0]);
            if (bigVersion < currentBigVersion){
                return new ResultData("商城正在升级中,请稍后再试", ResponseStatus.VERSION_LOWER.value);
            }
            return new ResultData("success", ResponseStatus.SUCCESS.value);

        }catch(Exception e){
            log.error("获取当前版本失败,version ==>{},minaStr ==>{},appId ==>{}",version );
            log.error(e.getMessage(), e);
            result = new ResultData("获取当前版本失败", ResponseStatus.FAIL.getValue());
        }
        return result;
    }
}
