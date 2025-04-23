package com.pluralsight;

public class Main {
    private static final Book[] inventory = new Book[20];

    private static final String HOME_SCREEN_PROMPT =
            """
                    
                    --- Warhammer Book Store ---
                    1. Show Available Books
                    2. Show Checked Out Books
                    3. Exit
                    Choose an option:""";

    public static void main(String[] args) {
        initializeInventory();
        homeScreen();
    }

    private static void initializeInventory() {
        inventory[0] = new Book(1, "9781849708240", "Horus Rising");
        inventory[1] = new Book(2, "9781849707434", "False Gods");
        inventory[2] = new Book(3, "9781849707441", "Galaxy in Flames");
        inventory[3] = new Book(4, "9781849707458", "The Flight of the Eisenstein");
        inventory[4] = new Book(5, "9781849707465", "Fulgrim");
        inventory[5] = new Book(6, "9781849707472", "Descent of Angels");
        inventory[6] = new Book(7, "9781849707489", "Legion");
        inventory[7] = new Book(8, "9781849707496", "Battle for the Abyss");
        inventory[8] = new Book(9, "9781849707502", "Mechanicum");
        inventory[9] = new Book(10, "9781849707519", "Tales of Heresy");
        inventory[10] = new Book(11, "9781849707526", "Fallen Angels");
        inventory[11] = new Book(12, "9781849707533", "A Thousand Sons");
        inventory[12] = new Book(13, "9781849707540", "Nemesis");
        inventory[13] = new Book(14, "9781849707557", "The First Heretic");
        inventory[14] = new Book(15, "9781849707564", "Prospero Burns");
        inventory[15] = new Book(16, "9781849707571", "Age of Darkness");
        inventory[16] = new Book(17, "9781849707588", "The Outcast Dead");
        inventory[17] = new Book(18, "9781849707595", "Deliverance Lost");
        inventory[18] = new Book(19, "9781849707601", "Know No Fear");
        inventory[19] = new Book(20, "9781849707618", "The Primarchs");
    }

    private static void homeScreen() {
        String choice;
        do {
            choice = Console.readLine(HOME_SCREEN_PROMPT);

            switch (choice) {
                case "1":
                    showAvailableBooks();
                    break;
                case "2":
                    showCheckedOutBooks();
                    break;
                case "3":
                    Console.println("Exiting... For the Emperor!");
                    break;
                default:
                    Console.println("Invalid option. Try again.");
            }
        } while (!choice.equals("3"));
    }

    private static void showAvailableBooks() {
        Console.println("\nAvailable Books:");
        for (Book book : inventory) {
            if (!book.getIsCheckedOut()) {
                Console.println(String.format("ID: %d | ISBN: %s | Title: %s",
                        book.getId(), book.getIsbn(), book.getTitle()));
            }
        }

        String input = Console.readLine("Enter Book ID to check out or 'X' to return: ");
        if (input.equalsIgnoreCase("X")) return;

        try {
            int bookId = Integer.parseInt(input);
            Book book = findBookById(bookId);
            if (book != null && !book.getIsCheckedOut()) {
                String name = Console.readLine("Enter your name: ");
                book.checkOut(name);
                Console.println("Book checked out successfully.");
            } else {
                Console.println("Book is not available or invalid ID.");
            }
        } catch (NumberFormatException e) {
            Console.println("Invalid input. Returning to main menu.");
        }
    }

    private static void showCheckedOutBooks() {
        Console.println("\nChecked Out Books:");
        for (Book book : inventory) {
            if (book.getIsCheckedOut()) {
                Console.println(String.format("ID: %d | ISBN: %s | Title: %s | Checked Out To: %s",
                        book.getId(), book.getIsbn(), book.getTitle(), book.getCheckedOutTo()));
            }
        }

        String input = Console.readLine("Enter 'C' to check in a book or 'X' to return: ");
        if (input.equalsIgnoreCase("X")) return;

        if (input.equalsIgnoreCase("C")) {
            try {
                int bookId = Console.readInt("Enter Book ID to check in: ");
                Book book = findBookById(bookId);
                if (book != null && book.getIsCheckedOut()) {
                    book.checkIn();
                    Console.println("Book checked in successfully.");
                } else {
                    Console.println("Invalid ID or book is not checked out.");
                }
            } catch (NumberFormatException e) {
                Console.println("Invalid input.");
            }
        }
    }

    private static Book findBookById(int id) {
        for (Book book : inventory) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
}