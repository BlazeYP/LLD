package librarymgmtsystem.serviceImpl;

import librarymgmtsystem.models.Book;
import librarymgmtsystem.models.BookCopy;
import librarymgmtsystem.repositories.BookCopyRepository;
import librarymgmtsystem.repositories.BookRepositoryService;
import librarymgmtsystem.service.*;
import librarymgmtsystem.strategies.BookSearchStrategy;
import librarymgmtsystem.utilities.UUIDGenerater;

import java.util.Set;
import java.util.UUID;

public class IMBookInventoryServiceImpl implements BookInventoryService {
    private final BookRepositoryService bookRepositoryService;
    private final BookCopyRepository bookCopyRepository;
    private final RackService rackService;

    public IMBookInventoryServiceImpl(BookRepositoryService bookRepositoryService, BookCopyRepository bookCopyRepository, RackService rackService) {
        this.bookRepositoryService = bookRepositoryService;
        this.bookCopyRepository = bookCopyRepository;
        this.rackService = rackService;
    }

    @Override
    public void addBook(Book book, int noOfCopies) {
        //Todo: validation checks on book attributes
        //Set UUID for book
        UUID bookID = UUIDGenerater.generateUUID();
        book.setBookId(bookID);
        bookRepositoryService.addBook(book);
        for(int i=0; i<noOfCopies; i++) {
            UUID bookCopyId = UUIDGenerater.generateUUID();
            BookCopy bookCopy = new BookCopy(bookCopyId, bookID);
            bookCopyRepository.addBookCopy(bookCopy);
            rackService.addBookToRack(bookCopyId);
        }
    }

    @Override
    public void removeBookCopy(UUID bookCopyId) {
        bookCopyRepository.removeBookCopy(bookCopyId);
        rackService.removeBookFromRack(bookCopyId);
    }

    @Override
    public void removeBook(UUID bookId) {
        bookRepositoryService.removeBook(bookId);
        Set<BookCopy> bookCopyList = bookCopyRepository.getAllBookCopiesOfBook(bookId);
        bookCopyRepository.removeAllBookCopiesOfBook(bookId);
        for(BookCopy bookCopy : bookCopyList) {
            rackService.removeBookFromRack(bookCopy.getBookCopyId());
        }
    }

    @Override
    public Book searchBook(BookSearchStrategy strategy) {
        return strategy.search();
    }

    @Override
    public void replaceBookCopy(UUID bookCopyId) {

    }
}
