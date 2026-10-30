package com.pluralsight;

public class Product{
    private String productId;
    private String productName;
    private double price;
    private String department;

    // Constructor
    public Product(String productId, String productName, double price , String department) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.department = department;
    }

    // Getters
    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }
    public String getDepartment() {
        return department;
    }

    // Setters
    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
}
