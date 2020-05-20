package com.wc.project.fruitshop.service;

import com.github.pagehelper.PageHelper;
import com.wc.project.fruitshop.entity.ShopGoods;
import com.wc.project.fruitshop.mapper.ShopGoodsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author 王超
 * @Description TODO
 * @create 2020/4/13 0:45
 */
@Service
public class GoodsService {

    @Resource
    private ShopGoodsMapper goodsMapper;

    public List<ShopGoods> selectGoodsByKeyword(String keyword,Integer page, Integer limit){
        PageHelper.startPage(page, limit);
        return goodsMapper.selectGoodsByKeyword(keyword);
    }

    public ShopGoods selectGoodsById(Integer id){
        return goodsMapper.selectGoodsById(id);
    }

    public int insertGoods(ShopGoods shopGoods){
        return goodsMapper.insertGoods(shopGoods);
    }

    public List<ShopGoods> selectAll(Integer page,Integer limit){
        PageHelper.startPage(page,limit);
        return goodsMapper.selectAll();
    }
}
