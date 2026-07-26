package exercise1;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Exercise 1: Inventory Management System ===");
        
        Inventory inventory = new Inventory();

        // 1. Add products
        Product p1 = new Product("P001", "Laptop", 10, 999.99);
        Product p2 = new Product("P002", "Smartphone", 25, 499.99);
        Product p3 = new Product("P003", "Headphones", 50, 79.99);

        System.out.println("\nAdding products:");
        inventory.addProduct(p1);
        inventory.addProduct(p2);
        inventory.addProduct(p3);

        // Display current inventory
        inventory.displayInventory();

        // 2. Update product
        System.out.println("\nUpdating Laptop quantity to 15 and price to $949.99:");
        inventory.updateProduct("P001", 15, 949.99);
        
        // Display after update
        inventory.displayInventory();

        // 3. Delete product
        System.out.println("\nDeleting Smartphone (P002):");
        inventory.deleteProduct("P002");

        // Display after deletion
        inventory.displayInventory();
        
        // Try deleting non-existent product
        System.out.println("\nDeleting non-existent product (P999):");
        inventory.deleteProduct("P999");
    }
}
