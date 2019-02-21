package com.guobaoru;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 如果相对zuul做集群可以使用很多实现
 * nginx、zuul本身可以路由自己、ribbon负载可以做
 *
 * @author Created by guobaoru.
 * @create on 2019/2/20.
 */
@SpringBootApplication
@EnableZuulProxy
public class AppZuul {
    public static void main(String[] args) {
        SpringApplication.run(AppZuul.class);
    }
}
