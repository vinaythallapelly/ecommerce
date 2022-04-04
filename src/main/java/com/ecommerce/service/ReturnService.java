package com.ecommerce.service;

import com.ecommerce.entity.OrderEntity;
import com.ecommerce.entity.ReturnEntity;
import com.ecommerce.model.OrderModel;
import com.ecommerce.repository.InventoryRepository;
import com.ecommerce.repository.OrderRepository;
import com.ecommerce.repository.ReturnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReturnService {
    @Autowired
    private ReturnRepository returnRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private InventoryRepository inventoryRepository1;
    @Autowired
    private InventoryService inventoryService;

    public String returned(Integer orderCode,Integer quantity){
        Optional<OrderEntity> orderEntity = orderRepository.findById(orderCode);
        if (orderEntity.isPresent()) {
            if (orderEntity.get().getStatus().equalsIgnoreCase("DELIVERED")) {
                ReturnEntity returnEntity=new ReturnEntity(orderCode,"RETURNED",quantity);
                orderEntity.get().setStatus(returnEntity.getStatus());
                returnRepository.save(returnEntity);
                orderRepository.save(orderEntity.get());
                OrderModel orderModel = new OrderModel(orderEntity.get().getOrderCode(),
                        orderEntity.get().getInventoryAddEntity().getSkuEntity().getProductsEntity().getProductName(),
                        orderEntity.get().getInventoryAddEntity().getSkuEntity().getSkuCode(),
                        orderEntity.get().getInventoryAddEntity().getSkuEntity().getSize(),
                        orderEntity.get().getQuantity(),
                        orderEntity.get().getQuantity() * orderEntity.get().getInventoryAddEntity().getSkuEntity().getPriceEntity().getPrice(),
                        orderEntity.get().getStatus());
                inventoryService.updateInventory(orderEntity.get().getInventoryAddEntity().getSkuCode(),quantity);
                return "Order is Returned Successfully.....😊!";
            }
            else if(!orderEntity.get().getStatus().equalsIgnoreCase("DELIVERED")){
                return "Wait until the order Delivered.....😔!";
            }
        }
        return "OrderCode is Wrong.....☹!";
    }
}
