package com.vicmob.shoppingmall.web.distribution.dao;

import com.vicmob.shoppingmall.web.distribution.entity.Distribution;
import org.apache.ibatis.annotations.Param;

public interface DistributionMapper {
    Integer addDistribution(@Param("d") Distribution distribution);
    Distribution getDistribution(@Param("goodsId") Integer goodsId);
    Integer updateDistribution(@Param("d") Distribution distribution);
}
