package librarymgmtsystem.repositoriesImpl;

import librarymgmtsystem.models.BookCopy;
import librarymgmtsystem.repositories.BookCopyRepository;

import java.util.*;

public class IMBookCopyRepositoryImpl implements BookCopyRepository {
    private final Map<UUID, BookCopy> bookCopyMap;
    private final Map<UUID, Set<BookCopy>> bookIdToBookCopiesMap;

    public IMBookCopyRepositoryImpl() {
        bookCopyMap = new HashMap<>();
        bookIdToBookCopiesMap = new HashMap<>();
    }

    @Override
    public void addBookCopy(BookCopy bookCopy) {
        if(Objects.nonNull(bookCopy.getBookCopyId()) && Objects.nonNull(bookCopy.getBookId())) {
            bookCopyMap.put(bookCopy.getBookId(), bookCopy);
            Set<BookCopy> bookCopies = bookIdToBookCopiesMap.get(bookCopy.getBookId());
            if(Objects.isNull(bookCopies)){
                bookCopies = new HashSet<>();
            }
            bookCopies.add(bookCopy);
            bookIdToBookCopiesMap.put(bookCopy.getBookId(), bookCopies);
        }
    }

    @Override
    public void removeBookCopy(UUID bookCopyId) {
        if(Objects.nonNull(bookCopyId)) {
            UUID bookId = bookCopyMap.get(bookCopyId).getBookId();
            bookCopyMap.remove(bookCopyId);
            Set<BookCopy> bookCopies = bookIdToBookCopiesMap.get(bookCopyId);
            bookCopies.remove(bookId);
            bookIdToBookCopiesMap.put(bookCopyId, bookCopies);
        }
    }

    @Override
    public Set<BookCopy> getAllBookCopiesOfBook(UUID bookId) {
        return bookIdToBookCopiesMap.get(bookId);
    }

    @Override
    public void removeAllBookCopiesOfBook(UUID bookId) {
        Set<BookCopy> bookCopies = this.getAllBookCopiesOfBook(bookId);
        for(BookCopy bookCopy :  bookCopies) {
            this.removeBookCopy(bookCopy.getBookCopyId());
        }
    }
}
