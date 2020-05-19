package com.wc.project.fruitshop.web;

import com.wc.project.fruitshop.entity.ShopAddress;
import com.wc.project.fruitshop.service.ShopAddressService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 收货地址表(ShopAddress)表控制层
 *
 * @author makejava
 * @since 2020-05-19 00:58:30
 */
@RestController
@RequestMapping("/fruitshop/address")
public class ShopAddressController {
    /**
     * 服务对象
     */
    @Resource
    private ShopAddressService shopAddressService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public ShopAddress selectOne(Integer id) {
        return this.shopAddressService.queryById(id);
    }


    /**
     * 通过userId查询地址
     * @param userId
     * @return
     */
    @GetMapping("/selectByUserId")
    public List<ShopAddress> selectAddressByUserId(Integer userId){
        return shopAddressService.selectByUserId(userId);
    }
}