package com.ecommerce.entity;

import javax.persistence.*;

@Entity
@Table(name = "inventory_table")
public class InventoryAddEntity {
    @Id
    private Integer skuCode;
    private int quantity;

    @OneToOne(cascade = CascadeType.ALL)
    private SkuEntity skuEntity;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "inventoryAddEntity")
    private OrderEntity orderEntity;

    public InventoryAddEntity(){}

    public InventoryAddEntity(Integer skuCode) {
        this.skuCode = skuCode;
    }

    public Integer getSkuCode() {
        return skuCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public SkuEntity getSkuEntity() {
        return skuEntity;
    }

    public void setSkuEntity(SkuEntity skuEntity) {
        this.skuEntity = skuEntity;
    }

    public void setSkuCode(Integer skuCode) {
        this.skuCode = skuCode;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }
}
