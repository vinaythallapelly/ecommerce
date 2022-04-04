package com.ecommerce.entity;

import javax.persistence.*;

@Entity
@Table(name = "price_of_each_skus")
public class PriceEntity {
    @Id
    private Integer skuCode;
    private Integer price;

    @OneToOne(cascade = CascadeType.ALL)
    private SkuEntity skuEntity;

    public PriceEntity() {
    }

    public PriceEntity(Integer skuCode, Integer price) {
        this.skuCode = skuCode;
        this.price = price;
    }

    public Integer getSkuCode() {
        return skuCode;
    }

    public Integer getPrice() {
        return price;
    }

    public SkuEntity getSkuEntity() {
        return skuEntity;
    }

    public void setSkuEntity(SkuEntity skuEntity) {
        this.skuEntity = skuEntity;
    }
}
