package com.wc.project.fruitshop.web;

import com.wc.project.fruitshop.core.JacksonUtil;
import com.wc.project.fruitshop.entity.ShopAddress;
import com.wc.project.fruitshop.entity.ShopCart;
import com.wc.project.fruitshop.entity.ShopOrder;
import com.wc.project.fruitshop.mapper.ShopOrderMapper;
import com.wc.project.fruitshop.service.CartService;
import com.wc.project.fruitshop.service.OrderService;
import com.wc.project.fruitshop.service.ShopAddressService;
import com.wc.project.fruitshop.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/fruitshop/order")
@Validated
public class OrderController {

    @Autowired
    private CartService cartService;
    @Autowired
    private OrderService orderService;

    @Autowired
    private ShopAddressService addressService;
    @Resource
    private ShopOrderMapper orderMapper;

    @GetMapping("/paySuccess")
    public Object paySuccess(){
        return "success";
    }

    @GetMapping("/myOrder")
    public Object myOrder(Integer userId, Model model){
        List<ShopOrder> shopOrders = orderService.selectOrderByUserId(userId);

        model.addAttribute("orders",shopOrders);
        return "person/order";
    }
    /**
     *
     * @return
     */
    @PostMapping("/submitOrder")
    @ResponseBody
    public Object submitOrder(@RequestBody String body){
        Integer userId = JacksonUtil.parseInteger(body, "userId");
        Integer addressId = JacksonUtil.parseInteger(body, "addressId");
        String message = JacksonUtil.parseString(body, "message");
        String arriveTime = JacksonUtil.parseString(body, "arriveTime");

        ShopAddress shopAddress = addressService.queryById(addressId);
        List<ShopCart> shopCarts = cartService.selectCartsChecked(userId);
        String orderSn = orderService.generateOrderSn(userId);
        for (ShopCart shopcart:shopCarts) {
            ShopOrder shopOrder = new ShopOrder();
            shopOrder.setUserId(userId);
            shopOrder.setOrderSn(orderSn);
            shopOrder.setOrderStatus("1");
            shopOrder.setConsignee(shopAddress.getName());
            shopOrder.setMobile(shopAddress.getTel());
            shopOrder.setAddress(shopAddress.getProvince()+shopAddress.getCity()+shopAddress.getCounty()+shopAddress.getAddressDetail());
            shopOrder.setMessage(message);
            shopOrder.setGoodsPrice(shopcart.getPrice());
            shopOrder.setOrderPrice(shopcart.getActivePrice());
            shopOrder.setActualPrice(shopcart.getActivePrice().multiply(new BigDecimal(shopcart.getNumber())));
            shopOrder.setConfirmTime(LocalDateTime.now());
            shopOrder.setAddTime(LocalDateTime.now());
            shopOrder.setUpdateTime(LocalDateTime.now());
            shopOrder.setDeleted(0);
            shopOrder.setPayType("在线支付");
            shopOrder.setGoodsName(shopcart.getGoodsName());
            shopOrder.setOrderImg(shopcart.getPicUrl());
            shopOrder.setGoodsNumber((int)shopcart.getNumber());
            shopOrder.setArriveTime(arriveTime);
            orderMapper.insert(shopOrder);
        }
        int result = cartService.deleteCheckedCart(userId);
        return ResponseUtil.success(result);
    }
}
