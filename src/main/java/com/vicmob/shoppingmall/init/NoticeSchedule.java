package com.vicmob.shoppingmall.init;
import com.vicmob.shoppingmall.web.goodsAPI.service.GoodsCollageService;
import com.vicmob.shoppingmall.web.goodsAPI.service.GoodsOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Async
public class NoticeSchedule {

    @Autowired
    private GoodsOrderService goodsOrderService;
    @Autowired
    private GoodsCollageService goodsCollageService;

    @Scheduled(fixedDelay = 30 * 1000, initialDelay = 1000)
    public void overtimeJob() {
        goodsOrderService.cancelOrderCollageFull();
        goodsOrderService.orderOvertime();
        goodsCollageService.collageActivityOvertime();
        goodsCollageService.collageOvertime();
        goodsCollageService.collageActivityUnStart();
    }
}
