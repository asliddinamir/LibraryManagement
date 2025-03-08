package org.example.library;

import java.util.ArrayList;

public class Member {
    private final String name;
    private final String memberID;
    private final ArrayList<String> borrowedBooks;

    // Constructor
    public Member(String name, String memberID) {
        this.name = name;
        this.memberID = memberID;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getters
    public String getName() { return name; }
    public String getMemberID() { return memberID; }
    public ArrayList<String> getBorrowedBooks() { return borrowedBooks; }

    // Borrow Book
    public void borrowBook(String bookTitle) {
        borrowedBooks.add(bookTitle);
    }

    // Return Book
    public void returnBook(String bookTitle) {
        borrowedBooks.remove(bookTitle);
    }

    // Display member details
    public void displayMember() {
        System.out.println("Member Name: " + name + ", ID: " + memberID + ", Borrowed Books: " + borrowedBooks);
    }
}

