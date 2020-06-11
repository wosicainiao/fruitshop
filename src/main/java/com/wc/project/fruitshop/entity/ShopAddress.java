package com.wc.project.fruitshop.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 收货地址表(ShopAddress)实体类
 *
 * @author makejava
 * @since 2020-05-19 00:58:23
 */
@Data
public class ShopAddress implements Serializable {
    private static final long serialVersionUID = 384045003305698984L;
    
    private Integer id;
    /**
    * 收货人名称
    */
    private String name;
    /**
    * 用户表的用户ID
    */
    private Integer userId;
    /**
    * 行政区域表的省ID
    */
    private String province;
    /**
    * 行政区域表的市ID
    */
    private String city;
    /**
    * 行政区域表的区县ID
    */
    private String county;
    /**
    * 详细收货地址
    */
    private String addressDetail;
    /**
    * 地区编码
    */
    private String areaCode;
    /**
    * 手机号码
    */
    private String tel;
    /**
    * 是否默认地址
    */
    private Boolean isDefault;
    /**
    * 创建时间
    */
    private Date addTime;
    /**
    * 更新时间
    */
    private Date updateTime;
    /**
    * 逻辑删除
    */
    private Object deleted;
    }