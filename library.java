import java.util.Scanner;

class User {
    private boolean loggedIn;

    public User() {
        this.loggedIn = false;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void login() {
        loggedIn = true;
        System.out.println("Login successful.");
    }

    public void logout() {
        loggedIn = false;
        System.out.println("Logout successful.");
    }
}

class Book {
    private String title;
    private String author;
    private boolean available;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String message) {
        super(message);
    }
}

class Staff extends User {
    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            book.setAvailable(false);
            System.out.println("Book " + book.getTitle() + " borrowed successfully.");
        } else {
            System.out.println("Book " + book.getTitle() + " is not available.");
        }
    }

    public void returnBook(Book book) {
        book.setAvailable(true);
        System.out.println("Book " + book.getTitle() + " returned successfully.");
    }

    public void addBook(Scanner scanner, Book[] books, int numBooks) {
        if (numBooks < books.length) {
            System.out.println("Enter book title:");
            String title = scanner.nextLine();

            System.out.println("Enter book author:");
            String author = scanner.nextLine();

            Book newBook = new Book(title, author);
            books[numBooks++] = newBook;
            System.out.println("Book " + newBook.getTitle() + " added successfully.");
        } else {
            System.out.println("Maximum number of books reached.");
        }
    }

    public void borrowBookWithInput(Scanner scanner, Book book) {
        System.out.println("Borrowing book: " + book.getTitle());
        borrowBook(book);
    }

    public void returnBookWithInput(Scanner scanner, Book book) {
        System.out.println("Returning book: " + book.getTitle());
        returnBook(book);
    }

}

class Student extends User {
    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            book.setAvailable(false);
            System.out.println("Book " + book.getTitle() + " borrowed successfully.");
        } else {
            System.out.println("Book " + book.getTitle() + " is not available.");
        }
    }

    public void returnBook(Book book) {
        book.setAvailable(true);
        System.out.println("Book " + book.getTitle() + " returned successfully.");
    }

    public void borrowBookWithInput(Scanner scanner, Book book) {
        System.out.println("Borrowing book: " + book.getTitle());
        borrowBook(book);
    }

    public void returnBookWithInput(Scanner scanner, Book book) {
        System.out.println("Returning book: " + book.getTitle());
        returnBook(book);
    }
}

class Librarian extends User {
    public void addBook(Scanner scanner, Book[] books, int numBooks) {
        if (numBooks < books.length) {
            System.out.println("Enter book title:");
            String title = scanner.nextLine();

            System.out.println("Enter book author:");
            String author = scanner.nextLine();

            Book newBook = new Book(title, author);
            books[numBooks++] = newBook;
            System.out.println("Book " + newBook.getTitle() + " added successfully.");
        } else {
            System.out.println("Maximum number of books reached.");
        }
    }

    public void issueBook(Scanner scanner, Book[] books, int numBooks, Student student) {
        System.out.println("Enter book title:");
        String title = scanner.nextLine();
        System.out.println("Enter book author:");
        String author = scanner.nextLine();

        Book bookToIssue = findBookByTitleAndAuthor(books, numBooks, title, author);
        if (bookToIssue != null) {
            if (bookToIssue.isAvailable()) {
                bookToIssue.setAvailable(false);
                System.out.println("Book " + bookToIssue.getTitle() + " issued to student");
            } else {
                System.out.println("Book " + bookToIssue.getTitle() + " is not available.");
            }
        } else {
            throw new BookNotFoundException("Book not found.");
        }
    }

    private Book findBookByTitleAndAuthor(Book[] books, int numBooks, String title, String author) {
        for (int i = 0; i < numBooks; i++) {
            if (books[i].getTitle().equals(title) && books[i].getAuthor().equals(author)) {
                return books[i];
            }
        }
        return null;
    }

    public void checkAvailability(Scanner scanner, Book[] books, int numBooks) {
        System.out.println("Enter book title:");
        String title = scanner.nextLine();
        System.out.println("Enter book author:");
        String author = scanner.nextLine();

        Book bookToCheck = findBookByTitleAndAuthor(books, numBooks, title, author);
        if (bookToCheck != null) {
            if (bookToCheck.isAvailable()) {
                System.out.println("Book " + bookToCheck.getTitle() + " is available.");
            } else {
                System.out.println("Book " + bookToCheck.getTitle() + " is not available.");
            }
        } else {
            throw new BookNotFoundException("Book not found.");
        }
    }

