package com.vicmob.shoppingmall.constant;

public class BusinessMessageConstatnt {
    public static final String REMARK = "来自炫销宝商城";
    public static final String COMMON_COLOR = "#173177";

    public static enum Msg{
        ORDER_CANCEL("#999999","抱歉，用户取消了订单！"),
        ORDER("#FFAA00","您好，您有新的待支付订单！"),
        ORDER_PAY("#00CC22","您好，你有新的订单已支付！"),
        ORDER_FINISH("#00A8FF","用户已确认收货，订单已经完成！"),
        REFUND_APPLY("#FF0000","您好，您有一笔订单用户申请退款！");

        public String color;
        public String message;

        private Msg(String color,String message){
            this.color = color;
            this.message = message;
        }

        public String getColor() {
            return color;
        }

        public String getMessage() {
            return message;
        }
    }
}
