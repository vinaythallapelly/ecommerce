package com.ecommerce.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cart_table")
public class CartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cartCode;
    @NotNull
    private int quantity;

    @OneToOne
    private SkuEntity skuEntity;


    public CartEntity() {
    }

    public CartEntity(int quantity) {
        this.quantity = quantity;
    }

    public SkuEntity getSkuEntity() {
        return skuEntity;
    }

    public void setSkuEntity(SkuEntity skuEntity) {
        this.skuEntity = skuEntity;
    }

    public Integer getCartCode() {
        return cartCode;
    }

    public void setCartCode(Integer cartCode) {
        this.cartCode = cartCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
