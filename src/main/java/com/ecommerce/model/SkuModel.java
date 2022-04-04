package com.ecommerce.model;

public class SkuModel {

    private Integer skuCode;
    private String size;
    private Integer price;

    public SkuModel() {
    }

    public SkuModel(Integer skuCode, String size, Integer price) {
        this.skuCode = skuCode;
        this.size = size;
        this.price = price;

    }

    public Integer getSkuCode() {
        return skuCode;
    }

    public String getSize() {
        return size;
    }

    public Integer getPrice() {
        return price;
    }
}
