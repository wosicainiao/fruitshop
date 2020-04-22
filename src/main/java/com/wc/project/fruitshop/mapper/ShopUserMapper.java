package com.wc.project.fruitshop.mapper;

import com.wc.project.fruitshop.entity.ShopUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author 王超
 * @Description TODO
 * @create 2020/2/18 14:28
 */
@Mapper
public interface ShopUserMapper  {
    List<ShopUser> selectUserById(Integer id);
    List<ShopUser> selectUserByUsername(String username);
    int insertUser(ShopUser shopUser);
}
