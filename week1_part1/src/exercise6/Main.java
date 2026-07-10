package exercise6;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Exercise 6: Library Management System ===");

        // Array of books
        Book[] books = {
            new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald"),
            new Book("B002", "To Kill a Mockingbird", "Harper Lee"),
            new Book("B003", "1984", "George Orwell"),
            new Book("B004", "Pride and Prejudice", "Jane Austen"),
            new Book("B005", "The Catcher in the Rye", "J.D. Salinger")
        };

        // 1. Linear Search Demo
        System.out.println("\n--- Linear Search Demo ---");
        String targetTitle1 = "1984";
        System.out.println("Searching for title: \"" + targetTitle1 + "\"");
        Book found1 = Library.linearSearchByTitle(books, targetTitle1);
        System.out.println("Result: " + found1);

        String targetTitle2 = "Moby Dick";
        System.out.println("Searching for non-existent title: \"" + targetTitle2 + "\"");
        Book found2 = Library.linearSearchByTitle(books, targetTitle2);
        System.out.println("Result: " + found2);

        // 2. Binary Search Demo
        System.out.println("\n--- Binary Search Demo ---");
        System.out.println("Sorting books by title for binary search...");
        Arrays.sort(books);

        System.out.println("Sorted books by title:");
        for (Book b : books) {
            System.out.println("  " + b);
        }

        System.out.println("\nSearching for title: \"" + targetTitle1 + "\"");
        Book found3 = Library.binarySearchByTitle(books, targetTitle1);
        System.out.println("Result: " + found3);

        System.out.println("Searching for non-existent title: \"" + targetTitle2 + "\"");
        Book found4 = Library.binarySearchByTitle(books, targetTitle2);
        System.out.println("Result: " + found4);
    }
}
