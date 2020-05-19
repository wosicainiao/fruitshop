package com.wc.project.fruitshop.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 收货地址表(ShopAddress)实体类
 *
 * @author makejava
 * @since 2020-05-19 00:58:23
 */
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
    private Object isDefault;
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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Object getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Object isDefault) {
        this.isDefault = isDefault;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Object getDeleted() {
        return deleted;
    }

    public void setDeleted(Object deleted) {
        this.deleted = deleted;
    }

}