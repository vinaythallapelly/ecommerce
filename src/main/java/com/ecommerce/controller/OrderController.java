package com.ecommerce.controller;

import com.ecommerce.model.OrderModel;
import com.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    //Placing Order
    @RequestMapping(value = "/placeOrder/{skuCode}/{quantity}",method = RequestMethod.POST)
    private String placeOrder(@PathVariable Integer skuCode, @PathVariable int quantity){
        return orderService.placeOrder(skuCode,quantity);
    }

    //Check status
    @RequestMapping(value = "/orderStatus/{orderCode}",method = RequestMethod.GET)
    private OrderModel orderStatus(@PathVariable Integer orderCode){
        return orderService.orderStatus(orderCode);
    }


}
