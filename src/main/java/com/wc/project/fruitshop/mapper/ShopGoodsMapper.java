package com.wc.project.fruitshop.mapper;

import com.wc.project.fruitshop.entity.ShopGoods;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author 王超
 * @Description TODO
 * @create 2020/4/13 0:17
 */
public interface ShopGoodsMapper extends Mapper<ShopGoods> {
    /**
     * 通过关键词查询商品
     * @param keyword
     * @return
     */
    List<ShopGoods> selectGoodsByKeyword(@Param("keyword") String keyword);
}
