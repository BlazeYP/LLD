package librarymgmtsystem.models;

import java.util.ArrayList;
import java.util.Date;

public class Book {
    private String bookId;
    private String bookCopyId;
    private String title;
    private ArrayList<Author> authors;
    private ArrayList<Publisher> publishers;
    private Boolean isBorrowed;
    private Date dueDate;
    private User borroweredUser;

    public Book() {
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookCopyId() {
        return bookCopyId;
    }

    public void setBookCopyId(String bookCopyId) {
        this.bookCopyId = bookCopyId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<Author> authors) {
        this.authors = authors;
    }

    public ArrayList<Publisher> getPublishers() {
        return publishers;
    }

    public void setPublishers(ArrayList<Publisher> publishers) {
        this.publishers = publishers;
    }

    public Boolean getBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(Boolean borrowed) {
        isBorrowed = borrowed;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public User getBorroweredUser() {
        return borroweredUser;
    }

    public void setBorroweredUser(User borroweredUser) {
        this.borroweredUser = borroweredUser;
    }
}
