package com.vicmob.shoppingmall.web.goods.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.vicmob.shoppingmall.constant.Constant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(description= "幻灯片信息")
public class Slide {
    @ApiModelProperty(value = "幻灯片id,更新时必填")
    private Integer slideId;
    @ApiModelProperty(value = "小程序id",required = true)
    @NotNull(message = "小程序id不能为空")
    private Integer minaId;
    @NotEmpty(message="幻灯片名不能为空")
    @ApiModelProperty(value = "幻灯片名",required = true)
    private String slideName;
    @ApiModelProperty(value = "幻灯片url",required = true)
    @NotEmpty(message="幻灯片url不能为空")
    private String picUrl;
    @ApiModelProperty(value = "启用状态",required = true)
    private Constant.Flag useFlag;
    @ApiModelProperty(value = "一级分类id")
    private Integer classifyId;
    @ApiModelProperty(value = "二级分类id")
    private Integer secondClassifyId;
    @ApiModelProperty(value = "商品id")
    private Integer goodsId;

    public Integer getSlideId() {
        return slideId;
    }

    public void setSlideId(Integer slideId) {
        this.slideId = slideId;
    }

    public Integer getMinaId() {
        return minaId;
    }

    public void setMinaId(Integer minaId) {
        this.minaId = minaId;
    }

    public String getSlideName() {
        return slideName;
    }

    public void setSlideName(String slideName) {
        this.slideName = slideName;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Constant.Flag getUseFlag() {
        return useFlag;
    }

    public void setUseFlag(Constant.Flag useFlag) {
        this.useFlag = useFlag;
    }

    public Integer getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(Integer classifyId) {
        this.classifyId = classifyId;
    }

    public Integer getSecondClassifyId() {
        return secondClassifyId;
    }

    public void setSecondClassifyId(Integer secondClassifyId) {
        this.secondClassifyId = secondClassifyId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public String toString() {
        return "Slide{" +
                "slideId=" + slideId +
                ", minaId=" + minaId +
                ", slideName='" + slideName + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", useFlag=" + useFlag +
                ", classifyId=" + classifyId +
                ", secondClassifyId=" + secondClassifyId +
                ", goodsId=" + goodsId +
                '}';
    }
}
