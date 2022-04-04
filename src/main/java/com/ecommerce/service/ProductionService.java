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
                OrderModel orderModel = new OrderModel(orderEntity.get().getOrderCode(),
                        orderEntity.get().getInventoryAddEntity().getSkuEntity().getProductsEntity().getProductName(),
                        orderEntity.get().getInventoryAddEntity().getSkuEntity().getSkuCode(),
                        orderEntity.get().getInventoryAddEntity().getSkuEntity().getSize(),
                        orderEntity.get().getQuantity(),
                        orderEntity.get().getQuantity() * orderEntity.get().getInventoryAddEntity().getSkuEntity().getPriceEntity().getPrice(),
                        orderEntity.get().getStatus());
                return "Order is Processing....😊!";
            }
        }
        return "Not yet Ordered.....😔!";
    }
}
