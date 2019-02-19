package config;

import com.guobaoru.irule.MyRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 该配置不可在Scan 扫描到，否则所有为服务均使用该负载均衡策略
 * @author Created by guobaoru.
 * @create on 2019/2/19.
 */
@Configuration
public class PowerServerConfig {

    @Bean
    public IRule iRule () {
        /**
         * 重写负载算法（实现使用RandomRule内部实现，可自行定制逻辑）
         */
        return new MyRule();
    }

}
