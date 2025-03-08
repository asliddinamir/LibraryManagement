package org.example.library;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();
        Scanner scanner = new Scanner(System.in);

        // Add sample books
        library.addBook(new Book("Java Programming", "James Gosling", "123456", 3));
        library.addBook(new Book("Python Basics", "Guido van Rossum", "789101", 5));

        // Add sample members
        library.addMember(new Member("Alice", "M001"));
        library.addMember(new Member("Bob", "M002"));

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. View Books");
            System.out.println("2. Add Book");
            System.out.println("3. Search Book");
            System.out.println("4. View Members");
            System.out.println("5. Register Member");
            System.out.println("6. Issue Book");
            System.out.println("7. Return Book");
            System.out.println("8. Save Members to File");
            System.out.println("9. Load Members from File");
            System.out.println("10. Exit");
            System.out.print("Enter choice: ");

            System.out.flush(); // Flush output buffer

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); // Consume invalid input
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> // View Books
                    library.displayBooks();

                case 2 -> {
                    // Add Book
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();

                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();

                    System.out.print("Enter Quantity: ");
                    int quantity;
                    while (true) {
                        if (scanner.hasNextInt()) {
                            quantity = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            break;
                        } else {
                            System.out.println("Invalid input! Please enter a number.");
                            scanner.next(); // Consume invalid input
                        }
                    }

                    library.addBook(new Book(title, author, isbn, quantity));
                }

                case 3 -> {
                    // Search Book
                    System.out.print("Enter Book Title or Author: ");
                    String searchKeyword = scanner.nextLine();
                    library.searchBook(searchKeyword);
                }

                case 4 -> // View Members
                    library.displayMembers();

                case 5 -> {
                    // Register Member
                    System.out.print("Enter Member Name: ");
                    String memberName = scanner.nextLine();

                    System.out.print("Enter Member ID: ");
                    String memberID = scanner.nextLine();

                    library.addMember(new Member(memberName, memberID));
                }

                case 6 -> {
                    // Issue Book
                    System.out.print("Enter Book Title: ");
                    String issueBookTitle = scanner.nextLine();

                    System.out.print("Enter Member ID: ");
                    String issueMemberID = scanner.nextLine();

                    library.issueBook(issueBookTitle, issueMemberID);

                }

                case 7 -> {
                    // Return Book
                    System.out.print("Enter Book Title: ");
                    String returnBookTitle = scanner.nextLine();

                    System.out.print("Enter Member ID: ");
                    String returnMemberID = scanner.nextLine();

                    library.returnBook(returnBookTitle, returnMemberID);
                }

                case 8 -> // Save Members to File
                    library.saveMembersToFile();

                case 9 -> // Load Members from File
                    library.loadMembersFromFile();

                case 10 -> {
                    // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                }

                default ->
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
