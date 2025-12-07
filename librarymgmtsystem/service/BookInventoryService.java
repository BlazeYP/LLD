package librarymgmtsystem.service;

import librarymgmtsystem.models.Book;
import librarymgmtsystem.strategies.BookSearchStrategy;

import java.util.UUID;

public interface BookInventoryService {
    void addBook(Book book, int noOfCopies);
    void removeBookCopy(UUID bookCopyId);
    void removeBook(UUID bookId);
    Book searchBook(BookSearchStrategy strategy);
    void replaceBookCopy(UUID bookCopyId);
}
