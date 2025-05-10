package com.priti.iitd.java8.scenarioBased.dto;

import java.time.LocalDateTime;
import java.util.List;

public class Product {
   private String productId;
    private String name;
    private String category;
    private int quantity;
    private boolean inStock;
    private double price;

    public Product( String name, String category, int quantity, boolean inStock) {
       // this.productId = productId;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.inStock = inStock;
     //   this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
