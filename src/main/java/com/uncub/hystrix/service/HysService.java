package com.uncub.hystrix.service;

import com.netflix.hystrix.*;
import org.springframework.stereotype.Service;

public class HysService  extends HystrixCommand<String> {

    public HysService(String name) {
        super(
                Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ServiceGroup"))
                        .andCommandKey(HystrixCommandKey.Factory.asKey("servcie1query"))
                        .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("service1ThreadPool"))
                        .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(20))// 服务线程池数量
                        .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withCircuitBreakerErrorThresholdPercentage(60)// 熔断器关闭到打开阈值
                                .withCircuitBreakerSleepWindowInMilliseconds(3000)// 熔断器打开到关闭的时间窗长度
                        ));
    }

    protected String run() throws Exception {
        Thread.sleep(1000);
        return "成功";
    }


    @Override
    protected String getFallback() {
        return "降级！";
    }
}
