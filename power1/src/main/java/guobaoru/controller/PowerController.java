package guobaoru.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Created by guobaoru.
 * @create on 2019/2/14.
 */
@RestController()
public class PowerController {

    @RequestMapping("/getPower.do")
    public String getPower() throws Exception {

//        /**
//         * 调试服务降级
//         */
//        throw new Exception("test");

        /**
         * hystrix 默认超时配置 1000ms ，所以睡眠2秒可触发降级
         */
        Thread.sleep(4000);

        return "power1!";
    }

}
