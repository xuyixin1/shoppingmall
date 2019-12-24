package com.vicmob.shoppingmall.utils;
import com.vicmob.shoppingmall.constant.RedisLockVO;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Component
public class RedisUtils {

    private static AtomicLong threadIncreaseId = new AtomicLong(Integer.MAX_VALUE + 1L);

    @Autowired
    private RedissonClient redissonSingle;

    /**
     * 获取分布式锁,使用自定义线程替换redisson内部使用的当前线程id
     * @param redisLockVO
     * @return
     */
    public void getLock(RedisLockVO redisLockVO) {
        long modifiedTid = threadIncreaseId.incrementAndGet();
        boolean flag = tryLock(redisLockVO.getWaitTime(),redisLockVO.getKey(),TimeUnit.SECONDS,redisLockVO.getExpire(),modifiedTid);
        if (flag) {
            redisLockVO.setThreadId(modifiedTid);
        }
    }


    /**
     * 释放分布式锁
     *
     * @param redisLockVO
     */
    public void unlock(RedisLockVO redisLockVO) {
        RLock lock = redissonSingle.getLock(redisLockVO.getKey());
        if (redisLockVO.getThreadId() != 0) {
            lock.unlock(redisLockVO.getThreadId());
        } else {
            lock.unlock();
        }
    }

    private boolean tryLock(long wait, String key, TimeUnit unit, long releaseTime, long modifiedThreadId) {
        RLock lock = redissonSingle.getLock(key);
        try {
            return lock.tryLock(wait, releaseTime, unit, modifiedThreadId);
        } catch (RedisException e) {
            log.error("-------- saas-redis get distributed lock error : {}", e.getMessage(), e);
            return false;
        } catch (InterruptedException e) {
            log.error("-------- saas-redis get distributed lock error : {}", e.getMessage(), e);
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new AtomicLong(Integer.MAX_VALUE + 1L).incrementAndGet());
    }

}
