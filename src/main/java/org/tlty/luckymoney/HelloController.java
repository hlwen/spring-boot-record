package org.tlty.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 *
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    //    @Value("${minMoney}")
//    private BigDecimal minMoney;
//
//    @Value("${description}")
//    private String description;
    @Autowired
    private LimitConfig LimitConfig;

    // 多url请求
    @GetMapping({"/say", "hi"})
    public String say() {
        return "跟图灵天宜 学习Spingboot minMoney=" + LimitConfig.getMinMoney() + "说明:" + LimitConfig.getDescription();
    }

    // post
    @PostMapping("/say")
    public String postsay() {
        return "post minMoney=" + LimitConfig.getMinMoney() + "说明:" + LimitConfig.getDescription();
    }

    // post get 都行
    @RequestMapping("/say1")
    public String postgetsay() {
        return "postgetsay minMoney=" + LimitConfig.getMinMoney() + "说明:" + LimitConfig.getDescription();
    }

    // 获取参数
    @GetMapping("/url-parameter/{id}")
    public String urlParameterId(@PathVariable("id") Integer id) {
        return "id:" + id;
    }
    // 获取参数
    @GetMapping("/url-parameter")
    public String urlParameter(@RequestParam(value = "id",required = false, defaultValue = "0") Integer id) {
        return "id:" + id;
    }
    // 获取参数 都能通过RequestParam获取
    @PostMapping("/url-parameter")
    public String postUrlParameter(@RequestParam(value = "id",required = false, defaultValue = "0") Integer id) {
        return "id:" + id;
    }
}
