package com.vicmob.shoppingmall.web.goodsAPI.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class MallGoodsCollage implements Serializable {
    private Integer collageid;

    private String collageactivityid;

    private Integer minaid;

    private Integer customerid;

    private Date collagestartdate;

    private Integer goodsid;

    private String collageno;

    private String goodsname;

    private Integer alcollagepeople;

    private Integer collagestatus;

}