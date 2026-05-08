package week7.exercise2;

import java.util.Comparator;
import java.util.List;

public class ProductProcessing {
    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product("Laptop", "Electronics", 1200, 5),
                new Product("Mouse", "Electronics", 25, 50),
                new Product("Desk", "Furniture", 300, 0),
                new Product("Phone", "Electronics", 800, 12),
                new Product("Chair", "Furniture", 150, 7),
                new Product("Monitor", "Electronics", 400, 3),
                new Product("Notebook", "Stationery", 10, 100)
        );

        List<String> result = products
                .stream()
                .filter(product -> product.stockQuantity() > 0 && product.category().equals("Electronics") && product.price() > 300)
                .sorted(Comparator.comparing(Product::price))
                .map(product -> String.format("%s -> $%.1f", product.name(), product.price()))
                .toList();

        System.out.println("Result: " + result);
    }
}
