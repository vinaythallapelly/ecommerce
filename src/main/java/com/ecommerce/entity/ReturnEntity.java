package com.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ReturnEntity {
    @Id
    private Integer orderCode;
    private String status;
    private int quantity;

    public ReturnEntity() {
    }

    public ReturnEntity(Integer orderCode, String status, int quantity) {
        this.orderCode = orderCode;
        this.status = status;
        this.quantity = quantity;
    }

    public Integer getOrderCode() {
        return orderCode;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
