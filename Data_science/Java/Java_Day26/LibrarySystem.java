package Java_Day26;

import java.util.*;

public class LibrarySystem { //도서관 관리 시스템
    private Library ACCESSS; //잭 데이터 저장소
    Set<User> users = new HashSet<>();
    long userId = 2000L;

    LibrarySystem() {
        ACCESSS = Library.getACCESS();
    }

    public void signIn(String userName) {
        users.add(new User(userId++, userName));
    }//회원가입

    public void addBook(String selfName, String bookName) { //책 추가
        ACCESSS.addBook(selfName, bookName);
    }

    public void borrowBook(long userId, String selfName) { //책 대출
        for (User u : users) {
            if (u.getId() == userId) {
                System.out.println(u.getName());
                u.borrowBook(ACCESSS.borrowBook(selfName));
                System.out.println("성공");
                return;
            }
        }
        System.out.println("err");
    }

    public void userBorrowBooks(long userId) { //이용자가 빌린 책
        for (User u : users) {
            if (u.getId() == userId) {
                System.out.println(u.getName());
                u.myBooks();
                return;
            }
        }
        System.out.println("err");
    }

    public void returnBook(long userId, String bookName, String selfName) {//책 반납
        for (User u : users) {
            if (u.getId() == userId) {
                System.out.println(u.getName());
                ACCESSS.returnBook(selfName, u.returnBook(bookName));
                return;
            }
        }
        System.out.println("err");
    }

    public void showBoolSelf(String selfName) {// 책장 책 목록
        ACCESSS.showBoolSelf(selfName);
    }
}

class Library {// 책 데이터 저장소
    private static Library ACCESS;
    private Map<String, BookSelf_> bookSelf = new HashMap<>(); //책장 A,B
    private long bookId = 1000L;

    private Library() {
        bookSelf.put("A", new BookSelfA());
        bookSelf.put("B", new BookSelfB());
    }

    public static synchronized Library getACCESS() {
        if (ACCESS == null) {
            ACCESS = new Library();
        }
        return ACCESS;
    }

    public void addBook(String selfName, String bookName) {//책 추가
        bookSelf.get(selfName).addBook(new Book(bookId++, bookName));
    }

    public Book borrowBook(String selfName) {// 대출
        return bookSelf.get(selfName).borrowBook();
    }

    public void returnBook(String selfName, Book book) {//반납
        bookSelf.get(selfName).returnBook(book);
    }

    public void showBoolSelf(String selfName) {//책장 책 목록
        System.out.println(bookSelf.get(selfName));
    }
}

class Book {
    private long id;
    private String name;

    Book(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Book book = (Book) object;
        return id == book.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                '}';
    }
}

class User {
    private long id;
    private String name;
    private Set<Book> books = new HashSet<>();//빌린 책 목록

    User(long id, String name) {
        this.name = name;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void borrowBook(Book book) {
        books.add(book);
    }//대출

    public Book returnBook(String bookName) {//반납
        Book reBook;
        for (Book book : books) {
            if (book.getName().equals(bookName)) {
                reBook = book;
                books.remove(book);
                return reBook;
            }
        }
        System.out.println("not found");
        return null;
    }

    public void myBooks() {//빌린 책 복록 조회
        System.out.println(books);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        User user = (User) object;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

interface BookSelf_ {
    void addBook(Book book);//책 추가

    Book borrowBook();//대출

    void returnBook(Book book);//반납

}

abstract class BookSelf implements BookSelf_ {
    protected List<Book> books = new ArrayList<>();

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    protected boolean canBorrow() {
        return !books.isEmpty();
    }

    @Override
    public String toString() {
        return books.toString();
    }
}

class BookSelfA extends BookSelf {
    @Override
    public Book borrowBook() {
        if (canBorrow())
            return books.remove(0);
        return null;
    }

    @Override
    public void returnBook(Book book) {
        addBook(book);
    }
}

class BookSelfB extends BookSelf {
    @Override
    public Book borrowBook() {
        if (canBorrow())
            return books.remove(books.size() - 1);
        return null;
    }

    @Override
    public void returnBook(Book book) {
        addBook(book);
    }
}

class Main_ {
    public static void main(String[] args) {
        LibrarySystem li = new LibrarySystem();
        li.addBook("A", "노인과 바다");
        li.addBook("A", "어린왕자");
        li.addBook("A", "개미");
        li.showBoolSelf("A");
        li.addBook("B", "삼국지");
        li.addBook("B", "연금술사");
        li.addBook("B", "해리포터");
        li.showBoolSelf("B");

        li.signIn("a");
        li.signIn("b");

        li.borrowBook(2000L, "A");
        li.borrowBook(2001L, "A");
        li.borrowBook(2000L, "B");

        li.userBorrowBooks(2000L);
        li.userBorrowBooks(2001L);

        li.returnBook(2000L, "해리포터", "A");
        li.returnBook(2001L, "어린왕자", "B");
        li.returnBook(2000L, "노인과 바다", "B");
        li.showBoolSelf("A");
        li.showBoolSelf("B");
    }
}