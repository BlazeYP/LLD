package librarymgmtsystem.models;

import java.util.UUID;

public class BookCopy {
    private UUID bookCopyId;
    private UUID bookId;

    public BookCopy() {
    }

    public BookCopy(UUID bookCopyId, UUID bookId) {
        this.bookCopyId = bookCopyId;
        this.bookId = bookId;
    }

    public UUID getBookCopyId() {
        return bookCopyId;
    }

    public void setBookCopyId(UUID bookCopyId) {
        this.bookCopyId = bookCopyId;
    }

    public UUID getBookId() {
        return bookId;
    }

    public void setBookId(UUID bookId) {
        this.bookId = bookId;
    }
}
