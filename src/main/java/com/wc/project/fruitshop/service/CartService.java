package com.wc.project.fruitshop.service;

import com.wc.project.fruitshop.entity.ShopCart;
import com.wc.project.fruitshop.mapper.ShopCartMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author 王超
 * @Description TODO
 * @create 2020/4/20 22:25
 */
@Service
public class CartService {
    @Resource
    private ShopCartMapper cartMapper;

    public List<ShopCart> selectCartByUserId(Integer userId){
        return cartMapper.selectCartByUserId(userId);
    }

    public int insertCart(ShopCart shopCart){
        shopCart.setAddTime(LocalDateTime.now());
        shopCart.setUpdateTime(LocalDateTime.now());
        shopCart.setDeleted((byte) 0);
        return cartMapper.insertCart(shopCart);
    }
}
