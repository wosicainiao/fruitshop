package com.wc.project.fruitshop.service;

import com.wc.project.fruitshop.entity.ShopOrder;
import com.wc.project.fruitshop.mapper.ShopOrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

/**
 * @Author 王超
 * @Description TODO
 * @create 2020/5/22 23:11
 */
@Service
public class OrderService {

    @Resource
    private ShopOrderMapper orderMapper;

    public String generateOrderSn(Integer userId) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");
        String now = df.format(LocalDate.now());
        String orderSn = now + getRandomNum(6);
        return orderSn;
    }

    private String getRandomNum(Integer num) {
        String base = "0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    public List<ShopOrder> selectOrderByUserId(Integer userId){
        return orderMapper.selectOrderByUserId(userId);
    }
}
