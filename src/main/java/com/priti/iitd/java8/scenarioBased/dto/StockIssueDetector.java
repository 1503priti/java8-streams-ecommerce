package com.priti.iitd.java8.scenarioBased.dto;

import java.util.*;
import java.util.stream.Collectors;



public class StockIssueDetector {
    public static void main(String[] args) {
        //Sample product stock levels (productId -> available stock)
        Map<String, Integer> productStock = new HashMap<>();
        productStock.put("P001",100); //Product P001 has 100 items in Stock
        productStock.put("P002",50); //Product P002 has 50 items in Stock
        productStock.put("P003",200); //Product P003 has 200 items in Stock
        // Sample Orders
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("0001", Arrays.asList(new Product("P001",30), new Product("P002",60))));
        orders.add(new Order("0002", Arrays.asList(new Product("P003",50), new Product("P002",40))));
        orders.add(new Order("0003", Arrays.asList(new Product("P001",120), new Product("P002",30))));

    List<String> problematicOrders = orders.stream()
                    .filter(order-> order.getProducts().stream()
                            .anyMatch(product -> {
                                int availableStock =  productStock.get(product.getProductId());
                                return availableStock <= product.getQuantity();
                            }))
                    .map(Order::getOrderId)
                    .collect(Collectors.toList());

        System.out.println(problematicOrders);
    }
}
