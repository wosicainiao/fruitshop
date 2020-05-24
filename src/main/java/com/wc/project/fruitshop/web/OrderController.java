package com.wc.project.fruitshop.web;

import com.wc.project.fruitshop.core.JacksonUtil;
import com.wc.project.fruitshop.entity.ShopCart;
import com.wc.project.fruitshop.entity.ShopOrder;
import com.wc.project.fruitshop.service.CartService;
import com.wc.project.fruitshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/fruitshop/order")
@Validated
public class OrderController {

    @Autowired
    private CartService cartService;
    @Autowired
    private OrderService orderService;
    /**
     *
     * @return
     */
    @GetMapping("/paySuccess")
    public Object paySuccess(@RequestBody String body){
        Integer userId = JacksonUtil.parseInteger(body, "userId");
        String receiveName = JacksonUtil.parseString(body, "receiveName");
        String mobile = JacksonUtil.parseString(body, "mobile");
        String address = JacksonUtil.parseString(body, "address");
        String message = JacksonUtil.parseString(body, "message");


        List<ShopCart> shopCarts = cartService.selectCartByUserId(userId);
        String orderSn = orderService.generateOrderSn(userId);
        for (ShopCart shopcart:shopCarts) {
            ShopOrder shopOrder = new ShopOrder();
            shopOrder.setOrderSn(orderSn);
            shopOrder.setOrderStatus("1");
            shopOrder.setConsignee(receiveName);
            shopOrder.setMobile(mobile);
            shopOrder.setAddress(address);
            shopOrder.setMessage(message);
//            shopOrder.setOrderPrice(orderPrice);
        }
        return "success";
    }
}
