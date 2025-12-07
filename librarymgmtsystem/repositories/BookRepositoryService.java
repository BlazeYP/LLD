package librarymgmtsystem.repositories;

import librarymgmtsystem.models.Book;

import java.util.List;
import java.util.UUID;

public interface BookRepositoryService {
    void addBook(Book book);
    void removeBook(UUID bookId);
    List<Book> getAllBooks();
    void getBook(UUID bookId);
}
