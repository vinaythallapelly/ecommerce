package com.ecommerce.service;

import com.ecommerce.entity.*;
import com.ecommerce.model.ProductModel;
import com.ecommerce.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private SkuRepository skuRepository;
    @Autowired
    private PriceRepository priceRepository;


    // Adding products
    public String addProducts(ProductModel productModel){
        ProductEntity productEntity =new ProductEntity(productModel.getProductName(),
                productModel.getDescription());
        productRepository.save(productEntity);

        productModel.getSkuModel().stream().forEach(skus->{
            SkuEntity skuEntity1=new SkuEntity(skus.getSkuCode(),skus.getSize());
            skuRepository.save(skuEntity1);
            PriceEntity priceEntity=new PriceEntity(skuEntity1.getSkuCode(),skus.getPrice());
            skuEntity1.setProductsEntity(productEntity);
            priceEntity.setSkuEntity(skuEntity1);
            priceRepository.save(priceEntity);
        });
        return "Product Added Successfully";
    }


}
