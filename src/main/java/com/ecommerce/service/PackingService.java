package com.ecommerce.service;

import com.ecommerce.entity.OrderEntity;
import com.ecommerce.entity.PackingEntity;
import com.ecommerce.model.OrderModel;
import com.ecommerce.repository.OrderRepository;
import com.ecommerce.repository.PackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PackingService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private PackingRepository packingRepository;

    public String pack(Integer orderCode) {
        Optional<OrderEntity> orderEntity = orderRepository.findById(orderCode);
        if (orderEntity.isPresent()) {
            if (orderEntity.get().getStatus().equalsIgnoreCase("PROCESSING")) {
                PackingEntity packingEntity=new PackingEntity(orderEntity.get().getOrderCode(),"PACKING");
                orderEntity.get().setStatus(packingEntity.getStatus());
                packingRepository.save(packingEntity);
                orderRepository.save(orderEntity.get());
                return "Order is Packing....😊!";
            }
            else if(orderEntity.get().getStatus().equalsIgnoreCase("RECEIVED")){
                return "Order is not Processed Yet.....😔!";
            }
        }
        return "OrderCode is Wrong";
    }
}
