package org.tlty.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class LuckymoneyService {

    @Autowired
    private LuckymoneyRepository repository;

    /**
     * 添加事务
     */
    @Transactional
    public void createTwo() {
        Luckymoney luckymoney1 = new Luckymoney();
        luckymoney1.setMoney(new BigDecimal(520));
        luckymoney1.setProducer("图灵天宜");
        repository.save(luckymoney1);

        Luckymoney luckymoney2 = new Luckymoney();
        luckymoney2.setMoney(new BigDecimal(1314));
        luckymoney2.setProducer("图灵天宜");
        repository.save(luckymoney2);
    }
}