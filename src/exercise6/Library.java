package exercise6;

public class Library {

    /**
     * Performs a linear search to find a book by its title.
     * Case-insensitive matching is used.
     * Time Complexity: O(n)
     */
    public static Book linearSearchByTitle(Book[] books, String title) {
        for (Book book : books) {
            if (book != null && book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null; // Not found
    }

    /**
     * Performs a binary search to find a book by its title.
     * Case-insensitive matching is used.
     * Time Complexity: O(log n)
     * Note: The books array MUST be sorted by title beforehand.
     */
    public static Book binarySearchByTitle(Book[] books, String title) {
        int low = 0;
        int high = books.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return books[mid]; // Found
            } else if (comparison < 0) {
                low = mid + 1; // Target is in the right half
            } else {
                high = mid - 1; // Target is in the left half
            }
        }
        return null; // Not found
    }
}
