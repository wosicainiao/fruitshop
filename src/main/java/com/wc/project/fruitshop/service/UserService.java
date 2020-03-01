package com.wc.project.fruitshop.service;

import com.wc.project.fruitshop.entity.User;
import com.wc.project.fruitshop.mapper.UserMapper;
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
    private UserMapper userMapper;

    /**
     * 查询用户信息
     * @param user
     * @return
     */
    public List<User> selectUserInfo(User user){
        return userMapper.select(user);
    }
}
