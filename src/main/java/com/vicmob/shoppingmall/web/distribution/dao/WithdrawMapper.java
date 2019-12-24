package com.vicmob.shoppingmall.web.distribution.dao;

import com.vicmob.shoppingmall.constant.CommissionConstant;
import com.vicmob.shoppingmall.web.distribution.entity.Withdraw;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface WithdrawMapper {
    /**
     * 添加提现申请表
     * @param withdraw
     * @return
     */
    Integer addWithdraw(@Param("w") Withdraw withdraw);

    /**
     * 获取申请提现列表
     * @param distributionUser
     * @param withdrawNo
     * @param phone
     * @param status
     * @param minaId
     * @return
     */
    List<Withdraw> getWithdrawList(@Param("distributionUser")String distributionUser, @Param("withdrawNo")String withdrawNo, @Param("phone")String phone, @Param("status")CommissionConstant.WithdrawStatus status, @Param("minaId")Integer minaId);

    /**
     * 根据withdrawNo获取记录
     * @param withdrawNo
     * @param minaId
     * @return
     */
    Withdraw getWithdrawByWithdrawNo(@Param("withdrawNo")String withdrawNo,@Param("minaId")Integer minaId);

    /**
     * 更新审核状态
     * @param withdrawNo
     * @param minaId
     * @param status
     * @param reason
     * @return
     */
    Integer updateAuditStatus(@Param("withdrawNo")String withdrawNo, @Param("minaId")Integer minaId, @Param("status")CommissionConstant.WithdrawStatus status, @Param("reason") String reason, @Param("auditTime")Date auditTime,@Param("payTime")Date payTime);
}
