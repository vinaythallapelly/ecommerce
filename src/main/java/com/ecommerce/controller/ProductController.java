package com.ecommerce.controller;
import com.ecommerce.model.ProductModel;
import com.ecommerce.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private CartService cartService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private PackingService packingService;
    @Autowired
    private ProductionService productionService;
    @Autowired
    private ShippingService shippingService;
    @Autowired
    private DeliveryService deliveryService;
    @Autowired
    private ReturnService returnService;

//Adding products in to products entity with sizes and prices
    @RequestMapping(value = "/addProducts",method = RequestMethod.POST)
    private String add(@RequestBody ProductModel productModel){
        return productService.addProducts(productModel);
    }


}
