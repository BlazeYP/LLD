package librarymgmtsystem.repositoriesImpl;

import librarymgmtsystem.models.Book;
import librarymgmtsystem.repositories.BookRepositoryService;

import java.util.*;

public class IMBookRepositoryImpl implements BookRepositoryService {
    private final Map<UUID, Book> bookMap;

    public IMBookRepositoryImpl() {
        this.bookMap = new HashMap<>();
    }

    @Override
    public void addBook(Book book) {
        if(Objects.nonNull(book.getBookId())) {
            bookMap.put(book.getBookId(), book);
        }
    }

    @Override
    public void removeBook(UUID bookId) {
        bookMap.remove(bookId);
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> bookList = new ArrayList<>();
        for(Map.Entry<UUID, Book> bookEntry : bookMap.entrySet()) {
            bookList.add(bookEntry.getValue());
        }
        return bookList;
    }

    @Override
    public void getBook(UUID bookId) {
        bookMap.get(bookId);
    }
}
