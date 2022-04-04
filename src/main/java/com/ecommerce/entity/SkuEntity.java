package com.ecommerce.entity;

import javax.persistence.*;

@Entity
@Table(name = "skus_size")
public class SkuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer skuCode;
    private String size;

    @ManyToOne(cascade = CascadeType.ALL)
    private ProductEntity productEntity;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "skuEntity")
    private PriceEntity priceEntity;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "skuEntity")
    private InventoryAddEntity inventoryAddEntity;

    @OneToOne(mappedBy = "skuEntity")
    private CartEntity cartEntity;


    public SkuEntity() {
    }

    public SkuEntity( Integer skuCode,String size) {
        this.skuCode = skuCode;
        this.size = size;
    }

    public Integer getSkuCode() {
        return skuCode;
    }

    public String getSize() {
        return size;
    }

    public ProductEntity getProductsEntity() {
        return productEntity;
    }

    public PriceEntity getPriceEntity() {
        return priceEntity;
    }

    public void setProductsEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public CartEntity getCartEntity() {
        return cartEntity;
    }

    public void setCartEntity(CartEntity cartEntity) {
        this.cartEntity = cartEntity;
    }
}
