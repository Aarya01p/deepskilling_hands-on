package exercise1;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Product> products;

    public Inventory() {
        this.products = new HashMap<>();
    }

    // Add a product
    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        if (products.containsKey(product.getProductId())) {
            System.out.println("Product with ID " + product.getProductId() + " already exists. Use update instead.");
            return;
        }
        products.put(product.getProductId(), product);
        System.out.println("Product added: " + product.getProductName());
    }

    // Update a product
    public void updateProduct(String productId, int newQuantity, double newPrice) {
        Product product = products.get(productId);
        if (product != null) {
            product.setQuantity(newQuantity);
            product.setPrice(newPrice);
            System.out.println("Product updated: " + product.getProductName());
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }

    // Delete a product
    public void deleteProduct(String productId) {
        Product removed = products.remove(productId);
        if (removed != null) {
            System.out.println("Product deleted: " + removed.getProductName());
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }

    // Get a product
    public Product getProduct(String productId) {
        return products.get(productId);
    }

    // Traverse and display all products
    public void displayInventory() {
        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        System.out.println("--- Current Inventory ---");
        for (Product product : products.values()) {
            System.out.println(product);
        }
        System.out.println("-------------------------");
    }
}
