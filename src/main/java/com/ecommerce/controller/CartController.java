package com.ecommerce.controller;

import com.ecommerce.model.CartModel;
import com.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {
    @Autowired
    private CartService cartService;

    //Adding products in to CartEntity
    @RequestMapping(value = "/addCart/{skuCode}/{quantity}",method = RequestMethod.POST)
    private String addCart(@PathVariable Integer skuCode, @PathVariable int quantity){
        return  cartService.addCart(skuCode,quantity);
    }
    //Getting products in the cart
    @RequestMapping(value = "/viewCart",method = RequestMethod.GET)
    private List<CartModel> viewCart(){
        return cartService.viewCart();
    }

}
