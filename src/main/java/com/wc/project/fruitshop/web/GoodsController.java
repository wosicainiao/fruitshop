package com.wc.project.fruitshop.web;

import com.github.pagehelper.PageInfo;
import com.wc.project.fruitshop.entity.ShopGoods;
import com.wc.project.fruitshop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/fruitshop/home")
@Validated
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/searchGoods")
    @ResponseBody
    public Object searchGoods(@RequestParam(value = "keyword",defaultValue = "苹果") String keyword,
                              @RequestParam(defaultValue = "1") Integer page,
                              @RequestParam(defaultValue = "28") Integer limit,
                              Model model){
        List<ShopGoods> goodsList = goodsService.selectGoodsByKeyword(keyword,page,limit);
        long total = PageInfo.of(goodsList).getTotal();
        model.addAttribute("searchMsg",keyword);
        model.addAttribute("goodsList",goodsList);
        model.addAttribute("total",total);
        Long temp = total % 14 == 0 ? total / 14 :total / 14 + 1;
        Integer pageSum = temp.intValue();
        model.addAttribute("pageSum",pageSum);
        model.addAttribute("page",page);
        return "sort";
    }
}
