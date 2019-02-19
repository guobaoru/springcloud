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
    public String getPower() {

        return "power1!";
    }

}
