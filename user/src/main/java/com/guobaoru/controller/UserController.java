package com.guobaoru.controller;

import com.guobaoru.remote.PowerFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Created by guobaoru.
 * @create on 2019/2/14.
 */
@RestController("/user")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PowerFeignClient powerFeignClient;

    private final String SERVER_NAME = "http://server-power";

    @RequestMapping("/getPower")
    @HystrixCommand(fallbackMethod = "getPowerFullback"  // 降级、熔断配置
            /**
             * 限流配置，也可在配置文件中配置
             * 当有 coreSize 个线程同时访问时，其他线程被限流
            */
            , threadPoolKey = "power"
            , threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "2")
            , @HystrixProperty(name = "maxQueueSize", value = "1")
    }
    )
    public String getUser() {
        return restTemplate.getForObject(SERVER_NAME + "/getPower.do", String.class);
    }


    @RequestMapping("/getFeignPower")
    @HystrixCommand(
            /**
             * 限流配置，也可在配置文件中配置
             * 当有 coreSize 个线程同时访问时，其他线程被限流
            */
          threadPoolKey = "power"
          , threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "2")
                    , @HystrixProperty(name = "maxQueueSize", value = "1")
            }
    )
    public String getFeignPower() {
        System.out.println("进入方法调用...");
        return powerFeignClient.getPower();
    }

    /**
     * 服务降级方法
     *
     * @return
     */
    public String getPowerFullback() {
        return "降级中...";
    }

}
