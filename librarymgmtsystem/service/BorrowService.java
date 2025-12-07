package librarymgmtsystem.service;

import librarymgmtsystem.models.BorrowRecord;

import java.util.UUID;

public interface BorrowService {
    void borrowBook(BorrowRecord borrowRecord);
    void returnBook(UUID bookId);
}
