package com.vicmob.shoppingmall.constant;

import com.fasterxml.jackson.annotation.JsonValue;

import java.text.DateFormat;
import java.util.Calendar;

public class Constant {
    public static final String  TRADE_TYPE = "JSAPI";
    public static final String  FILE_SEPARATE = "||";
    public static final String SUCCESS = "SUCCESS";
    public static final String FAIL = "FAIL";
    public static enum UpLoadType{
        //图片
        IMG(0),
        MUSIC(1),
        VIDEO(2),
        //头像
        TITLEIMG(3);
        public Integer value;

        private UpLoadType(Integer value){
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }
    }

    //模板消息类型
    public static enum InformType implements BaseEnum<Integer>{
        //下单
        ORDER(0),
        //订单已支付
        ORDER_PAY(1),
        //订单已完成
        ORDER_FINISH(2),
        //订单超时
        ORDER_OVERTIME(3),
        //订单取消
        ORDER_CANCEL(4),
        //退款申请
        REFUND_APPLY(5),
        //退款成功
        REFUND_SUCESS(6),
        //退款失败
        REFUND_FAILURE(7),
        //拒绝退款
        REFUND_REFUSE(8);

        public Integer value;

        private InformType(Integer value){
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        @Override
        public Integer getMybatisValue(){
            return value;
        }

        public static InformType getEnumInformType(OrderType orderType){
            switch(orderType.value){
                case 0:
                    return ORDER;
                case 1:
                    return ORDER_PAY;
                case 2:
                    return ORDER_FINISH;
                case 3:
                    return ORDER_OVERTIME;
                case 4:
                    return ORDER_CANCEL;
                case 5:
                    return REFUND_APPLY;
                case 6:
                    return REFUND_SUCESS;
                case 7:
                    return REFUND_FAILURE;
                case 8:
                    return REFUND_REFUSE;

                default:
                    return null;
            }
        }

    }

    //模板消息类型
    public static enum OrderType implements BaseEnum<Integer>{
        //下单
        ORDER(0, "待支付"),
        //订单已支付
        ORDER_PAY(1,"已支付"),
        //订单已完成
        ORDER_FINISH(2,"已完成"),
        //订单超时
        ORDER_OVERTIME(3,"已超时"),
        //订单取消
        ORDER_CANCEL(4,"已取消"),
        //退款申请
        REFUND_APPLY(5,"退款申请"),
        //退款成功
        REFUND_SUCCESS(6,"退款成功"),
        //退款失败
        REFUND_FAILURE(7,"退款失败"),
        //拒绝退款
        REFUND_REFUSE(8,"拒绝退款"),
        //申请退款
        REFUND_PAYING(9,"退款中"),
        //支付中
        PAYING(10,"支付中"),
        //已失效(拼团状态)
        FAILURED(11,"已失效"),
        //已成团交易取消(拼团状态)
        COGT(12,"已成团交易取消");
        public Integer value;

        public String  name;

        private OrderType(Integer value,String name){
            this.value = value;
            this.name = name;
        }


        public Integer getValue() {
            return value;
        }

        public String getName() {
            return name;
        }


        @Override
        public Integer getMybatisValue(){
            return value;
        }

        public static OrderType getEnumOrderType(Integer value){
            switch(value){
                case 0:
                    return ORDER;
                case 1:
                    return ORDER_PAY;
                case 2:
                    return ORDER_FINISH;
                case 3:
                    return ORDER_OVERTIME;
                case 4:
                    return ORDER_CANCEL;
                case 5:
                    return REFUND_APPLY;
                case 6:
                    return REFUND_SUCCESS;
                case 7:
                    return REFUND_FAILURE;
                case 8:
                    return REFUND_REFUSE;
                case 9:
                    return  REFUND_PAYING;
                case 10:
                    return PAYING;
                default:
                    return null;
            }
        }
    }

    public static enum SendFlag implements BaseEnum<Integer>{
        N0(0),
        YES(1);
        public Integer value;

        private SendFlag(Integer value){
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        @Override
        public Integer getMybatisValue(){
            return value;
        }
    }

    public static enum DeleteFlag implements BaseEnum<Integer>{
        NO(0),
        YES(1);
        public Integer value;

        private DeleteFlag(Integer value){
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        @Override
        public Integer getMybatisValue(){
            return value;
        }

    }

    public static enum DeleteFlag1 implements BaseEnum<Integer>{
        NO(0),
        CUSTOM_DELETE(1),
        BUSSINESS_DELETE(2);
        public Integer value;

        private DeleteFlag1(Integer value){
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        @Override
        public Integer getMybatisValue(){
            return value;
        }

    }

    public static enum SaleFlag implements BaseEnum<Integer> {
        NO(0),
        YES(1);

        public Integer value;

        private SaleFlag(Integer value){
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        @Override
        public Integer getMybatisValue(){
            return value;
        }

        public static SaleFlag getEnumSaleFlag(Integer value){
            switch(value){
                case 0:
                    return NO;
                case 1:
                    return YES;
                default:
                    return null;
            }
        }
    }

    public static enum PayType implements BaseEnum<Integer> {
        WECHAT_PAY(0),
        ALIPAY(1);

        public Integer value;

        private PayType(Integer value){
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

    public static enum EvaluateFlag implements BaseEnum<Integer> {
        NO(0),
        YES(1);

        public Integer value;

        private EvaluateFlag(Integer value){
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

    public static enum TimeType{
        THREE_DAY(0),
        ONE_WEEK(1),
        ONE_MONTH(2),
        THREE_MONTH(3),
        HALF_YEAR(4),
        ONE_YEAR(5);
        public Integer value;

        private TimeType(Integer value){
            this.value = value;
        }


        public Integer getValue() {
            return value;
        }

        public static String getTime(TimeType timeType, DateFormat df){
            Calendar calendar = Calendar.getInstance();
            switch (timeType.value) {
                case 0:
                    calendar.add(Calendar.DATE, -3);
                    break;
                case 1:
                    calendar.add(Calendar.DATE, -7);
                    break;
                case 2:
                    calendar.add(Calendar.MONTH, -1);
                    break;
                case 3:
                    calendar.add(Calendar.MONTH, -3);
                    break;
                case 4:
                    calendar.add(Calendar.MONTH, -6);
                    break;
                case 5:
                    calendar.add(Calendar.YEAR, -1);
                    break;
                default:
                    break;
            }
            String startTime = df.format(calendar.getTime());
            return startTime;
        }
    }

    public static enum Flag implements BaseEnum<Integer> {
        NO(0),
        YES(1);

        public Integer value;

        private Flag(Integer value){
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

    public static enum WXOperation{
        PREPAY(0),
        PAY_QUERY(1),
        REFUND(2);
        public Integer value;

        private WXOperation(Integer value){
            this.value = value;
        }


        public Integer getValue() {
            return value;
        }
    }

}
