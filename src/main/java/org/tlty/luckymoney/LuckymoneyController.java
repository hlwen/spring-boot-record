package org.tlty.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class LuckymoneyController {
    @Autowired
    private LuckymoneyRepository repository;

    @Autowired
    private LuckymoneyService service;

    /**
     * 获取 红包 列表
     */
    @GetMapping("/luckymoneys")
    public List<Luckymoney> list() {
        return repository.findAll();

    }

    /**
     * 创建红包
     */
    @PostMapping("/luckymoneys")
    public Luckymoney creact(@RequestParam("producer") String producer, @RequestParam("money") BigDecimal money) {
        Luckymoney luckymoney = new Luckymoney();
        luckymoney.setMoney(money);
        luckymoney.setProducer(producer);
        return repository.save(luckymoney);
    }

    /**
     * 通过id查询红包
     */

    @GetMapping("/luckymoneys/{id}")
    public Luckymoney findById(@PathVariable("id") Integer id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * 通过id更新红包
     */

    @PutMapping("/luckymoneys/{id}")
    public Luckymoney update(@PathVariable("id") Integer id, @RequestParam("consmer") String consmer) {
        Optional<Luckymoney> optional = repository.findById(id);
        if (optional.isPresent()) {
            Luckymoney luckymoney = optional.get();
            luckymoney.setConsmer(consmer);
            return repository.save(luckymoney);

        }
        return null;
    }

    /**
     *
     */
    @PostMapping("/luckymoneys/two")
    public void creactTwo(){
        service.createTwo();
    }

}
