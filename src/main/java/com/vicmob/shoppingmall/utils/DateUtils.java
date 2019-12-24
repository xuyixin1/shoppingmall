package com.vicmob.shoppingmall.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.*;

import static java.util.concurrent.Executors.newFixedThreadPool;

@Slf4j
public class DateUtils {
    public static Boolean expire(Long time){
        if (time == null){
            return true;
        }
        long nowTime = (System.currentTimeMillis()) / 1000 ;
        if (nowTime < time){
            return false;
        }
        return true;
    }

    public static int differentDaysByMillisecond(Date minDate, Date maxDate) {
        if (minDate == null || maxDate == null || maxDate.getTime() - minDate.getTime() < 0) {
            return -1;
        }
        int days = (int) ((maxDate.getTime() - minDate.getTime()) / (1000 * 3600 * 24));
        if((maxDate.getTime() - minDate.getTime()) % (1000 * 3600 * 24) != 0){
            days ++;
        }
        return days;
    }

    /**
     * 获得当天零时零分零秒
     * @return
     */
    public static Date initDateByDay(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    public static Boolean inTimes(Integer startHour ,Integer endHour){
        if (startHour <0 || startHour > 24 ||endHour <0 || endHour > 24 ){
            log.error("参数错误startHour ==>{},endHour ==>{}",startHour,endHour);
            return Boolean.FALSE;
        }
        Calendar calendar = Calendar.getInstance();
        Integer hour = calendar.get(Calendar.HOUR_OF_DAY);
        if (startHour > endHour){
            if(hour >= startHour || hour < endHour){
                return Boolean.TRUE;
            }
        }
        if (startHour < endHour){
            if(hour >= startHour && hour < endHour){
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;

    }

    public static void main(String[] args)throws Exception{
       /* CountDownLatch countDownLatch = new CountDownLatch(1);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("aaa");
                countDownLatch.countDown();
            }
        });
        t.start();
        countDownLatch.await();
        ExecutorService executorService = new ThreadPoolExecutor(10, 10,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
*/
       ForkJoinPool pool  = new ForkJoinPool();
    }

}
