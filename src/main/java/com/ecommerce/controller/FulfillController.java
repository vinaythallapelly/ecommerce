package com.ecommerce.controller;

import com.ecommerce.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FulfillController {
    @Autowired
    private ProductionService productionService;
    @Autowired
    private PackingService packingService;
    @Autowired
    private ShippingService shippingService;
    @Autowired
    private DeliveryService deliveryService;
    @Autowired
    private ReturnService returnService;


    //Process Order
    @RequestMapping(value = "/processOrder/{orderCode}",method = RequestMethod.GET)
    private String processOrder(@PathVariable Integer orderCode){
        return productionService.processing(orderCode);
    }
    //Packing Order
    @RequestMapping(value = "/packOrder/{orderCode}",method = RequestMethod.GET)
    private String packOrder(@PathVariable Integer orderCode){
        return packingService.pack(orderCode);
    }
    //Shipping Order
    @RequestMapping(value = "/shipOrder/{orderCode}",method = RequestMethod.GET)
    private String shipOrder(@PathVariable Integer orderCode){
        return shippingService.shipping(orderCode);
    }
    //Delivering Order
    @RequestMapping(value = "/deliveryOrder/{orderCode}",method = RequestMethod.GET)
    private String deliveryOrder(@PathVariable Integer orderCode){
        return deliveryService.delivery(orderCode);
    }
    //Delivering Order
    @RequestMapping(value = "/returnOrder/{orderCode}/{quantity}",method = RequestMethod.GET)
    private String returnOrder(@PathVariable Integer orderCode,@PathVariable int quantity){
        return returnService.returned(orderCode,quantity);
    }

}
