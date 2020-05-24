package com.wc.project.fruitshop.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 订单表(ShopOrder)实体类
 *
 * @author makejava
 * @since 2020-05-22 23:16:34
 */
public class ShopOrder implements Serializable {
    private static final long serialVersionUID = 660047890269650730L;
    
    private Integer id;
    /**
    * 用户表的用户ID
    */
    private Integer userId;
    /**
    * 订单编号
    */
    private String orderSn;
    /**
    * 订单状态
    */
    private Object orderStatus;
    /**
    * 收货人名称
    */
    private String consignee;
    /**
    * 收货人手机号
    */
    private String mobile;
    /**
    * 收货具体地址
    */
    private String address;
    /**
    * 用户订单留言
    */
    private String message;
    /**
    * 商品总费用
    */
    private Double goodsPrice;
    /**
    * 配送费用
    */
    private Double freightPrice;
    /**
    * 订单费用， = goods_price + freight_price - coupon_price
    */
    private Double orderPrice;
    /**
    * 实付费用， = order_price - integral_price
    */
    private Double actualPrice;
    /**
    * 用户确认收货时间
    */
    private Date confirmTime;
    /**
    * 待评价订单商品数量
    */
    private Object comments;
    /**
    * 订单关闭时间
    */
    private Date endTime;
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
    /**
    * 商户代码
    */
    private String businessCode;
    /**
    * 支付类型
    */
    private String payType;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Object getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Object orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Double getFreightPrice() {
        return freightPrice;
    }

    public void setFreightPrice(Double freightPrice) {
        this.freightPrice = freightPrice;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(Double actualPrice) {
        this.actualPrice = actualPrice;
    }

    public Date getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
    }

    public Object getComments() {
        return comments;
    }

    public void setComments(Object comments) {
        this.comments = comments;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

}