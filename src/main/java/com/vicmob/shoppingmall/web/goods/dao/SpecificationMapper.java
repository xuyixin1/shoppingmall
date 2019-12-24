package com.vicmob.shoppingmall.web.goods.dao;

import com.vicmob.shoppingmall.web.goods.entity.Specification;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecificationMapper {
    public List<Specification> getSpecificationList(@Param("goodsId") Integer goodsId);

    public Integer addSpecification(@Param("s") Specification specification);

    public Integer deleteFlagByGoodsId(@Param("goodsId") Integer goodsId);

    public List<Specification> getSpecificationListByAttributeId(@Param("attributeId")Integer attributeId);

    public Integer updateStock(@Param("specId")Integer specId,@Param("num")Integer num);

    /**
     * 更新规格
     * @param specification
     * @return
     */
    Integer updateSpecification(@Param("s") Specification specification);

    /**
     * 批量删除
     * @param specifications
     * @return
     */
    Integer deleteSpecifications(@Param("specifications") List<Specification> specifications);
}
