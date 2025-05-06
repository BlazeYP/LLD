package librarymgmtsystem.models;

import java.util.ArrayList;

public class Rack {
    private Integer id;
    private ArrayList<Book> books;

    public Rack() {
    }

    public Rack(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
}
