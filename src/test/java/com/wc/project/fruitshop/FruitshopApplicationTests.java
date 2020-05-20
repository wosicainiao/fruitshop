package com.wc.project.fruitshop;

import com.wc.project.fruitshop.entity.ShopGoods;
import com.wc.project.fruitshop.service.GoodsService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class FruitshopApplicationTests {
    @Autowired
    GoodsService goodsService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testInsert(){
        ShopGoods shopGoods = new ShopGoods();
        List<String> list = new ArrayList<>();
//        Collections.addAll(list,"苹果","香蕉","桃","梨","圣女果","菠萝","西瓜","橙子","柚子","柠檬","樱桃","枣","椰子","草莓","蓝莓","葡萄","甘蔗","芒果","木瓜","杏子","李子"+
//                "石榴","榴莲","桂圆","橘子","哈密瓜","杨桃");
        Collections.addAll(list,"黄瓜","葱","姜","蒜","西红柿","芹菜","青椒","辣椒","苦瓜","土豆","萝卜","胡萝卜","韭菜","洋葱","芹菜","菠菜","生菜","秋葵","甘蓝","白菜","花菜","西兰花");
        for (int i = 0; i < list.size(); i++) {
            shopGoods.setCategoryId(1);
            shopGoods.setCreateTime(LocalDateTime.now());
            shopGoods.setUpdateTime(LocalDateTime.now());
            shopGoods.setGoodsSn(i+"");
            shopGoods.setGoodsName(list.get(i));
            shopGoods.setGoodsPrice(new BigDecimal(5));
            shopGoods.setActivePrice(new BigDecimal(4));
            shopGoods.setGoodsBrief("这个就是"+list.get(i));
            shopGoods.setGoodsNum((i+1)*1000);
            shopGoods.setSaleNumber((i+1)*500);
            shopGoods.setDeleted((byte)0);
            shopGoods.setGoodsPicture("http://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=xigua&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=1507117135,236395021&os=1161588546,3963109026&simid=4137951713,697446485&pn=3&rn=1&di=110440&ln=1613&fr=&fmq=1589910610537_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=0&objurl=http%3A%2F%2Fimg2.jqw.com%2F2014%2F05%2F27%2F1395916%2Fproduct%2Fb201605120903037377.jpg&rpstart=0&rpnum=0&adpicid=0&force=undefined");
            goodsService.insertGoods(shopGoods);
        }
    }

}
