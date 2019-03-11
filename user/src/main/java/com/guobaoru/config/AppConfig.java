package com.guobaoru.config;

import com.guobaoru.irule.MyRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
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

    @Bean
    public IRule iRule () {
        /**
         * 重写负载算法（实现使用RandomRule内部实现，可自行定制逻辑）
         */
        return new RoundRobinRule();
    }



}
