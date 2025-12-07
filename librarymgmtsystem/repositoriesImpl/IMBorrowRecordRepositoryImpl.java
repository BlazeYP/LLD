package librarymgmtsystem.repositoriesImpl;

import librarymgmtsystem.models.BorrowRecord;
import librarymgmtsystem.repositories.BorrowRecordRepository;

import java.util.*;

public class IMBorrowRecordRepositoryImpl implements BorrowRecordRepository {
    private final Map<UUID, BorrowRecord> borrowRecords;
    private final Map<UUID, List<BorrowRecord>> bookBorrowRecordMap;
    private final Map<UUID, List<BorrowRecord>> userBorrowRecordMap;

    public IMBorrowRecordRepositoryImpl() {
        borrowRecords = new HashMap<>();
        bookBorrowRecordMap = new HashMap<>();
        userBorrowRecordMap = new HashMap<>();
    }

    @Override
    public void addBorrowRecord(BorrowRecord borrowRecord) {
        if(Objects.nonNull(borrowRecord.getBorrowRecordId()) && Objects.nonNull(borrowRecord.getBookCopyId()) && Objects.nonNull(borrowRecord.getUserId())) {
            //Adding borrow record to list
            borrowRecords.put(borrowRecord.getBorrowRecordId(), borrowRecord);
            //Adding borrow record to book map
            UUID bookId = borrowRecord.getBookCopyId();
            List<BorrowRecord> bookBorrowRecordList = bookBorrowRecordMap.get(bookId);
            if (Objects.isNull(bookBorrowRecordList)) {
                bookBorrowRecordList = new ArrayList<>();
            }
            bookBorrowRecordList.add(borrowRecord);
            bookBorrowRecordMap.put(bookId, bookBorrowRecordList);
            //Adding borrow record to user map
            UUID userId = borrowRecord.getUserId();
            List<BorrowRecord> userBorrowRecordList = userBorrowRecordMap.get(userId);
            if (Objects.isNull(userBorrowRecordList)) {
                userBorrowRecordList = new ArrayList<>();
            }
            userBorrowRecordList.add(borrowRecord);
            userBorrowRecordMap.put(userId, userBorrowRecordList);
        }
    }

    @Override
    public void updateBorrowRecord(BorrowRecord borrowRecord) {
        //Todo

    }

    @Override
    public void setBookReturnDate(UUID bookCopyId, Date returnDate) {
        List<BorrowRecord> borrowRecordList = bookBorrowRecordMap.get(bookCopyId);
        for(BorrowRecord record : borrowRecordList) {
            if(Objects.isNull(record.getReturnDate())) {
                record.setReturnDate(returnDate);
            }
        }
    }

    @Override
    public List<BorrowRecord> getBorrowRecordsOfBook(UUID bookId) {
        return bookBorrowRecordMap.get(bookId);
    }

    @Override
    public List<BorrowRecord> getBorrowRecordsOfUser(UUID userId) {
        return userBorrowRecordMap.get(userId);
    }
}
