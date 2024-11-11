package splitwise.servicesImpl;

import splitwise.models.ExpenseRecord;
import splitwise.models.SplitwiseRecords;
import splitwise.services.SplitwiseRecordService;
import splitwise.services.UniqueIdGeneratorService;

import java.util.ArrayList;
import java.util.Objects;

public class SplitwiseRecordServiceImpl implements SplitwiseRecordService {
    private SplitwiseRecords splitwiseRecords;
    private UniqueIdGeneratorService uniqueIdGeneratorService;

    public SplitwiseRecordServiceImpl(SplitwiseRecords splitwiseRecords, UniqueIdGeneratorService uniqueIdGeneratorService) {
        this.splitwiseRecords = splitwiseRecords;
        this.uniqueIdGeneratorService = uniqueIdGeneratorService;
    }

    @Override
    public boolean addRecord(String payerUserId, String borrowerUserId, double amount) {
        String expenseId = uniqueIdGeneratorService.getUniqueId();
        ExpenseRecord newExpenseRecord = new ExpenseRecord(expenseId, payerUserId, borrowerUserId, amount);
        ArrayList<ExpenseRecord> expenseRecords = splitwiseRecords.getExpenseRecords();
        return expenseRecords.add(newExpenseRecord);
    }

    @Override
    public ArrayList<ExpenseRecord> getAllRecords() {
        ArrayList<ExpenseRecord> resultSet = null;
        ArrayList<ExpenseRecord> expenseRecords = splitwiseRecords.getExpenseRecords();
        if(Objects.nonNull(expenseRecords)) {
            resultSet = new ArrayList<>();
            for (ExpenseRecord expenseRecord : expenseRecords) {
                resultSet.add(new ExpenseRecord(expenseRecord));
            }
        }
        return resultSet;
    }

    @Override
    public ArrayList<ExpenseRecord> getAllRecordsForUserId(String userId) {
        ArrayList<ExpenseRecord> resultSet = null;
        ArrayList<ExpenseRecord> expenseRecords = splitwiseRecords.getExpenseRecords();
        if(Objects.nonNull(expenseRecords)) {
            resultSet = new ArrayList<>();
            for (ExpenseRecord expenseRecord : expenseRecords) {
                if (expenseRecord.getPayerUserId().equalsIgnoreCase(userId) || expenseRecord.getBorrowerUserId().equalsIgnoreCase(userId)) {
                    resultSet.add(new ExpenseRecord(expenseRecord));
                }
            }
        }
        return resultSet;
    }

    @Override
    public boolean updateRecord(String expenseId, String payerUserId, String borrowerUserId, double amount) {
        ArrayList<ExpenseRecord> expenseRecords = splitwiseRecords.getExpenseRecords();
        for(ExpenseRecord expenseRecord : expenseRecords) {
            if(expenseRecord.getExpenseId().equalsIgnoreCase(expenseId)) {
                expenseRecord.setPayerUserId(payerUserId);
                expenseRecord.setBorrowerUserId(borrowerUserId);
                expenseRecord.setAmount(amount);
            }
        }
        return true;
    }

    @Override
    public boolean deleteRecord(String expenseId) {
        ArrayList<ExpenseRecord> expenseRecords = splitwiseRecords.getExpenseRecords();
        for(ExpenseRecord expenseRecord : expenseRecords) {
            if(expenseRecord.getExpenseId().equalsIgnoreCase(expenseId)) {
                expenseRecords.remove(expenseRecord);
            }
        }
        return true;
    }
}
