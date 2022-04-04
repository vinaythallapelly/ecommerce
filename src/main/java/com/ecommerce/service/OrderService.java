package com.ecommerce.service;

import com.ecommerce.entity.*;
import com.ecommerce.model.OrderModel;
import com.ecommerce.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private SkuRepository skuRepository;
    @Autowired
    private ProductRepository productRepository;


    public String placeOrder(Integer skuCode,int quantity){
        Optional<InventoryAddEntity> inventoryAdd=inventoryRepository.findById(skuCode);
        if(inventoryAdd.isPresent()){
            if(quantity<=inventoryAdd.get().getQuantity()){
                OrderEntity orderEntity = new OrderEntity("RECEIVED",quantity);
                orderEntity.setInventoryAddEntity(inventoryAdd.get());
                orderRepository.save(orderEntity);
                inventoryAdd.get().setQuantity(inventoryAdd.get().getQuantity()-quantity);
                inventoryRepository.save(inventoryAdd.get());
                Optional<CartEntity> cart= cartRepository.findBySkuEntity(Optional.ofNullable(inventoryAdd.get().getSkuEntity()));
                if (cart.isPresent()){
                    cartRepository.deleteById(cart.get().getSkuEntity().getSkuCode());
                   // cartRepository.deleteBySkuEntity(inventoryAdd.get().getSkuEntity());
                }
                return "Product Ordered Successfully,"+
                        "Order Code : "+orderEntity.getOrderCode();
            }
                return "OUT OF STOCK";
        }
        return "SkuCOde is Does Not Exists...";
    }


    public OrderModel orderStatus(Integer orderCode){
        Optional<OrderEntity> orderEntity=orderRepository.findById(orderCode);
        if(orderEntity.isPresent()){
            OrderModel orderModel = new OrderModel(orderEntity.get().getOrderCode(),
                    orderEntity.get().getInventoryAddEntity().getSkuEntity().getProductsEntity().getProductName(),
                    orderEntity.get().getInventoryAddEntity().getSkuEntity().getSkuCode(),
                    orderEntity.get().getInventoryAddEntity().getSkuEntity().getSize(),
                    orderEntity.get().getQuantity(),
                    orderEntity.get().getQuantity()*orderEntity.get().getInventoryAddEntity().getSkuEntity().getPriceEntity().getPrice(),
                    orderEntity.get().getStatus());
            return orderModel;
        }
        return null;
    }
}
