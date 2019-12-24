package com.vicmob.shoppingmall.web.goods.controller;

import com.vicmob.shoppingmall.constant.ResponseStatus;
import com.vicmob.shoppingmall.utils.ResultData;
import com.vicmob.shoppingmall.web.goods.entity.Template;
import com.vicmob.shoppingmall.web.goods.service.TemplateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Api(tags = "模板相关接口")
@Validated
@RestController
@RequestMapping(value = "/onlineShop/template")
public class TemplateController {
    private final Logger log = LoggerFactory.getLogger(TemplateController.class);

    @Autowired
    private TemplateService templateService;

    @GetMapping(value = "")
    @ApiOperation(value="查询模板数据")
    @ApiImplicitParam(name = "minaId", value = "小程序id",required = true)
    public ResultData findTemplateList(@NotNull(message="minaId不能为空") @RequestParam Integer minaId) {
        ResultData result = null;
        try{
            List<Template> templates = templateService.findTemplatList(minaId);
            result = new ResultData("sucess", ResponseStatus.SUCCESS.getValue(),templates);
        }catch (Exception e){
            log.error("获取模板列表失败,mianId ==>{}",minaId);
            log.error(e.getMessage(), e);
            result =  new ResultData("获取模板列表失败", ResponseStatus.FAIL.getValue());
        }
       return result;
    }

    @PostMapping(value = "save")
    @ApiOperation(value="保存模板数据")
    public ResultData sveTemplateList(@RequestBody @Valid  List<Template> templates){
        ResultData result = null;
        try{
            result = templateService.sveTemplateList(templates);
        }catch (Exception e){
            log.error("保存模板列表失败,templates ==>{}",templates);
            log.error(e.getMessage(), e);
            result = new ResultData("保存模板列表失败", ResponseStatus.FAIL.getValue());
        }
        return result;
    }
}
