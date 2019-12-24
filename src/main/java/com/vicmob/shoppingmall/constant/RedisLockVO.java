package com.vicmob.shoppingmall.constant;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RedisLockVO {

    @ApiModelProperty(value="分布式锁的键", name="key", required=true)
    private String key;

    @ApiModelProperty(value="锁自动释放时间（秒）", name="expire", required=true)
    private long expire;

    @ApiModelProperty(value="尝试获得锁的等待时间（秒）", name="waitTime", required=true)
    private long waitTime;

    @ApiModelProperty(value="加锁线程的id", name="threadId")
    private long threadId;

    public RedisLockVO() {
    }

    public RedisLockVO(String key, long expire, long waitTime) {
        this.key = key;
        this.expire = expire;
        this.waitTime = waitTime;
    }

    public RedisLockVO(String key, long expire, long waitTime, long threadId) {
        this.key = key;
        this.expire = expire;
        this.waitTime = waitTime;
        this.threadId = threadId;
    }
}
