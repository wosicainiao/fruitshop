package com.wc.project.fruitshop.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author 王超
 * @Description TODO
 * @create 2020/4/20 22:06
 */
@Data
public class ShopCart {
    private Integer id;
    private Integer userId;
    private Integer goodsId;
    private String goodsSn;
    private String goodsName;
    private Integer productId;
    private BigDecimal price;
    private BigDecimal activePrice;
    private Short number;
    private Byte checked;
    private String picUrl;
    private LocalDateTime addTime;
    private LocalDateTime updateTime;
    private Byte deleted;

    private String brief;
}
