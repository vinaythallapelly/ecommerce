package com.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DeliveryEntity {
    @Id
    private Integer orderCode;
    private String status;

    public DeliveryEntity() {
    }

    public DeliveryEntity(Integer orderCode, String status) {
        this.orderCode = orderCode;
        this.status = status;
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
}
