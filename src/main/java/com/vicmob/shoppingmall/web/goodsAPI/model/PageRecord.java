package com.vicmob.shoppingmall.web.goodsAPI.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description
 * @Author 王良
 * @Date 2019/5/13
 */
@Data
public class PageRecord {

    private static final long serialVersionUID = 6287447161526074161L;

    @ApiModelProperty(value="页码",name="pageIndex")
    private int pageIndex = 1;
    @ApiModelProperty(value="每页大小",name="pageSize")
    private int pageSize = 10;
    @ApiModelProperty(value="总记录数",name="total")
    private long total;

}
