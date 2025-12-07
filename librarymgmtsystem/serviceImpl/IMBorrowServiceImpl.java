package librarymgmtsystem.serviceImpl;

import librarymgmtsystem.models.BorrowRecord;
import librarymgmtsystem.repositories.BorrowRecordRepository;
import librarymgmtsystem.service.BorrowService;
import librarymgmtsystem.service.BookInventoryService;
import librarymgmtsystem.utilities.UUIDGenerater;

import java.util.Date;
import java.util.UUID;

public class IMBorrowServiceImpl implements BorrowService {
    private final BookInventoryService inventoryService;
    private final BorrowRecordRepository borrowRecordRepository;

    public IMBorrowServiceImpl(BookInventoryService inventoryService, BorrowRecordRepository borrowRecordRepository) {
        this.inventoryService = inventoryService;
        this.borrowRecordRepository = borrowRecordRepository;
    }

    @Override
    public void borrowBook(BorrowRecord borrowRecord) {
        //Remove book copy from inventory
        inventoryService.removeBookCopy(borrowRecord.getBookCopyId());
        //Add audit borrow record
        UUID borrowRecordId = UUIDGenerater.generateUUID();
        borrowRecord.setBorrowRecordId(borrowRecordId);
        borrowRecordRepository.addBorrowRecord(borrowRecord);
    }

    @Override
    public void returnBook(UUID bookId) {
        //Update the audit borrow record
        borrowRecordRepository.setBookReturnDate(bookId, new Date());
        //Add book copy to inventory;
        inventoryService.
    }
}
