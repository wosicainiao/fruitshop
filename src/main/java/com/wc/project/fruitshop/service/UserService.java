package com.wc.project.fruitshop.service;

import com.wc.project.fruitshop.core.AbstractService;
import com.wc.project.fruitshop.entity.ShopUser;
import com.wc.project.fruitshop.mapper.ShopUserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author 王超
 * @Description TODO
 * @create 2020/3/1 23:47
 */
@Service
public class UserService  {

    @Resource
    private ShopUserMapper shopUserMapper;

    /**
     * 查询用户信息
     * @param username
     * @return
     */
    public List<ShopUser> selectUserInfo(String username){
        return shopUserMapper.selectUserByUsername(username);
    }

    /**
     * 注册用户
     * @param user
     * @return
     */
    public int insertUser(ShopUser user){
        user.setAvatar("https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=4090061760,3566002114&fm=26&gp=0.jpg");
        user.setNickname("新用户");
        return shopUserMapper.insertUser(user);
    }
}
