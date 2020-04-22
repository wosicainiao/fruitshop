package com.wc.project.fruitshop.web;

import com.wc.project.fruitshop.core.JacksonUtil;
import com.wc.project.fruitshop.entity.ShopCart;
import com.wc.project.fruitshop.entity.ShopGoods;
import com.wc.project.fruitshop.service.CartService;
import com.wc.project.fruitshop.service.GoodsService;
import com.wc.project.fruitshop.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/fruitshop/cart")
@Validated
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private GoodsService goodsService;

    /**
     * 跳转到购物车界面
     * @return
     */
    @RequestMapping("/shopcart")
    public String shopcart(Integer userId, Model model){
        double sumPrice = 0;
        List<ShopCart> shopCarts = cartService.selectCartByUserId(userId);
        for(ShopCart shopCart: shopCarts){
            sumPrice += (shopCart.getActivePrice().doubleValue())*shopCart.getNumber();
        }
        model.addAttribute("shopCarts",shopCarts);
        model.addAttribute("sumPrice",sumPrice);
        return "shopcart";
    }

    /**
     * 添加购物车
     * @param model
     * @param userId
     * @param shopCart
     * @return
     */
    @PostMapping("/addCart")
    @ResponseBody
    public Object addToCart(Model model,Integer userId, @RequestBody ShopCart shopCart){

        Integer number = shopCart.getNumber().intValue();
        Integer goodsId = shopCart.getGoodsId();

        //判断商品是否可以购买
        ShopGoods shopGoods = goodsService.selectGoodsById(goodsId);
        if (shopGoods == null || shopGoods.getDeleted() != 0){
            model.addAttribute("msg","商品已下架");
            return "shopcart";
        }
        if (shopGoods.getGoodsNum() <= 0){
            model.addAttribute("msg","库存不足");
            return "shopcart";
        }
        shopCart.setId(null);
        shopCart.setUserId(userId);
        shopCart.setGoodsName(shopGoods.getGoodsName());
        shopCart.setPrice(shopGoods.getGoodsPrice());
        shopCart.setActivePrice(shopGoods.getActivePrice());
        shopCart.setPicUrl(shopGoods.getGoodsPicture());
        shopCart.setAddTime(LocalDateTime.now());
        shopCart.setDeleted((byte) 0);
        int result = cartService.insertCart(shopCart);
        if(result != 1){
            return ResponseUtil.fail();
        }else {
            return ResponseUtil.success();
        }
    }

    /**
     * 删除购物车数据
     * @param body
     * @return
     */
    @PostMapping("/deleteCart")
    @ResponseBody
    public Object deleteCart(@RequestBody String body){
        Integer cartId = JacksonUtil.parseInteger(body, "cartId");
        int result = cartService.deleteCart(cartId);
        if(result != 0){
            return ResponseUtil.fail();
        }else {
            return ResponseUtil.success();
        }
    }
}
