package com.wc.project.fruitshop.mapper;

import com.wc.project.fruitshop.entity.ShopCart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 王超
 * @Description TODO
 * @create 2020/4/20 22:26
 */
@Mapper
public interface ShopCartMapper {

    List<ShopCart> selectCartByUserId(@Param("userId") Integer userId);
    int insertCart(ShopCart shopCart);

    Integer deleteCart(@Param("cartId") Integer cartId);

    List<ShopCart> selectCartsChecked(@Param("userId") Integer userId);

    int updateChecked(@Param("cartId") Integer cartId,@Param("checked") Integer checked);

}
