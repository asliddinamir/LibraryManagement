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
            System.out.println("1. View Books");
            System.out.println("2. Add Book");
            System.out.println("3. Search Book");
            System.out.println("4. View Members");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");
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
                case 1:
                    library.displayBooks();
                    break;
                case 2:
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
                    break;

                case 3:
                    System.out.print("Enter Book Title or Author: ");
                    String searchKeyword = scanner.nextLine();
                    library.searchBook(searchKeyword);
                    break;

                case 4:
                    System.out.print("Enter Book Title: ");
                    System.out.flush();
                    String returnBookTitle = scanner.nextLine();

                    System.out.print("Enter Member ID: ");
                    System.out.flush();
                    String returnMemberID = scanner.nextLine();

                    library.returnBook(returnBookTitle, returnMemberID);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }

    }
}
