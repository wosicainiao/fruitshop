package com.wc.project.fruitshop.web;

import com.wc.project.fruitshop.utils.ResponseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;

@Controller
@RequestMapping("/fruitshop/user")
@Validated
public class UserController {

    /**
     * 跳转到登录界面
     * @return
     */
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * 账号密码登录
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/loginByPwd")
    public Object loginByPwd(String username, String password){
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            return ResponseUtil.fail(-1,"用户名或密码不能为空!");
        }
        return null;
    }
}
