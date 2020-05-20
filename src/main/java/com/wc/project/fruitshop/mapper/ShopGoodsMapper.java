package com.wc.project.fruitshop.mapper;

import com.wc.project.fruitshop.entity.ShopGoods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 王超
 * @Description TODO
 * @create 2020/4/13 0:17
 */
@Mapper
public interface ShopGoodsMapper {
    /**
     * 通过关键词查询商品
     * @param keyword
     * @return
     */
    List<ShopGoods> selectGoodsByKeyword(@Param("keyword") String keyword);

    ShopGoods selectGoodsById(@Param("id") Integer id);

    int insertGoods(ShopGoods shopGoods);

    List<ShopGoods> selectAll();
}
