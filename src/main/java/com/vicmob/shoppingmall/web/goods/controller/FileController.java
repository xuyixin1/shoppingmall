package com.vicmob.shoppingmall.web.goods.controller;

import com.vicmob.shoppingmall.constant.Constant;
import com.vicmob.shoppingmall.constant.ResponseStatus;
import com.vicmob.shoppingmall.utils.AesEncrypt;
import com.vicmob.shoppingmall.utils.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
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
@RestController
@RequestMapping(value = "common")
public class FileController {
    private final Logger log = LoggerFactory.getLogger(FileController.class);


    @Value("${web.upload-path}")
    private String rootPath;

    @RequestMapping (value = "/upload",headers = "content-type=multipart/form-data")
    @ApiOperation(value="上传文件")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "upType", value = "文件类型", required = true),
            @ApiImplicitParam(name = "minaId", value = "小程序Id", required = true),
    })
    public ResultData uploadFile(@RequestParam("file") MultipartFile[] files,
                                 @RequestParam Constant.UpLoadType upType,
                                 @NotEmpty(message ="小程序Id不能为空")@RequestParam String minaId){

        return getUrl(files,upType,minaId);
    }


    @RequestMapping (value = "/mp/upload",headers = "content-type=multipart/form-data")
    @ApiOperation(value="上传文件")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "upType", value = "文件类型", required = true),
            @ApiImplicitParam(name="minaStr",value="小程序id", required = true),
            @ApiImplicitParam(name="appId", value="appId", required = true)
    })
    public ResultData mpUploadFile(@RequestParam("file") MultipartFile[] files,
                                   @RequestParam Constant.UpLoadType upType,
                                   @NotEmpty @RequestParam String minaStr,
                                   @NotEmpty @RequestParam String appId){

        minaStr = AesEncrypt.aesDecryption(appId, minaStr);
        if (StringUtils.isEmpty(minaStr)){
            return new ResultData("minaId解析失败", ResponseStatus.FAIL.value);
        }
        return getUrl(files,upType,minaStr);
    }

    private ResultData getUrl(MultipartFile[] files,Constant.UpLoadType upType,String minaId){
        String typePakage = "";
        ResultData result = null;
        String allPath = "";
        try {
            if(Constant.UpLoadType.IMG.equals(upType)) {
                typePakage = "image";
            } else if (Constant.UpLoadType.MUSIC.equals(upType)) {
                typePakage = "music";
            } else if (Constant.UpLoadType.VIDEO.equals(upType)) {
                typePakage = "video";
            } else if (Constant.UpLoadType.TITLEIMG.equals(upType)) {
                typePakage = "image";
            }
            //获取上传文件名,包含后缀
            for ( MultipartFile file :files ) {
                String originalFilename = file.getOriginalFilename();
                //获取后缀
                String fileName = System.currentTimeMillis() + originalFilename.substring(originalFilename.lastIndexOf("."));
                //保存的文件名

                Date data = new Date(System.currentTimeMillis());
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
                // 日期
                String dataPakage = dateFormat.format(data);

                //服务器所需路径
                String path =   "minaId" + minaId + "/" + typePakage + "/" + dataPakage;
                allPath =  path  + "/" + fileName + Constant.FILE_SEPARATE;
                File uploadFile = new File(rootPath + path, fileName);
                if (!uploadFile.exists() && !uploadFile.isDirectory()) {
                    uploadFile.mkdirs();// 创建文件夹
                }
                file.transferTo(uploadFile);
            }
            if (StringUtils.isEmpty(allPath)) {
                result = new ResultData("success", ResponseStatus.SUCCESS.getValue());
            }else{
                result = new ResultData("success", ResponseStatus.SUCCESS.getValue(),allPath.substring(0,allPath.length()-2));
            }
        } catch (Exception e) {
            log.error("上传文件失败" );
            log.error(e.getMessage(), e);
            result = new ResultData("上传文件失败", ResponseStatus.FAIL.getValue());
        }
        return result;
    }
}
