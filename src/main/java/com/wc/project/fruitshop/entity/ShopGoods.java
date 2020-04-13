package com.wc.project.fruitshop.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author 王超
 * @Description TODO
 * @create 2020/4/13 0:17
 */
@Data
public class ShopGoods {
    private Integer id;
    private String goodsSn;
    private String goodsName;
    private Integer categoryId;
    private String goodsPicture;
    private String goodsBrief;
    private Integer goodsNum;
    private BigDecimal goodsPrice;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Byte deleted;
}
