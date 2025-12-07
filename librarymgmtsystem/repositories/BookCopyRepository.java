package librarymgmtsystem.repositories;

import librarymgmtsystem.models.BookCopy;

import java.util.Set;
import java.util.UUID;

public interface BookCopyRepository {
    void addBookCopy(BookCopy bookCopy);
    void removeBookCopy(UUID bookCopyId);
    Set<BookCopy> getAllBookCopiesOfBook(UUID BookId);
    void removeAllBookCopiesOfBook(UUID bookId);
}
