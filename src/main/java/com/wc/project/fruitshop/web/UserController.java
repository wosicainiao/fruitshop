package com.wc.project.fruitshop.web;

import com.wc.project.fruitshop.entity.ShopUser;
import com.wc.project.fruitshop.service.UserService;
import com.wc.project.fruitshop.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
        return ResponseUtil.success(shopUsers.get(0));
    }
}
