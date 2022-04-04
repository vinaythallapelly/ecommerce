package com.ecommerce.service;

import com.ecommerce.entity.InventoryAddEntity;
import com.ecommerce.entity.SkuEntity;
import com.ecommerce.repository.InventoryRepository;
import com.ecommerce.repository.SkuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private SkuRepository skuRepository;

    public String addInventory(Integer skuCode,int quantity) {
        Optional<SkuEntity> skuEntity = skuRepository.findById(skuCode);
        if (skuEntity.isPresent()) {
            InventoryAddEntity inventoryAddEntity=new InventoryAddEntity(skuEntity.get().getSkuCode());
            Optional<InventoryAddEntity> inventoryAddEntity1=inventoryRepository.findById(skuCode);
            if(inventoryAddEntity1.isPresent()){
                return "This skuCode("+skuCode+") inventory already added if u want update inventory then use\n" +
                        "url: updateInventory/skuCode/quantity";
            }
            inventoryAddEntity.setQuantity(quantity);
            inventoryAddEntity.setSkuEntity(skuEntity.get());
            inventoryRepository.save(inventoryAddEntity);
            return "Inventory Added";
        }
        return "SkuCode :"+skuCode+" is not Available";
    }
    public String updateInventory(Integer skuCode,int quantity){
        Optional<InventoryAddEntity> inventoryAddEntity=inventoryRepository.findById(skuCode);
        if(inventoryAddEntity.isPresent()){
            inventoryAddEntity.get().setQuantity(quantity+inventoryAddEntity.get().getQuantity());
            inventoryRepository.save(inventoryAddEntity.get());
            return "Inventory Added....";
        }
        return "SkuCode Does Not Exists....";
    }
}
