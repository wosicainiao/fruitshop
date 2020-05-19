package com.wc.project.fruitshop.service.impl;

import com.wc.project.fruitshop.entity.ShopAddress;
import com.wc.project.fruitshop.mapper.ShopAddressMapper;
import com.wc.project.fruitshop.service.ShopAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 收货地址表(ShopAddress)表服务实现类
 *
 * @author makejava
 * @since 2020-05-19 00:58:28
 */
@Service("shopAddressService")
public class ShopAddressServiceImpl implements ShopAddressService {
    @Resource
    private ShopAddressMapper shopAddressMapper;

    @Override
    public List<ShopAddress> selectByUserId(Integer userId) {
        return shopAddressMapper.selectByUserId(userId);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ShopAddress queryById(Integer id) {
        return this.shopAddressMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ShopAddress> queryAllByLimit(int offset, int limit) {
        return this.shopAddressMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param shopAddress 实例对象
     * @return 实例对象
     */
    @Override
    public ShopAddress insert(ShopAddress shopAddress) {
        this.shopAddressMapper.insert(shopAddress);
        return shopAddress;
    }

    /**
     * 修改数据
     *
     * @param shopAddress 实例对象
     * @return 实例对象
     */
    @Override
    public ShopAddress update(ShopAddress shopAddress) {
        this.shopAddressMapper.update(shopAddress);
        return this.queryById(shopAddress.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.shopAddressMapper.deleteById(id) > 0;
    }
}