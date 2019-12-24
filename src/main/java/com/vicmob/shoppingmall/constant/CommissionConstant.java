package com.vicmob.shoppingmall.constant;

import com.vicmob.shoppingmall.web.distribution.entity.Distribution;

import java.math.BigDecimal;

/**
 * 佣金相关constant
 * @author xuyx
 */
public class CommissionConstant {
    /**
     * 佣金计算方式
     */
    public enum CalculateMode implements BaseEnum<Integer> {
        //商品总价
        GOODS_AMOUNT(0),
        //实际支付金额
        PAY_AMOUNT(1);

        private Integer value;

        CalculateMode(Integer value) {
            this.value = value;
        }
        public Integer getValue() {
            return value;
        }

        @Override
        public Integer getMybatisValue() {
            return value;
        }
    }

    /**
     * 佣金状态
     */
    public enum CommissionStatus implements BaseEnum<Integer> {
        //已支付
        PAYED(0),
        //已失效
        INVALID(1),
        //未入账
        UNBOOKED(2),
        //已入账
        BOOKED(3);

        private Integer value;

        CommissionStatus(Integer value) {
            this.value = value;
        }
        public Integer getValue() {
            return value;
        }

        @Override
        public Integer getMybatisValue() {
            return value;
        }

        public static CommissionStatus getByOrderStatus(Constant.OrderType staus,Integer days){
            if (staus == Constant.OrderType.ORDER_PAY){
                return PAYED;
            }
            if (staus == Constant.OrderType.REFUND_SUCCESS){
                return INVALID;
            }
            if (staus == Constant.OrderType.REFUND_FAILURE && days == 0 ){
                return BOOKED;
            }
            if (staus == Constant.OrderType.REFUND_FAILURE && days > 0 ){
                return UNBOOKED;
            }
            if (staus == Constant.OrderType.REFUND_REFUSE && days == 0 ){
                return BOOKED;
            }
            if (staus == Constant.OrderType.REFUND_REFUSE && days > 0 ){
                return UNBOOKED;
            }
            if(staus == Constant.OrderType.ORDER_FINISH  && days == 0){
                return BOOKED;
            }
            if (staus == Constant.OrderType.ORDER_FINISH && days > 0 ){
                return UNBOOKED;
            }
            return null;
        }

    }


    /**
     *  分销方式
     */
    public enum CommissionMode implements BaseEnum<Integer> {
        //固定佣金
        FIXED(0),
        //百分比佣金
        PERCENTAGE(1);

        private Integer value;

        CommissionMode(Integer value) {
            this.value = value;
        }
        public Integer getValue() {
            return value;
        }

        public  static BigDecimal getCommission(CommissionConstant.CommissionMode status,BigDecimal minAmount, Distribution distribution,BigDecimal totalMoney,Integer num){
            if (status == FIXED){
                BigDecimal commission = distribution.getFixedCommission().multiply(new BigDecimal(num.toString()));
                if (minAmount.compareTo(commission) >= 0){
                    return minAmount;
                }
                return commission;
            }
            BigDecimal commission = totalMoney.multiply(distribution.getPercentageCommission()).divide(new BigDecimal("100"),2,BigDecimal.ROUND_DOWN);
            if (minAmount.compareTo(commission) >= 0){
                return minAmount;
            }
            return commission;

        }

        @Override
        public Integer getMybatisValue() {
            return value;
        }
    }


    /**
     * 提现状态
     */
    public enum WithdrawStatus implements BaseEnum<Integer> {
        //待审核
        TO_BE_AUDITED(0),
        //待打款
        TO_BE_PAY(1),
        //已打款
        PAYED(2),
        //未通过
        UNPASSED(3),
        //确认是否已打款
        CHECKPASSED(4);

        private Integer value;

        WithdrawStatus(Integer value) {
            this.value = value;
        }
        public Integer getValue() {
            return value;
        }

        @Override
        public Integer getMybatisValue() {
            return value;
        }
    }


}
