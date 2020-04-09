package com.wc.project.fruitshop.web;

import com.wc.project.fruitshop.entity.ShopUser;
import com.wc.project.fruitshop.service.UserService;
import com.wc.project.fruitshop.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@Controller
@RequestMapping("/fruitshop/user")
@Validated
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 跳转到登录界面
     * @return
     */
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * 跳转到注册界面
     * @return
     */
    @GetMapping("/register")
    public String register(){
        return "register";
    }
    /**
     * 账号密码登录
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/loginByPwd")
    @ResponseBody
    public Object loginByPwd(String username, String password){
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            return ResponseUtil.emptyParam();
        }
        ShopUser shopUser = new ShopUser();
        shopUser.setUsername(username);
        List<ShopUser> shopUsers = userService.selectUserInfo(shopUser);
        if (shopUsers == null || shopUsers.size() == 0){
            return ResponseUtil.userNotExist();
        }
        ShopUser user = shopUsers.get(0);
        if (user.getPassword().equals(password)){
            user.setPassword("");
            return ResponseUtil.success(user);
        }else {
            return ResponseUtil.errorPassword();
        }
    }

    public Object initialUser(){
        ShopUser user = new ShopUser();
        user.setAvatar("https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=4090061760,3566002114&fm=26&gp=0.jpg");
        return ResponseUtil.success(user);
    }

    /**
     * 注册
     * @param email
     * @param passwordEmail
     * @return
     */
    @PostMapping("/registerUser")
    @ResponseBody
    public Object registerUser(String email,String passwordEmail){
        if (StringUtils.isEmpty(email) || StringUtils.isEmpty(passwordEmail)){
            return ResponseUtil.fail(-1,"邮箱和密码不能为空");
        }
        //查询用户是否已经存在
        ShopUser shopUser = new ShopUser();
        shopUser.setUsername(email);
        List<ShopUser> shopUsers = userService.selectUserInfo(shopUser);
        if (shopUsers!=null && shopUsers.size()>0){
            return ResponseUtil.userIsExist();
        }else {
            shopUser.setPassword(passwordEmail);
            int result = userService.insertUser(shopUser);
            if (result == 1){
                return ResponseUtil.success();
            }else {
                return ResponseUtil.fail(-1,"添加用户失败!");
            }

        }
    }
}
