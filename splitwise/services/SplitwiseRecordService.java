package splitwise.services;

import splitwise.models.ExpenseRecord;

import java.util.List;

public interface SplitwiseRecordService {
    boolean addRecord(String payerUserId, String borrowerUserId, double amount);
    List<ExpenseRecord> getAllRecords();
    List<ExpenseRecord> getAllRecordsForUserId(String userId);
    boolean updateRecord(String expenseId, String payerUserId, String borrowerUserId, double amount);
    boolean deleteRecord(String expenseId);
}
