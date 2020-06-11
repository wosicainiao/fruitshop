package com.wc.project.fruitshop.web;

import com.github.pagehelper.PageInfo;
import com.wc.project.fruitshop.entity.ShopGoods;
import com.wc.project.fruitshop.entity.ShopOrder;
import com.wc.project.fruitshop.entity.ShopUser;
import com.wc.project.fruitshop.service.GoodsService;
import com.wc.project.fruitshop.service.OrderService;
import com.wc.project.fruitshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 首页
 */
@Controller
@RequestMapping("/fruitshop/home")
@Validated
public class HomeController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/index")
    public String home(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "28") Integer limit,
                       Model model){

        List<ShopGoods> shopGoods = goodsService.selectAll(page, limit);
        long total = PageInfo.of(shopGoods).getTotal();

        Long temp = total % 28 == 0 ? total / 28 :total / 28 + 1;
        Integer pageSum = temp.intValue();
        model.addAttribute("pageSum",pageSum);

        model.addAttribute("total",total);
        model.addAttribute("pageCurrent",page);
        model.addAttribute("goodsList",shopGoods);
        return "home";
    }

    @GetMapping("/personIndex")
    public Object personIndex(Integer userId,Model model){
        ShopUser user = userService.selectUserById(userId);
        List<ShopOrder> shopOrders = orderService.selectOrderByUserId(userId);

        if (shopOrders.size() > 0){
            model.addAttribute("orderNew",shopOrders.get(0));
        }else {
            model.addAttribute("orderNew",null);
        }
        model.addAttribute("user",user);
        return "person/index";
    }
}
