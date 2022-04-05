package com.ecommerce.service;

import com.ecommerce.entity.DeliveryEntity;
import com.ecommerce.entity.OrderEntity;
import com.ecommerce.model.OrderModel;
import com.ecommerce.repository.DeliveryRepository;
import com.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;
    @Autowired
    private OrderRepository orderRepository;

    public String delivery(Integer orderCode){
        Optional<OrderEntity> orderEntity = orderRepository.findById(orderCode);
        if (orderEntity.isPresent()) {
            if (orderEntity.get().getStatus().equalsIgnoreCase("SHIPPING")) {
                DeliveryEntity deliveryEntity=new DeliveryEntity(orderCode,"DELIVERED");
                orderEntity.get().setStatus(deliveryEntity.getStatus());
                deliveryRepository.save(deliveryEntity);
                orderRepository.save(orderEntity.get());
                return "Order is Delivered.....😊!";
            }
            else if(orderEntity.get().getStatus().equalsIgnoreCase("RECEIVED")){
                return "Order is not Processed, Packed & Shipped.....😔!";
            }
            else if(orderEntity.get().getStatus().equalsIgnoreCase("PROCESSED")){
                return "Order is not Packed & Shipped.....😔!";
            }
            else if(orderEntity.get().getStatus().equalsIgnoreCase("PACKING")){
                return "Order is not Shipped yet.....😔!";
            }
        }
        return "OrderCode is Wrong.....☹!";
    }
}
