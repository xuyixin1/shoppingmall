package com.vicmob.shoppingmall.global;

import org.apache.commons.lang.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * wang liang
 */
@Configuration
@ConditionalOnClass(Config.class)
public class RedissonAutoConfiguration {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private String port;
//
//    @Value("${spring.redis.password}")
//    private String password;

    private static int timeout = 5000;

    private static int connectionPoolSize = 64;

    private static int connectionMinimumIdleSize=10;

    private static int slaveConnectionPoolSize = 250;

    private static int masterConnectionPoolSize = 250;

    /**
     * 哨兵模式自动装配
     */
//    @Bean
//    RedissonClient redissonSentinel() {
//        Config config = new Config();
//        String address = "redis://" + host + ":" + port;
//        SentinelServersConfig serverConfig = config.useSentinelServers().addSentinelAddress(address)
//                .setMasterName("")
//                .setTimeout(timeout)
//                .setMasterConnectionPoolSize(masterConnectionPoolSize)
//                .setSlaveConnectionPoolSize(slaveConnectionPoolSize);
//        if(StringUtils.isNotEmpty(password)) {
//            serverConfig.setPassword(password);
//        }
//        return Redisson.create(config);
//    }

    /**
     * 单机模式自动装配
     */
    @Bean
    RedissonClient redissonSingle() {
        Config config = new Config();
        SingleServerConfig serverConfig = config.useSingleServer()
                .setAddress("redis://" + host + ":" + port)
                .setTimeout(timeout)
                .setConnectionPoolSize(64)
                .setConnectionMinimumIdleSize(connectionMinimumIdleSize);
//        if(StringUtils.isNotEmpty(password)) {
//            serverConfig.setPassword(password);
//        }
        return Redisson.create(config);
    }
}
