package assignment_1;

import java.util.Objects;

public class Order {

    private final String productName;
    private final Double cost;

    public Order(String productName, Double cost) {
        this.productName = productName;
        this.cost = cost;
    }

    public Double getCost() {
        return cost;
    }
    public String getProductName(){
        return productName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(productName, order.productName) && Objects.equals(cost, order.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, cost);
    }

    @Override
    public String toString() {
        return "Order{" +
                "productName='" + productName + '\'' +
                ", cost=" + cost +
                '}';
    }
}
