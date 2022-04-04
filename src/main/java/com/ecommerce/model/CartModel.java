package com.ecommerce.model;

public class CartModel {
    private Integer cartCode;
    private Integer productCode;
    private Integer skuCode;
    private String name;
    private String description;
    private String size;
    private Integer price;
    private Integer quantity;
    private Double totalPrice;

    public CartModel() {
    }

    public CartModel(Integer cartCode, Integer productCode, Integer skuCode, String name, String description, String size, Integer price, Integer quantity) {
        this.cartCode = cartCode;
        this.productCode = productCode;
        this.skuCode = skuCode;
        this.name = name;
        this.description = description;
        this.size = size;
        this.price = price;
        this.quantity = quantity;
    }

    public Integer getCartCode() {
        return cartCode;
    }

    public void setCartCode(Integer cartCode) {
        this.cartCode = cartCode;
    }

    public Integer getProductCode() {
        return productCode;
    }

    public void setProductCode(Integer productCode) {
        this.productCode = productCode;
    }

    public Integer getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(Integer skuCode) {
        this.skuCode = skuCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
