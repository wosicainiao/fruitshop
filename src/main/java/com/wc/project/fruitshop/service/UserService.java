package com.wc.project.fruitshop.service;

import com.wc.project.fruitshop.entity.ShopUser;
import com.wc.project.fruitshop.mapper.ShopUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 王超
 * @Description TODO
 * @create 2020/3/1 23:47
 */
@Service
public class UserService {

    @Autowired
    private ShopUserMapper shopUserMapper;

    /**
     * 查询用户信息
     * @param shopUser
     * @return
     */
    public List<ShopUser> selectUserInfo(ShopUser shopUser){
        return shopUserMapper.select(shopUser);
    }
}
