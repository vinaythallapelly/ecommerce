package com.ecommerce.service;

import com.ecommerce.entity.OrderEntity;
import com.ecommerce.entity.ShippingEntity;
import com.ecommerce.repository.OrderRepository;
import com.ecommerce.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShippingService {
    @Autowired
    private ShippingRepository shippingRepository;
    @Autowired
    private OrderRepository orderRepository;
    public String shipping(Integer orderCode){
        Optional<OrderEntity> orderEntity = orderRepository.findById(orderCode);
        if (orderEntity.isPresent()) {
            if (orderEntity.get().getStatus().equalsIgnoreCase("PACKING")) {
                ShippingEntity shippingEntity=new ShippingEntity(orderEntity.get().getOrderCode(),"SHIPPING");
                orderEntity.get().setStatus(shippingEntity.getStatus());
                shippingRepository.save(shippingEntity);
                orderRepository.save(orderEntity.get());
                return "Order is Shipping.....😊!";
            }
            else if(orderEntity.get().getStatus().equalsIgnoreCase("RECEIVED")){
                return "Order is not Processed & Packed.....😔!";
            }
            else if(orderEntity.get().getStatus().equalsIgnoreCase("PROCESSING")){
                return "Order is not Packed yet.....😔!";
            }
        }
        return "OrderCode is Wrong.....☹!";
    }
}
