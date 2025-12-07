package librarymgmtsystem.models;

import java.util.Date;
import java.util.UUID;

public class BorrowRecord {
    private UUID borrowRecordId;
    private UUID bookCopyId;
    private UUID userId;
    private Date fromDate;
    private Date dueDate;
    private Date returnDate;

    public BorrowRecord(UUID borrowRecordId, UUID bookCopyId, UUID userId, Date fromDate, Date dueDate, Date returnDate) {
        this.borrowRecordId = borrowRecordId;
        this.bookCopyId = bookCopyId;
        this.userId = userId;
        this.fromDate = fromDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
    }

    public UUID getBorrowRecordId() {
        return borrowRecordId;
    }

    public void setBorrowRecordId(UUID borrowRecordId) {
        this.borrowRecordId = borrowRecordId;
    }

    public UUID getBookCopyId() {
        return bookCopyId;
    }

    public void setBookCopyId(UUID bookCopyId) {
        this.bookCopyId = bookCopyId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
