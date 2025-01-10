import java.util.ArrayList;
import java.util.Scanner;

public class LibraryCatalog {
    static class Book {
        private String title;
        private String author;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        @Override
        public String toString() {
            return "Title: " + title + ", Author: " + author;
        }
    }

    private ArrayList<Book> catalog = new ArrayList<>();

    public void addBook(String title, String author) {
        catalog.add(new Book(title, author));
        System.out.println("Book added successfully.");
    }

    public void listBooks() {
        if (catalog.isEmpty()) {
            System.out.println("No books available.");
        } else {
            System.out.println("Library Catalog:");
            for (int i = 0; i < catalog.size(); i++) {
                System.out.println((i + 1) + ". " + catalog.get(i));
            }
        }
    }

    public void searchBook(String keyword) {
        boolean found = false;
        System.out.println("Search results:");
        for (Book book : catalog) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found for the keyword: " + keyword);
        }
    }

    public static void main(String[] args) {
        LibraryCatalog library = new LibraryCatalog();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nLibrary Catalog System");
            System.out.println("1. Add Book");
            System.out.println("2. List All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    library.addBook(title, author);
                    break;
                case 2:
                    library.listBooks();
                    break;
                case 3:
                    System.out.print("Enter title or author to search: ");
                    String keyword = scanner.nextLine();
                    library.searchBook(keyword);
                    break;
                case 4:
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}