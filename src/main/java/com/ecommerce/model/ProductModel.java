package com.ecommerce.model;

import java.util.List;

public class ProductModel {
    private String productName;
    private String description;
    private List<SkuModel> skuModel;

    public ProductModel() {
    }

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }

    public List<SkuModel> getSkuModel() {
        return skuModel;
    }
}
