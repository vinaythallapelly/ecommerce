package com.ecommerce.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productCode;
    private String productName;
    private String description;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "productEntity")
    private List<SkuEntity> skuEntity;

    public ProductEntity() {
    }

    public ProductEntity(String productName, String description) {
        this.productName = productName;
        this.description = description;
    }

    public ProductEntity(String productName, String description, List<SkuEntity> skuEntity) {
        this.productName = productName;
        this.description = description;
        this.skuEntity = skuEntity;
    }

    public Integer getProductCode() {
        return productCode;
    }

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }

    public List<SkuEntity> getSkuEntity() {
        return skuEntity;
    }
}
