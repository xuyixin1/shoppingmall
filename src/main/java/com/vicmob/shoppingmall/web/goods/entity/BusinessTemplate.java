package com.vicmob.shoppingmall.web.goods.entity;

import com.vicmob.shoppingmall.constant.Constant;
import lombok.Data;

@Data
public class BusinessTemplate {
    // 主键ID
    private Integer templateId;
    // 模板消息类型
    private Constant.InformType informType;
    private String informId;
    // 开关状态 0发送 1不发送
    private Constant.SendFlag sendFlag;
}
