package com.priti.iitd.java8.scenarioBased.dto;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private String orderId;
    private List<Product> products;
    private double totalValue;
    private LocalDateTime orderTime;

    public Order() {
    }

    public Order(List<Product> products, double totalValue, LocalDateTime orderTime) {
        this.products = products;
        this.totalValue = totalValue;
        this.orderTime = orderTime;
    }

    public Order(String orderId, List<Product> products) {
        this.orderId = orderId;
        this.products = products;
    }


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }
}
