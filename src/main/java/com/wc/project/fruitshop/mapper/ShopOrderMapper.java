package com.wc.project.fruitshop.mapper;

import com.wc.project.fruitshop.entity.ShopOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 订单表(ShopOrder)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-31 23:51:55
 */
@Mapper
public interface ShopOrderMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ShopOrder queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ShopOrder> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param shopOrder 实例对象
     * @return 对象列表
     */
    List<ShopOrder> queryAll(ShopOrder shopOrder);

    /**
     * 新增数据
     *
     * @param shopOrder 实例对象
     * @return 影响行数
     */
    int insert(ShopOrder shopOrder);

    /**
     * 修改数据
     *
     * @param shopOrder 实例对象
     * @return 影响行数
     */
    int update(ShopOrder shopOrder);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<ShopOrder> selectOrderByUserId(Integer userId);

}