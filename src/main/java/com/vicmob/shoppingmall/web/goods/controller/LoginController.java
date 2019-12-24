package com.vicmob.shoppingmall.web.goods.controller;

import com.vicmob.shoppingmall.constant.Constant;
import com.vicmob.shoppingmall.constant.ResponseStatus;
import com.vicmob.shoppingmall.utils.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@Api(tags="文件上传接口")
@Validated
@Controller
@RequestMapping(value = "login")
public class LoginController {
    private final Logger log = LoggerFactory.getLogger(LoginController.class);

   @RequestMapping("tologin")
   public  String  login(){
       return "index";
   }
}
