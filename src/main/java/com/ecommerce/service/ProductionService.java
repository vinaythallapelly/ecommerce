package com.ecommerce.service;

import com.ecommerce.entity.OrderEntity;
import com.ecommerce.entity.ProductionEntity;
import com.ecommerce.model.OrderModel;
import com.ecommerce.repository.OrderRepository;
import com.ecommerce.repository.ProductionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductionService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductionRepository productionsRepository;

    public String processing(Integer orderCode){
        Optional<OrderEntity> orderEntity=orderRepository.findById(orderCode);
        if(orderEntity.isPresent()){
            if("RECEIVED".equalsIgnoreCase(orderEntity.get().getStatus())) {
                ProductionEntity productionEntity=new ProductionEntity(orderEntity.get().getOrderCode(),"PROCESSING");
                productionsRepository.save(productionEntity);
                orderEntity.get().setStatus(productionEntity.getStatus());
                orderRepository.save(orderEntity.get());
                return "Order is Processing....😊!";
            }
        }
        return "Not yet Ordered.....😔!";
    }
}
