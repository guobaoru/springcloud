package guobaoru;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Created by guobaoru.
 * @create on 2019/2/12.
 */
@SpringBootApplication
@EnableEurekaClient
public class PowerClient1 {
    public static void main(String[] args) {
        SpringApplication.run(PowerClient1.class);
    }
}
