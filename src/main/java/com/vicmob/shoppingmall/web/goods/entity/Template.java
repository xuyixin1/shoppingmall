package com.vicmob.shoppingmall.web.goods.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.vicmob.shoppingmall.constant.Constant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.util.HtmlUtils;

import javax.validation.constraints.NotNull;

/**
 * 模板消息实体
 *
 */
@ApiModel(description= "消息模板")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Template {
    @ApiModelProperty(value = "模板主键")
    private Integer templateId;
    @NotNull(message ="小程序id不能为空")
    @ApiModelProperty(value = "小程序id",required = true)
    private Integer minaId;
    @ApiModelProperty(value = "消息类型",required = true)
    private Constant.InformType informType;
    @ApiModelProperty(value = "模板消息id",required = true)
    @NotNull(message ="模板消息id不能为空")
    private String informId;
    // 开关状态 0发送 1不发送
    private Constant.SendFlag sendFlag;

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    public Integer getMinaId() {
        return minaId;
    }

    public void setMinaId(Integer minaId) {
        this.minaId = minaId;
    }

    public Constant.InformType getInformType() {
        return informType;
    }

    public void setInformType(Constant.InformType informType) {
        this.informType = informType;
    }

    public String getInformId() {
        return informId;
    }

    public void setInformId(String informId) {
        this.informId = informId;
    }

    public Constant.SendFlag getSendFlag() {
        return sendFlag;
    }

    public void setSendFlag(Constant.SendFlag sendFlag) {
        this.sendFlag = sendFlag;
    }

    @Override
    public String toString() {
        return "Template{" +
                "templateId=" + templateId +
                ", minaId=" + minaId +
                ", informType=" + informType +
                ", informId='" + informId + '\'' +
                ", sendFlag=" + sendFlag +
                '}';
    }
}