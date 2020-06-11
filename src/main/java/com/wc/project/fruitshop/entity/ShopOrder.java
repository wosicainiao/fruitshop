package com.wc.project.fruitshop.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.io.Serializable;

/**
 * 订单表(ShopOrder)实体类
 *
 * @author makejava
 * @since 2020-05-22 23:16:34
 */
@Data
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
    private BigDecimal goodsPrice;
    /**
    * 配送费用
    */
    private BigDecimal freightPrice;
    /**
    * 订单费用， = goods_price + freight_price - coupon_price
    */
    private BigDecimal orderPrice;
    /**
    * 实付费用， = order_price - integral_price
    */
    private BigDecimal actualPrice;
    /**
    * 用户确认收货时间
    */
    private LocalDateTime confirmTime;
    /**
    * 待评价订单商品数量
    */
    private Object comments;
    /**
    * 订单关闭时间
    */
    private LocalDateTime endTime;
    /**
    * 创建时间
    */
    private LocalDateTime addTime;
    /**
    * 更新时间
    */
    private LocalDateTime updateTime;
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

    private String orderImg;

    private String goodsName;

    private Integer goodsNumber;

    private String arriveTime;
}