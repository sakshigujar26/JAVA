import java.util.ArrayList;
import java.util.List;

class Book {
    String title;
    String author;
    boolean isCheckedOut;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isCheckedOut = false;
    }
}

class Student {
    int studentId;
    String name;
    List<Book> checkedOutBooks;

    Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.checkedOutBooks = new ArrayList<>();
    }
}

class LibraryUser {
    String name;
    int id;
    boolean isStudent;
    boolean isBookAvailable;

    LibraryUser(String name, int id, boolean isStudent) {
        this.name = name;
        this.id = id;
        this.isStudent = isStudent;
        this.isBookAvailable = true; // Assuming the user starts with no books checked out
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public boolean isBookAvailable() {
        return isBookAvailable;
    }

    public void setBookAvailable(boolean bookAvailable) {
        isBookAvailable = bookAvailable;
    }
}

class Library {
    List<Book> books;
    List<Student> students;
    List<LibraryUser> users;

    Library() {
        this.books = new ArrayList<>();
        this.students = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    void addStudent(Student student) {
        students.add(student);
    }

    void addUser(LibraryUser user) {
        users.add(user);
    }

    boolean checkOutBook(Book book, LibraryUser user, String dueDate) {
        if (book.isCheckedOut || !user.isBookAvailable()) {
            return false; // Book already checked out or user has a book already
        }
        book.isCheckedOut = true;
        user.setBookAvailable(false);
        return true;
    }

    boolean returnBook(Book book, LibraryUser user) {
        if (!book.isCheckedOut || user.isBookAvailable()) {
            return false; // Book not checked out or user has no book to return
        }
        book.isCheckedOut = false;
        user.setBookAvailable(true);
        return true;
    }

    Book findBook(String title, String author) {
        for (Book book : books) {
            if (book.title.equals(title) && book.author.equals(author)) {
                return book;
            }
        }
        return null;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        System.out.println("Welcome to the Library Management System!");

        // Adding students
        Student student1 = new Student(1, "Ramesh");
        Student student2 = new Student(2, "Suresh");
        library.addStudent(student1);
        library.addStudent(student2);

        // Adding staff
        LibraryUser staff1 = new LibraryUser("John", 201, false);
        LibraryUser staff2 = new LibraryUser("Smith", 202, false);
        library.addUser(staff1);
        library.addUser(staff2);

        // Adding library staff
        LibraryUser libraryStaff1 = new LibraryUser("Brown", 301, false);
        LibraryUser libraryStaff2 = new LibraryUser("Johnson", 302, false);
        library.addUser(libraryStaff1);
        library.addUser(libraryStaff2);

        // Book checkout
        Book book1 = new Book("The Great  maths", " Fitzgerald");
        Book book2 = new Book("Engineering Graphics", "Jane Austen");

        if (library.checkOutBook(book1, student1, "2024-03-05")) {
            System.out.println("Book checked out successfully by student1!");
        } else {
            System.out.println("Sorry, the book is already checked out or student1 has a book.");
        }

        if (library.checkOutBook(book2, staff1, "2024-03-10")) {
            System.out.println("Book checked out successfully by staff1!");
        } else {
            System.out.println("Sorry, the book is already checked out or staff1 has a book.");
        }

        if (library.checkOutBook(book1, libraryStaff1, "2024-03-15")) {
            System.out.println("Book checked out successfully by libraryStaff1!");
        } else {
            System.out.println("Sorry, the book is already checked out or libraryStaff1 has a book.");
        }
    }
}

