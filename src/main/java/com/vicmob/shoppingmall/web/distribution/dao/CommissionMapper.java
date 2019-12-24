package com.vicmob.shoppingmall.web.distribution.dao;

import com.vicmob.shoppingmall.web.distribution.entity.Commission;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * @author  xuyx
 */
public interface CommissionMapper {
    List<Commission> getCommissionByMinaId(@Param("minaId") Integer minaId);
    List<Commission> getCommissionByMinaIds(@Param("minaIds") Set<Integer> minaIds);
    Integer addCommission(@Param("d") Commission Commission);
    Integer updateCommission(@Param("d") Commission Commission);
    Integer delCommission(@Param("commissionId") Integer commissionId);
}
