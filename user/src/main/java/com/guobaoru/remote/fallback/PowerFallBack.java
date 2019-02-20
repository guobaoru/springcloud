package com.guobaoru.remote.fallback;

import com.guobaoru.remote.PowerFeignClient;
import org.springframework.stereotype.Component;

/**
 * @author Created by guobaoru.
 * @create on 2019/2/20.
 */
@Component
public class PowerFallBack implements PowerFeignClient {
    @Override
    public String getPower() {
        return "feign 请求降级中，请稍后...";
    }
}
