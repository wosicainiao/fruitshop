package com.wc.project.fruitshop.web;

import com.github.pagehelper.PageInfo;
import com.wc.project.fruitshop.entity.ShopGoods;
import com.wc.project.fruitshop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/fruitshop/goods")
@Validated
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/searchGoods")
    public Object searchGoods(String keyword,
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
        return "search";
    }

    /**
     * 商品详情
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/detail")
    public String detail(Model model,@NotNull Integer id){
        ShopGoods goods = goodsService.selectGoodsById(id);
        model.addAttribute("goods",goods);
        return  "introduction";
    }

    /**
     * 查询货品库存
     * @param id
     * @return
     */
    @RequestMapping(value = "/findProductStock")
    @ResponseBody
    public Object findProductStock(Integer id){
        Map<String,Object> data = new HashMap<>();
        ShopGoods product = goodsService.selectGoodsById(id);
        if (product != null) {
            data.put("result","success");
            data.put("product",product);
        } else {
            data.put("result","failed");
        }
        return data;
    }
}
