package com.guobaoru.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Created by guobaoru.
 * @create on 2019/2/18.
 */
@ComponentScan("com.guobaoru")
@Configuration
public class AppConfig {

    @Bean
    // Ribbon 负载均衡注解，默认使用轮询策略,使用feign后，自动依赖ribbo负载均衡
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
