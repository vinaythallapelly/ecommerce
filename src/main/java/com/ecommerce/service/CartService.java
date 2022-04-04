package com.ecommerce.service;

import com.ecommerce.entity.CartEntity;
import com.ecommerce.entity.InventoryAddEntity;
import com.ecommerce.model.CartModel;
import com.ecommerce.repository.CartRepository;
import com.ecommerce.repository.InventoryRepository;
import com.ecommerce.repository.SkuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartService {
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private SkuRepository skuRepository;
    @Autowired
    private CartRepository cartRepository;

    public String addCart(Integer skuCode, int quantity){
        Optional<InventoryAddEntity> inventoryAdd=inventoryRepository.findById(skuCode);
        if(inventoryAdd.isPresent()){
            if(quantity<=inventoryAdd.get().getQuantity() ) {
                Optional<CartEntity> cartEntity1=cartRepository.findBySkuEntity(Optional.ofNullable(inventoryAdd.get().getSkuEntity()));
                if(cartEntity1.isPresent()){
                    cartEntity1.get().setQuantity(quantity);
                    cartRepository.save(cartEntity1.get());
                    return "Cart Updated Successfully...\n" +
                            "SkuCode : "+skuCode;
                }
                CartEntity cartEntity = new CartEntity(quantity);
                cartEntity.setSkuEntity(inventoryAdd.get().getSkuEntity());
                cartRepository.save(cartEntity);
                return "Products are added to the Cart";
            }
            return "OUT OF STOCK";
        }
        else
            return "Product not Available";
    }

    public List<CartModel> viewCart(){
        List<CartEntity> cartEntity=cartRepository.findAll();
        Double[] totalPrice ={0.0};
        List<CartModel> cartModels=cartEntity.stream().map(abc ->{
            totalPrice[0]+=(abc.getSkuEntity().getPriceEntity().getPrice()*abc.getQuantity());
            CartModel cM = new CartModel(
                abc.getCartCode(), abc.getSkuEntity().getProductsEntity().getProductCode(),
                abc.getSkuEntity().getSkuCode(),
                abc.getSkuEntity().getProductsEntity().getProductName(),
                abc.getSkuEntity().getProductsEntity().getDescription(),
                abc.getSkuEntity().getSize(),
                abc.getSkuEntity().getPriceEntity().getPrice(),
                abc.getQuantity());
            cM.setTotalPrice((totalPrice[0]));
        return cM;
        }).collect(Collectors.toList());

        return cartModels;
    }
}
