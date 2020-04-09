package com.wc.project.fruitshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fruitshop/user")
@Validated
public class CartController {


    /**
     * 跳转到购物车界面
     * @return
     */
    @GetMapping("/shopcart")
    public String shopcart(){
        return "shopcart";
    }
}
