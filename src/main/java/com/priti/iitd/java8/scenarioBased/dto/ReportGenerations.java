package com.priti.iitd.java8.scenarioBased.dto;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class ReportGenerations {
    public static void main(String[] args) {
        List<Order>  orders
         = Arrays.asList(
                new Order(Arrays.asList(
                        new Product("iPhone", "Electronics", 2, true),
                        new Product("USB Cable", "Electronics", 5, true),
                        new Product("Headphones", "Electronics", 1, false)// out of stock
                ), 1500, LocalDateTime.now().minusHours(3)), //included
                new Order(Arrays.asList(
                        new Product("T-Shirt", "Clothing", 3, true),
                        new Product("Jeans", "Clothing", 2, true)
                ),600, LocalDateTime.now().minusHours(5)), //included
                new Order(Arrays.asList(
                                new Product("Sandals", "Footwear", 1, true),
                                new Product("Sneakers", "Footwear", 1, false) // out of stock
                ),400, LocalDateTime.now().minusHours(2)), //excluded(value=<500)

                new Order(Arrays.asList(
                        new Product("Cookware Set", "Home & Kitchen", 1, true),
                        new Product("Knife", "Home & Kitchen", 2, true)
                ),1000, LocalDateTime.now().minusHours(26)), //excluded(too old)

                new Order(Arrays.asList(
                        new Product("iPhone", "Electronics", 1, true),
                        new Product("T-Shirt", "Clothing", 1, false)// out of stock
                ),700, LocalDateTime.now().minusHours(1)) //included
        );

      Map<String, Integer> mapOfCategoryAndQuantity =
              orders.stream()
                      .filter(order-> order.getOrderTime().isAfter(LocalDateTime.now().minusHours(24)))
                      .filter(order -> order.getTotalValue() >500)
                      .flatMap(order -> order.getProducts().stream())
                      .filter(Product::isInStock)
                      .collect(Collectors.groupingBy(Product::getCategory,
                              Collectors.summingInt(Product::getQuantity)
                      ))
                      .entrySet().stream()
                      .sorted(Map.Entry.<String,Integer>comparingByValue(Comparator.reverseOrder()))
                      .collect(Collectors.toMap(
                              Map.Entry::getKey,
                              Map.Entry::getValue,
                              (e1,e2)->e1,
                              LinkedHashMap::new
                      ));
        System.out.println(mapOfCategoryAndQuantity);

}
}