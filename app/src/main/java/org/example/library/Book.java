package org.example.library;

public class Book {
    private final String title;
    private final String author;
    private final String ISBN;
    private int quantity;

    // Constructor
    public Book(String title, String author, String ISBN, int quantity) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.quantity = quantity;
    }

    // Getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getISBN() { return ISBN; }
    public int getQuantity() { return quantity; }

    // Issue Book (Reduce Quantity)
    public boolean issueBook() {
        if (quantity > 0) {
            quantity--;
            return true;
        } else {
            System.out.println("Book is out of stock!");
            return false;
        }
    }

    // Return Book (Increase Quantity)
    public void returnBook() {
        quantity++;
    }

    // Display book details
    public void displayBook() {
        System.out.println("Title: " + title + ", Author: " + author + ", ISBN: " + ISBN + ", Quantity: " + quantity);
    }
}

