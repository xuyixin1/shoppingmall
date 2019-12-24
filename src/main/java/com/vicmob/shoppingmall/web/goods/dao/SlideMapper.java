package com.vicmob.shoppingmall.web.goods.dao;

import com.vicmob.shoppingmall.constant.Constant;
import com.vicmob.shoppingmall.utils.ResultData;
import com.vicmob.shoppingmall.web.goods.entity.Slide;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SlideMapper {
    public List<Slide>  getSlideList(@Param("minaId") Integer minaId);

    public Slide getByslideId(@Param("slideId") Integer slideId);

    public Integer addSlide(@Param("s")Slide slide);

    public Integer updateSlide(@Param("s")Slide slide);

    public Integer deteleSlide(@Param("slideId")Integer slideId);

    public Integer updateUseFlag(@Param("slideId")Integer slideId, @Param("useFlag")Constant.Flag useFlag);
}
