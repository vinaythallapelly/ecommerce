package com.ecommerce.entity;

import javax.persistence.*;

@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderCode;
    private String status;
    private int quantity;

    @OneToOne(cascade = CascadeType.DETACH)
    private InventoryAddEntity inventoryAddEntity;


    public OrderEntity() {
    }

    public OrderEntity( String status, int quantity) {
        this.status = status;
        this.quantity=quantity;
    }

    public InventoryAddEntity getInventoryAddEntity() {
        return inventoryAddEntity;
    }

    public void setInventoryAddEntity(InventoryAddEntity inventoryAddEntity) {
        this.inventoryAddEntity = inventoryAddEntity;
    }

    public Integer getOrderCode() {
        return orderCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setOrderCode(Integer orderCode) {
        this.orderCode = orderCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
