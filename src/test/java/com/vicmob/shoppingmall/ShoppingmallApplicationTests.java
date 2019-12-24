package com.vicmob.shoppingmall;

import com.vicmob.shoppingmall.job.CommissionJob;
import com.vicmob.shoppingmall.web.distribution.service.CommissionRecordService;
import com.vicmob.shoppingmall.web.goods.entity.Order;
import com.vicmob.shoppingmall.web.goods.service.OrderService;
import com.vicmob.shoppingmall.web.goodsAPI.wxclient.BusinessMessageClient;
import com.vicmob.shoppingmall.web.goodsAPI.wxclient.WXMessageClient;
import com.vicmob.shoppingmall.web.goodsAPI.wxclient.WXPayClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ShoppingmallApplication.class,ShoppingmallApplicationTests.class})
public class ShoppingmallApplicationTests {
    @Autowired
    WXPayClient wxPayClient;

    @Autowired
    OrderService orderService;

    @Autowired
    WXMessageClient wxMessageClient;

    @Autowired
    BusinessMessageClient businessMessageClient;
    @Autowired
    CommissionJob commissionJob;

    @Autowired
    CommissionRecordService commissionRecordService;

    @Test
    public void contextLoads() {
    }

    public void orderCancelBussinessMessage(){
        Order order = new Order();

    }

   @Test
    public void prepay()throws Exception{
        wxPayClient.prepay(10,11,1,"117.84.79.6");
    }

    @Test
    public void preNotify()throws Exception {
        Map<String,String> map = new HashMap<>();
        map.put("out_trade_no","1h232n1shadjeusa");
        wxPayClient.payNotify(map);
    }

    @Test
    public void refund()throws Exception {
        wxPayClient.refund( (Order)orderService.getByOrderId(1).getData());

    }

    @Test
    public void sendMessage() {
        wxMessageClient.sendMessage((Order)orderService.getByOrderId(1).getData());

    }

    @Test
    public void sendBusinessMessage() {
        businessMessageClient.sendMessage((Order)orderService.getByOrderId(6).getData());

    }

    @Test
    public void accountFlagCalculate() {
        commissionJob.accountFlagCalculate();
    }

    @Test
    public void userCommissionCalculate() {
        commissionJob.userCommissionCalculate();
    }

    @Test
    public void addCommissionRecord() {
        commissionRecordService.addCommissionRecord();
    }

}
