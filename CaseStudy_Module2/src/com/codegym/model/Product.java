package com.codegym.model;

public class Product {
    private String productId;
    private String productName;
    private double unitPrice;
    private int quantily;
    private String description;

    public Product() {
    }

    public Product(String productId, String productName, double unitPrice, int quantily, String description) {
        this.productId = productId;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantily = quantily;
        this.description = description;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantily() {
        return quantily;
    }

    public void setQuantily(int quantily) {
        this.quantily = quantily;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", unitPrice=" + unitPrice +
                ", quantily=" + quantily +
                ", description='" + description + '\'' +
                '}';
    }
}