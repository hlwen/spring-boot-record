package org.tlty.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 模板渲染
 * @Controller  +  @ResponseBody = @RestController
 */
@Controller
public class TempleController {

    @Autowired
    private LimitConfig LimitConfig;

    @GetMapping("/index")
    public String say() {
        return "index";
    }
    @ResponseBody
    @GetMapping("/helloJson")
    public String json() {
        return "跟图灵天宜 学习Spingboot minMoney=" + LimitConfig.getMinMoney() + "说明:" + LimitConfig.getDescription();
    }
}
