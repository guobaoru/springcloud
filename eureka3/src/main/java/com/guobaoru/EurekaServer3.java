package com.guobaoru;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Created by eureka.
 * @create on 2019/2/12.
 */

@SpringBootApplication
@EnableEurekaServer
public class EurekaServer3 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer3.class);

    }
}
