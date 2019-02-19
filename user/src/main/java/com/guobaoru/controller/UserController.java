package com.guobaoru.controller;

import com.guobaoru.remote.PowerFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
    @HystrixCommand(fallbackMethod = "getPowerFullback")
    public String getUser() {
        return restTemplate.getForObject(SERVER_NAME + "/getPower.do", String.class);
    }


    @RequestMapping("/getFeignPower")
    @HystrixCommand(fallbackMethod = "getPowerFullback")
    public String getFeignPower() {
        return powerFeignClient.getPower();
    }

    /**
     * 服务降级方法
     * @return
     */
    public String getPowerFullback() {
        return "降级中...";
    }

}
