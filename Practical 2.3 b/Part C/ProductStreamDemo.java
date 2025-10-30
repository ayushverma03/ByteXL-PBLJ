import java.util.*;
import java.util.stream.Collectors;

public class ProductStreamDemo {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", 1000, "Electronics"),
                new Product("Smartphone", 800, "Electronics"),
                new Product("Jeans", 50, "Clothing"),
                new Product("T-shirt", 20, "Clothing"),
                new Product("Coffee Maker", 120, "Appliances")
        );

        // Group by category
        Map<String, List<Product>> productsByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
        System.out.println("Products grouped by category:");
        productsByCategory.forEach((category, list) -> System.out.println(category + ": " + list));

        // Most expensive product in each category
        Map<String, Optional<Product>> maxProductByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))));
        System.out.println("\nMost expensive product in each category:");
        maxProductByCategory.forEach((category, product) -> System.out.println(category + ": " + product.get()));

        // Average price of all products
        double averagePrice = products.stream()
                .collect(Collectors.averagingDouble(Product::getPrice));
        System.out.println("\nAverage price of all products: $" + averagePrice);
    }
}
