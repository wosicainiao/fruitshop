package com.wc.project.fruitshop.mapper;

import com.wc.project.fruitshop.entity.ShopAddress;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 收货地址表(ShopAddress)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-19 00:58:23
 */
@Mapper
public interface ShopAddressMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ShopAddress queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ShopAddress> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param shopAddress 实例对象
     * @return 对象列表
     */
    List<ShopAddress> queryAll(ShopAddress shopAddress);

    /**
     * 新增数据
     *
     * @param shopAddress 实例对象
     * @return 影响行数
     */
    int insert(ShopAddress shopAddress);

    /**
     * 修改数据
     *
     * @param shopAddress 实例对象
     * @return 影响行数
     */
    int update(ShopAddress shopAddress);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<ShopAddress> selectByUserId(Integer userId);
}