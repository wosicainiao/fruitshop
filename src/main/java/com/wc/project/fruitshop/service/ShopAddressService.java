package com.wc.project.fruitshop.service;

import com.wc.project.fruitshop.entity.ShopAddress;
import java.util.List;

/**
 * 收货地址表(ShopAddress)表服务接口
 *
 * @author makejava
 * @since 2020-05-19 00:58:28
 */
public interface ShopAddressService {

    List<ShopAddress> selectByUserId(Integer userId);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ShopAddress queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ShopAddress> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param shopAddress 实例对象
     * @return 实例对象
     */
    ShopAddress insert(ShopAddress shopAddress);

    /**
     * 修改数据
     *
     * @param shopAddress 实例对象
     * @return 实例对象
     */
    ShopAddress update(ShopAddress shopAddress);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}