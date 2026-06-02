package week7.exercise5;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SalesReport {
    static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("Alice", 120.50, true),
                new Order("Bob", 75.00, false),
                new Order("Charlie", 210.30, true),
                new Order("David", 99.99, true),
                new Order("Emma", 180.00, false),
                new Order("Frank", 320.40, true)
        );

        double allOrders = orders.stream().mapToDouble(Order::amount).sum();
        double paidOrders = orders.stream().filter(Order::status).mapToDouble(Order::amount).sum();
        System.out.println("The total amount of:\n" +
                "All orders: " + allOrders +
                "\nOnly paid orders: " +  paidOrders);
        Optional<Order> highestOrderAmount = orders.stream().max(Comparator.comparing(Order::amount));
        System.out.print("Order with the highest amount: ");
        highestOrderAmount.ifPresent(System.out::println);
        String customerNames = orders.stream().map(Order::name).collect(Collectors.joining(", "));

        System.out.println("All customer names: " + customerNames);
    }
}
