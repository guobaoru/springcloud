package com.guobaoru;

import config.PowerServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Created by guobaoru.
 * @create on 2019/2/12.
 */
@SpringBootApplication
@EnableEurekaClient
/**
 * Ribbon 负载配置
 */
@RibbonClients({
        @RibbonClient(name = "server-power", configuration = PowerServerConfig.class)
})

@EnableFeignClients(basePackages = {"com.guobaoru.remote"})
public class UserClient {
    public static void main(String[] args) {
        SpringApplication.run(UserClient.class);
    }
}
