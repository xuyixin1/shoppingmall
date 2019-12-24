package com.vicmob.shoppingmall.web.goodsAPI.entity;

import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
public class MallGoodsCollageActivity implements Serializable {
    private String collageactivityid;

    private Integer minaid;

    private Integer goodsid;

    private Integer specid;

    private String collageactivityname;

    private Integer collageactivitypeople;

    private Date activitystartdate;

    private Date activityenddate;

    private Integer collagevaliddate;

    private Integer partsnumber;

    private Integer limitedpurchase;

    private BigDecimal collageactivityprice;

    private Integer collageactivitystatus;

    private Integer deleteflag;

    private Date createdate;

}