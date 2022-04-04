package com.ecommerce.model;

public class OrderModel {
    private Integer orderCode;
    private String productName;
    private Integer skuCode;
    private String size;
    private int quantity;
    private Integer price;
    private String status;

    public OrderModel() {
    }

    public OrderModel(Integer orderCode, String productName, Integer skuCode, String size, int quantity, Integer price, String status) {
        this.orderCode = orderCode;
        this.productName = productName;
        this.skuCode = skuCode;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
    }

    public Integer getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(Integer orderCode) {
        this.orderCode = orderCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(Integer skuCode) {
        this.skuCode = skuCode;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
