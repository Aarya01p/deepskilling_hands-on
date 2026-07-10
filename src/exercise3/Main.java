package exercise3;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Exercise 3: Sorting Customer Orders ===");

        // Sample orders
        Order[] bubbleSortOrders = {
            new Order("O001", "Alice", 250.50),
            new Order("O002", "Bob", 120.00),
            new Order("O003", "Charlie", 450.00),
            new Order("O004", "David", 89.99),
            new Order("O005", "Emma", 310.20)
        };

        Order[] quickSortOrders = bubbleSortOrders.clone();

        // 1. Bubble Sort demo
        System.out.println("\n--- Bubble Sort Demo ---");
        System.out.println("Original orders:");
        printOrders(bubbleSortOrders);

        System.out.println("Sorting orders using Bubble Sort...");
        Sorting.bubbleSort(bubbleSortOrders);
        System.out.println("Sorted orders:");
        printOrders(bubbleSortOrders);

        // 2. Quick Sort demo
        System.out.println("\n--- Quick Sort Demo ---");
        System.out.println("Original orders:");
        printOrders(quickSortOrders);

        System.out.println("Sorting orders using Quick Sort...");
        Sorting.quickSort(quickSortOrders, 0, quickSortOrders.length - 1);
        System.out.println("Sorted orders:");
        printOrders(quickSortOrders);
    }

    private static void printOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println("  " + order);
        }
    }
}