    public void renewBook(Scanner scanner, Book[] books, int numBooks) {
        System.out.println("Enter book title:");
        String title = scanner.nextLine();
        System.out.println("Enter book author:");
        String author = scanner.nextLine();

        Book bookToRenew = findBookByTitleAndAuthor(books, numBooks, title, author);
        if (bookToRenew != null) {
            if (!bookToRenew.isAvailable()) {
                bookToRenew.setAvailable(true);
                System.out.println("Book " + bookToRenew.getTitle() + " renewed successfully.");
            } else {
                System.out.println("Book " + bookToRenew.getTitle() + " is already available.");
            }
        } else {
            throw new BookNotFoundException("Book not found.");
        }
    }
}

class LibraryManagementSystem {
    private static final int MAX_BOOKS = 100; // Maximum number of books
    private static Book[] books = new Book[MAX_BOOKS];
    private static int numBooks = 0; // Number of books currently stored

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize users
        Student student = new Student();
        Staff staff = new Staff();
        Librarian librarian = new Librarian();

        while (true) {
            System.out.println("Select user type:");
            System.out.println("1. Librarian");
            System.out.println("2. Student");
            System.out.println("3. Staff");
            System.out.println("4. Exit");

            int userType = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (userType) {
                case 1:
                    System.out.println("Enter username:");
                    String usernameLibrarian = scanner.nextLine();
                    System.out.println("Enter password:");
                    String passwordLibrarian = scanner.nextLine();
                    // Check if username and password are correct
                    if (usernameLibrarian.equals("librarian") && passwordLibrarian.equals("librarian123")) {
                        librarian.login();
                        System.out.println("1. Add Book");
                        System.out.println("2. Issue Book");
                        System.out.println("3. Check Availability");
                        System.out.println("4. Renew Book");

                        int librarianOption = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        switch (librarianOption) {
                            case 1:
                                librarian.addBook(scanner, books, numBooks);
                                numBooks++;
                                break;
                            case 2:
                                librarian.issueBook(scanner, books, numBooks, student);
                                break;
                            case 3:
                                librarian.checkAvailability(scanner, books, numBooks);
                                break;
                            case 4:
                                librarian.renewBook(scanner, books, numBooks);
                                break;
                            default:
                                System.out.println("Invalid option. Please try again.");
                        }
                        librarian.logout();
                    } else {
                        System.out.println("Invalid username or password.");
                    }
                    break;
                case 2:
                    System.out.println("Enter username:");
                    String usernameStudent = scanner.nextLine();
                    System.out.println("Enter password:");
                    String passwordStudent = scanner.nextLine();
                    // Check if username and password are correct
                    if (usernameStudent.equals("student") && passwordStudent.equals("student123")) {
                        student.login();
                        System.out.println("1. Borrow Book");
                        System.out.println("2. Return Book");

                        int studentOption = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        switch (studentOption) {
                            case 1:
                                System.out.println("Enter book title:");
                                String titleBorrow = scanner.nextLine();
                                System.out.println("Enter book author:");
                                String authorBorrow = scanner.nextLine();
                                student.borrowBook(new Book(titleBorrow, authorBorrow));
                                break;
                            case 2:
                                System.out.println("Enter book title:");
                                String titleReturn = scanner.nextLine();
                                System.out.println("Enter book author:");
                                String authorReturn = scanner.nextLine();
                                student.returnBook(new Book(titleReturn, authorReturn));
                                break;
                            default:
                                System.out.println("Invalid option. Please try again.");
                        }
                        student.logout();
                    } else {
                        System.out.println("Invalid username or password.");
                    }
                    break;
                case 3:
                    System.out.println("Enter username:");
                    String usernameStaff = scanner.nextLine();
                    System.out.println("Enter password:");
                    String passwordStaff = scanner.nextLine();
                    // Check if username and password are correct
                    if (usernameStaff.equals("staff") && passwordStaff.equals("staff123")) {
                        staff.login();
                        System.out.println("1. Borrow Book");
                        System.out.println("2. Return Book");

                        int staffOption = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        switch (staffOption) {
                            case 1:
                                System.out.println("Enter book title:");
                                String titleBorrow = scanner.nextLine();
                                System.out.println("Enter book author:");
                                String authorBorrow = scanner.nextLine();
                                staff.borrowBook(new Book(titleBorrow, authorBorrow));
                                break;
                            case 2:
                                System.out.println("Enter book title:");
                                String titleReturn = scanner.nextLine();
                                System.out.println("Enter book author:");
                                String authorReturn = scanner.nextLine();
                                staff.returnBook(new Book(titleReturn, authorReturn));
                                break;
                            default:
                                System.out.println("Invalid option. Please try again.");
                        }
                        staff.logout();
                    } else {
                        System.out.println("Invalid username or password.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

