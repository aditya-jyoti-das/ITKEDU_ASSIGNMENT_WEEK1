package assignment_1;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("Laptop", 1200.0),
                new Order("Smartphone", 800.0),
                new Order("Laptop", 1500.0),
                new Order("Tablet", 500.0),
                new Order("Smartphone", 900.0)
        );


        // GROUPING THE ORDER BY PRODUCT
        Map<String, List<Order>> collectGroupingByProductName = orders.stream().collect(Collectors.groupingBy(Order::getProductName));
        System.out.println(collectGroupingByProductName);

        // FOR EACH PRODUCT CALCULATE TOTAL COST OF ALL ORDERS
        Map<String, Double> collectGroupingByNameThenSumOfCost = orders.stream().collect(Collectors.groupingBy(Order::getProductName, Collectors.summingDouble(Order::getCost)));
        System.out.println(collectGroupingByNameThenSumOfCost);

        // SORT THE PRODUCT IN DESCENDING ORDER BY TOTAL COST
        List<Map.Entry<String, Double>> sortedByTotalCost = collectGroupingByNameThenSumOfCost.entrySet().stream().sorted(Map.Entry.<String, Double>comparingByValue().reversed()).toList();
        System.out.println(sortedByTotalCost);

        // SELECT THE THREE MOST EXPENSIVE PRODUCT
        List<Order> threeMostExpensiveProduct = orders.stream().sorted(Comparator.comparing(Order::getCost, Comparator.reverseOrder())).limit(3).toList();
        System.out.println(threeMostExpensiveProduct);

        // AND THEIR TOTAL COST
        double totalCost = threeMostExpensiveProduct.stream().mapToDouble(Order::getCost).sum();
        System.out.println("TOTAL COST OF TOP 3 EXPENSIVE PRODUCTS: "+totalCost);
    }
}
