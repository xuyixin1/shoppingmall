package com.vicmob.shoppingmall.global;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * 
 * @author cardinfolink
 *
 */
@Configuration
public class ScheduledThreadPoolConfig implements SchedulingConfigurer {

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		 taskRegistrar.setScheduler(scheduledExecutor());
	}
	
	@Bean(name="scheduledExecutor",destroyMethod="shutdown")
    public Executor scheduledExecutor() {
		return new ScheduledThreadPoolExecutor(5);
    }
	
}
