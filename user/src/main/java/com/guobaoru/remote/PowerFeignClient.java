package com.guobaoru.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Created by guobaoru.
 * @create on 2019/2/19.
 */
@FeignClient(name = "server-power")
public interface PowerFeignClient {

    /**
     * 获取power
     * @return
     */
    @RequestMapping("/getPower.do")
    String getPower();

}
