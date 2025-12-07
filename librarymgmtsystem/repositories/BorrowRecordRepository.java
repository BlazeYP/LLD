package librarymgmtsystem.repositories;

import librarymgmtsystem.models.BorrowRecord;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface BorrowRecordRepository {
    void addBorrowRecord(BorrowRecord borrowRecord);
    void updateBorrowRecord(BorrowRecord borrowRecord);
    void setBookReturnDate(UUID bookCopyId, Date returnDate);
    List<BorrowRecord> getBorrowRecordsOfBook(UUID bookId);
    List<BorrowRecord> getBorrowRecordsOfUser(UUID userId);
}
