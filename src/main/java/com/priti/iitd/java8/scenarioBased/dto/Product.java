package com.priti.iitd.java8.scenarioBased.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Product {
   private String productId;
    private String name;
    private String category;
    private int quantity;
    private boolean inStock;
    private double price;

    /*public Product(String productId) {
        this.productId = productId;
    }
*/
    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public Product(String name, String category, int quantity, boolean inStock) {
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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return quantity == product.quantity && inStock == product.inStock && Double.compare(price, product.price) == 0 && Objects.equals(productId, product.productId) && Objects.equals(name, product.name) && Objects.equals(category, product.category);
    }
   /* @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age && Objects.equals(name, person.name);
    }*/

    @Override
    public int hashCode() {
        return Objects.hash(productId, name, category, quantity, inStock, price);
    }


}
