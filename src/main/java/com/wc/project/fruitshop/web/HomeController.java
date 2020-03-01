package com.wc.project.fruitshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页
 */
@Controller
@RequestMapping("/fruitshop/home")
@Validated
public class HomeController {

    @GetMapping("/index")
    public String home(){
        return "home";
    }

}
