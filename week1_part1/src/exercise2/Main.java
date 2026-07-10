package exercise2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Exercise 2: E-commerce Platform Search ===");

        // Create an array of products
        Product[] products = {
            new Product("P005", "Keyboard", "Accessories"),
            new Product("P001", "Laptop", "Electronics"),
            new Product("P003", "Mouse", "Accessories"),
            new Product("P002", "Smartphone", "Electronics"),
            new Product("P004", "Monitor", "Electronics")
        };

        // 1. Linear Search (does not require sorting)
        System.out.println("\n--- Linear Search Demo ---");
        String target1 = "P003";
        System.out.println("Searching for ID: " + target1);
        Product result1 = Search.linearSearch(products, target1);
        System.out.println("Found: " + result1);

        String target2 = "P999";
        System.out.println("Searching for non-existent ID: " + target2);
        Product result2 = Search.linearSearch(products, target2);
        System.out.println("Found: " + result2);

        // 2. Binary Search (requires sorting by productId)
        System.out.println("\n--- Binary Search Demo ---");
        System.out.println("Sorting products by ID for binary search...");
        Arrays.sort(products);
        
        System.out.println("Sorted products:");
        for (Product p : products) {
            System.out.println("  " + p);
        }

        System.out.println("\nSearching for ID: " + target1);
        Product result3 = Search.binarySearch(products, target1);
        System.out.println("Found: " + result3);

        System.out.println("Searching for non-existent ID: " + target2);
        Product result4 = Search.binarySearch(products, target2);
        System.out.println("Found: " + result4);
    }
}
