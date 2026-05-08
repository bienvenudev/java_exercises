package week7.exercise2;

import java.util.Comparator;
import java.util.List;

public class ProductProcessing {
    public void main() {
        System.out.println("Original products: " + products);
        List<Product> sortedProducts = products.stream().filter(product -> product.stockQuantity() > 0 && product.category().equals("Electronics") && product.price() > 300).sorted(Comparator.comparing(Product::price)).toList();
        System.out.println("Premium sorted products: " + sortedProducts);
        List<String> result = new java.util.ArrayList<>(List.of());
        sortedProducts.forEach(product -> result.add(String.format("%s -> $%d", product.name(), product.price())));
        System.out.println(result);
    }

    List<Product> products = List.of(
            new Product("Laptop", "Electronics", 1200, 5),
            new Product("Mouse", "Electronics", 25, 50),
            new Product("Desk", "Furniture", 300, 0),
            new Product("Phone", "Electronics", 800, 12),
            new Product("Chair", "Furniture", 150, 7),
            new Product("Monitor", "Electronics", 400, 3),
            new Product("Notebook", "Stationery", 10, 100)
    );
}
