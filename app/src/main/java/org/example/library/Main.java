package org.example.library;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();
        Scanner scanner = new Scanner(System.in);

        // Load books from file
        library.loadBooksFromFile();
        //Load members from file
        library.loadMembersFromFile();

        while (true) {
            // Main Menu: Ask if user is Admin or Member
            System.out.println("\nLibrary System");
            System.out.println("1. Admin");
            System.out.println("2. Member");
            System.out.println("3. Exit");
            System.out.print("Enter choice: (1 - 3 ): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); // Consume invalid input
                continue;
            }

            int userType = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (userType) {
                case 1 -> {
                    // Admin Menu
                    while (true) {
                        System.out.println("\nAdmin Menu");
                        System.out.println("1. View Books");
                        System.out.println("2. Add Book");
                        System.out.println("3. Search Book");
                        System.out.println("4. View Members");
                        System.out.println("5. Register Member");
                        System.out.println("6. Issue Book");
                        System.out.println("7. Return Book");
                        System.out.println("8. Save Members to File");
                        System.out.println("9. Load Members from File");
                        System.out.println("10. Save Books to File");
                        System.out.println("11. Load Books from File");
                        System.out.println("12. Exit to Main Menu");
                        System.out.print("Enter choice: (1 - 12 ): ");

                        if (!scanner.hasNextInt()) {
                            System.out.println("Invalid input! Please enter a number.");
                            scanner.nextLine(); // Consume invalid input
                            continue;
                        }

                        int adminChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        switch (adminChoice) {
                            case 1 ->
                                library.displayBooks();
                            case 2 -> {
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
                                System.out.print("Enter Book Title or Author: ");
                                String searchKeyword = scanner.nextLine();
                                library.searchBook(searchKeyword);
                            }
                            case 4 ->
                                library.displayMembers();
                            case 5 -> {
                                System.out.print("Enter Member Name: ");
                                String memberName = scanner.nextLine();

                                System.out.print("Enter Member ID: ");
                                String memberID = scanner.nextLine();

                                library.addMember(new Member(memberName, memberID));
                            }
                            case 6 -> {
                                System.out.print("Enter Book Title: ");
                                String issueBookTitle = scanner.nextLine();

                                System.out.print("Enter Member ID: ");
                                String issueMemberID = scanner.nextLine();

                                library.issueBook(issueBookTitle, issueMemberID);
                            }
                            case 7 -> {
                                System.out.print("Enter Book Title: ");
                                String returnBookTitle = scanner.nextLine();

                                System.out.print("Enter Member ID: ");
                                String returnMemberID = scanner.nextLine();

                                library.returnBook(returnBookTitle, returnMemberID);
                            }
                            case 8 ->
                                library.saveMembersToFile();
                            case 9 ->
                                library.loadMembersFromFile();
                            case 10 -> {
                                library.saveBooksToFile();
                            }
                            case 11 -> {
                                library.saveBooksToFile();
                            }

                            case 12 ->
                                System.out.println("Returning to Main Menu...");
                            // Exit Admin Menu
                            default ->
                                System.out.println("Invalid choice! Try again.");
                        }
                        if (adminChoice == 12) {
                            break; // Exit Admin Menu

                        }
                    }
                }

                case 2 -> {
                    // Member Menu
                    while (true) {
                        System.out.println("\nMember Menu");
                        System.out.println("1. View Books");
                        System.out.println("2. Search Book");
                        System.out.println("3. Exit to Main Menu");
                        System.out.print("Enter choice (1 - 3): ");

                        if (!scanner.hasNextInt()) {
                            System.out.println("Invalid input! Please enter a number.");
                            scanner.nextLine(); // Consume invalid input
                            continue;
                        }

                        int memberChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        switch (memberChoice) {
                            case 1 ->
                                library.displayBooks();
                            case 2 -> {
                                System.out.print("Enter Book Title or Author: ");
                                String searchKeyword = scanner.nextLine();
                                library.searchBook(searchKeyword);
                            }
                            case 3 ->
                                System.out.println("Returning to Main Menu...");
                            // Exit Member Menu
                            default ->
                                System.out.println("Invalid choice! Try again.");
                        }
                        if (memberChoice == 3) {
                            break; // Exit Member Menu

                        }
                    }
                }

                case 3 -> {
                    // Exit Program
                    System.out.println("Exiting the Library System...");
                    scanner.close();
                    System.exit(0);
                }

                default ->
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
