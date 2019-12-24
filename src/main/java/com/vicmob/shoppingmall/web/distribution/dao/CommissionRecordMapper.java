package com.vicmob.shoppingmall.web.distribution.dao;

import com.vicmob.shoppingmall.constant.CommissionConstant;
import com.vicmob.shoppingmall.web.distribution.entity.CommissionRecord;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author  xuyx
 */
public interface CommissionRecordMapper {
    Integer addCommissionRecord(@Param("c") CommissionRecord commissionRecord);
    List<CommissionRecord> getCommissionRecordListByStatus(@Param("status")CommissionConstant.CommissionStatus status);

    /**
     * 更新佣金状态
     * @param ids
     * @param status
     * @return
     */
    Integer updateCommissionStatus(@Param("ids")List<Integer> ids,@Param("status")CommissionConstant.CommissionStatus status);

    /**
     * 更新佣金记录的状态
     * @param status
     * @param orderNumber
     * @return
     */
    Integer updateCommissionRecord(@Param("status")CommissionConstant.CommissionStatus status,@Param("orderNumber")String orderNumber);
    List<CommissionRecord> getCommissionRecordList(@Param("distributionUser")String distributionUser,@Param("orderNumber")String orderNumber,@Param("statusList")List<CommissionConstant.CommissionStatus> statusList,@Param("minaId")Integer minaId);

    /**
     * 根据订单orderNumber获取佣金记录
     * @param orderNumber
     * @return
     */
    CommissionRecord getCommissionRecordByOrderNumber(@Param("orderNumber")String orderNumber);

    /**
     * 获取当前用户未入账金额
     * @param minaId
     * @param distributionUser
     * @return
     */
    BigDecimal getUnBookCommission(@Param("minaId")Integer minaId, @Param("distributionUser")String distributionUser);
}
