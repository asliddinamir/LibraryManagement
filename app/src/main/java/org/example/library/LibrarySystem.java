package org.example.library;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LibrarySystem {

    private final ArrayList<Book> books;
    private final ArrayList<Member> members;

    // Constructor
    public LibrarySystem() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    // Load books from file
    public void loadMembersFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("members.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    members.add(new Member(parts[0], parts[1]));
                }
            }
            System.out.println("Member data loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading member data: " + e.getMessage());
        }
    }

    // Load books from file
    public void saveMembersToFile() {
        try (FileWriter writer = new FileWriter("members.txt")) {
            for (Member member : members) {
                writer.write(member.getName() + "," + member.getMemberID() + "\n");
            }
            System.out.println("Member data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving member data: " + e.getMessage());
        }
    }

    // Add a new book
    public void addBook(Book book) {
        for (Book b : books) {
            if (b.getISBN().equals(book.getISBN())) {
                System.out.println("A book with this ISBN already exists!");
                return;
            }
        }
        books.add(book);
        System.out.println("Book added successfully.");
    }

    // Add a new member
    public void addMember(Member member) {
        for (Member m : members) {
            if (m.getMemberID().equals(member.getMemberID())) {
                System.out.println("A member with this ID already exists!");
                return;
            }
        }
        members.add(member);
        System.out.println("Member added successfully.");
    }

    // Display all books
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book book : books) {
                book.displayBook();
            }
        }
    }

    // Display all members
    public void displayMembers() {
        if (members.isEmpty()) {
            System.out.println("No members registered.");
        } else {
            for (Member member : members) {
                member.displayMember();
            }
        }
    }

    // Find a book by title
    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Find a member by ID
    public Member findMemberByID(String memberID) {
        for (Member member : members) {
            if (member.getMemberID().equals(memberID)) {
                return member;
            }
        }
        return null;
    }

    // Issue a book to a member
    public void issueBook(String bookTitle, String memberID) {
        Book book = findBookByTitle(bookTitle);
        Member member = findMemberByID(memberID);

        if (book != null && member != null) {
            if (book.issueBook()) {  // Reduce book quantity
                member.borrowBook(bookTitle);
                System.out.println("Book issued successfully to " + member.getName());
            }
        } else {
            System.out.println("Book or Member not found.");
        }
    }

    // Return a book
    public void returnBook(String bookTitle, String memberID) {
        Book book = findBookByTitle(bookTitle);
        Member member = findMemberByID(memberID);

        if (book != null && member != null) {
            if (member.getBorrowedBooks().contains(bookTitle)) {
                book.returnBook();  // Increase book quantity
                member.returnBook(bookTitle);
                System.out.println("Book returned successfully.");
            } else {
                System.out.println("Member did not borrow this book.");
            }
        } else {
            System.out.println("Book or Member not found.");
        }
    }

    // Search for a book by title or author
    public void searchBook(String keyword) {
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(keyword) || book.getAuthor().equalsIgnoreCase(keyword)) {
                book.displayBook();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found with the given title or author.");
        }
    }

}
