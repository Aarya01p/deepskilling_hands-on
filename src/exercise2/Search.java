package exercise2;

public class Search {

    /**
     * Performs a linear search on the array of products by productId.
     * Time Complexity: O(n)
     */
    public static Product linearSearch(Product[] products, String targetId) {
        for (Product product : products) {
            if (product != null && product.getProductId().equals(targetId)) {
                return product;
            }
        }
        return null; // Not found
    }

    /**
     * Performs a binary search on a sorted array of products by productId.
     * Time Complexity: O(log n)
     * Note: The array must be sorted in ascending order of productId.
     */
    public static Product binarySearch(Product[] products, String targetId) {
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = products[mid].getProductId().compareTo(targetId);

            if (comparison == 0) {
                return products[mid]; // Found
            } else if (comparison < 0) {
                low = mid + 1; // Target is in the right half
            } else {
                high = mid - 1; // Target is in the left half
            }
        }
        return null; // Not found
    }
}
