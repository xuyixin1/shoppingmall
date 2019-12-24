package com.vicmob.shoppingmall.web.distribution.dao;


import com.vicmob.shoppingmall.web.distribution.entity.Customer;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

/**
 * @author  xuyx
 */
public interface CustomerMapper {
    List<Customer> getCustomerListByOpenId(@Param("openIds") Set<String> openIds);
    Integer updateCommission(@Param("customers")List<Customer> customers);
    List<Customer> getCustomerList(@Param("minaId")Integer minaId,@Param("nickName")String nickName);

    /**
     * 更新佣金
     * @param openId
     * @param commission 佣金
     * @return
     */
    Integer updateCommissionTotalCommission(@Param("openId")String openId, @Param("commission")BigDecimal commission);

    /**
     * 通过客户id获取
     * @param minaId
     * @param customerId
     * @return
     */
    Customer getCustomerByCustomerId(@Param("minaId")Integer minaId,@Param("customerId")Integer customerId);


    /**
     * 通过openid获取
     * @param openId
     * @param minaId
     * @return
     */
    Customer getCustomerByOpenId(@Param("openId")String openId,@Param("minaId")Integer minaId);

    /**
     * 更新提现申请次数和可申请金额，和申请中金额
     * @param openId
     * @param minaId
     * @return
     */
    Integer updateApplyNumberAndCash(@Param("minaId")Integer minaId,@Param("openId")String openId,@Param("cashApply")BigDecimal cashApply);

    /**
     * 打款失败 更新可申请金额，和申请中金额
     * @param minaId
     * @param openId
     * @param cashApply
     * @return
     */
    Integer updateCommissionWithUnpassed(@Param("minaId")Integer minaId,@Param("openId")String openId,@Param("cashApply")BigDecimal cashApply);

    /**
     * 打款成功 更新申请中金额，和已申请金额
     * @param minaId
     * @param openId
     * @param cashApply
     * @return
     */
    Integer updateCommissionWithPayed(@Param("minaId")Integer minaId,@Param("openId")String openId,@Param("cashApply")BigDecimal cashApply);

    /**
     * 清理提现申请次数
     * @return
     */
    Integer clearCustomerApplyNumber();
}
