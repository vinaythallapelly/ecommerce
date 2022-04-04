package com.ecommerce.controller;

import com.ecommerce.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;
    //Adding products in to Inventory entity with quantity
    @RequestMapping(value = "/addInventory/{skuCode}/{quantity}",method = RequestMethod.POST)
    private String add(@PathVariable Integer skuCode, @PathVariable int quantity){
        return inventoryService.addInventory(skuCode,quantity);
    }
    //Updating Inventory
    @RequestMapping(value = "updateInventory/{skuCode}/{quantity}",method = RequestMethod.PUT)
    private String updateInventory(@PathVariable Integer skuCode,@PathVariable int quantity){
        return inventoryService.updateInventory(skuCode,quantity);
    }

}
