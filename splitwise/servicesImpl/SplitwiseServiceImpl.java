package splitwise.servicesImpl;

import splitwise.exceptions.SplitTypeException;
import splitwise.models.ExpenseRecord;
import splitwise.services.SplitType;
import splitwise.services.SplitwiseRecordService;
import splitwise.services.SplitwiseService;
import splitwise.services.UserService;

import java.util.ArrayList;
import java.util.Objects;

public class SplitwiseServiceImpl implements SplitwiseService {
    private UserService userService;
    private SplitwiseRecordService splitwiseRecordService;

    public SplitwiseServiceImpl(UserService userService, SplitwiseRecordService splitwiseRecordService) {
        this.userService = userService;
        this.splitwiseRecordService = splitwiseRecordService;
    }

    @Override
    public boolean addExpense(String payerUserId, ArrayList<String> borrowerUserIdList, double totalAmount, SplitType splitType, ArrayList<Double> borrowedAmountList) {
        try {
            splitType.setTotalAmount(totalAmount);
            splitType.setNumberOfSplits(borrowerUserIdList.size());
            splitType.setShareList(borrowedAmountList);
            if (splitType.validateSplits()) {
                //If valid splits, create new expense records
                ArrayList<ExpenseRecord> newExpenseRecords = new ArrayList<>();
                ArrayList<Double> sharedAmountList = new ArrayList<>(splitType.getSplits());
                for(int i=0; i<borrowerUserIdList.size(); i++) {
                    if(!payerUserId.equalsIgnoreCase(borrowerUserIdList.get(i))) {
                        newExpenseRecords.add(new ExpenseRecord(payerUserId, borrowerUserIdList.get(i), sharedAmountList.get(i)));
                    }
                }

                //Add expense records accordingly
                ArrayList<ExpenseRecord> existingExpenseRecords = (ArrayList<ExpenseRecord>) splitwiseRecordService.getAllRecordsForUserId(payerUserId);
                for(ExpenseRecord newExpenseRecord : newExpenseRecords) {
                    ExpenseRecord selectedExpenseRecord = null;
                    for(ExpenseRecord existingExpenseRecord : existingExpenseRecords) {
                        if(isUserPairPresent(newExpenseRecord, existingExpenseRecord)) {
                            selectedExpenseRecord = existingExpenseRecord;
                            break;
                        }
                    }
                    if(Objects.nonNull(selectedExpenseRecord)) {
                        if(selectedExpenseRecord.getPayerUserId().equalsIgnoreCase(newExpenseRecord.getPayerUserId())) {
                            splitwiseRecordService.updateRecord(selectedExpenseRecord.getExpenseId(), selectedExpenseRecord.getPayerUserId()
                                    ,selectedExpenseRecord.getBorrowerUserId(), selectedExpenseRecord.getAmount() + newExpenseRecord.getAmount());
                        } else {
                            double remainingAmount = selectedExpenseRecord.getAmount() - newExpenseRecord.getAmount();
                            if(remainingAmount > 0) {
                                splitwiseRecordService.updateRecord(selectedExpenseRecord.getExpenseId(), selectedExpenseRecord.getPayerUserId()
                                        ,selectedExpenseRecord.getBorrowerUserId(), selectedExpenseRecord.getAmount() - newExpenseRecord.getAmount());
                            } else {
                                splitwiseRecordService.deleteRecord(selectedExpenseRecord.getExpenseId());
                                splitwiseRecordService.addRecord(newExpenseRecord.getPayerUserId(), newExpenseRecord.getBorrowerUserId(), -1*remainingAmount);
                            }
                        }
                    } else {
                        splitwiseRecordService.addRecord(newExpenseRecord.getPayerUserId(), newExpenseRecord.getBorrowerUserId(), newExpenseRecord.getAmount());
                    }
                }
                return true;
            }
        } catch (SplitTypeException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private boolean isUserPairPresent(ExpenseRecord newExpenseRecord, ExpenseRecord existingExpenseRecord) {
        String newPair1 = newExpenseRecord.getPayerUserId() + "|" + newExpenseRecord.getBorrowerUserId();
        String newPair2 = newExpenseRecord.getBorrowerUserId() + "|" + newExpenseRecord.getPayerUserId();
        String existingRecord = existingExpenseRecord.getPayerUserId() + "|" +existingExpenseRecord.getBorrowerUserId();
        return existingRecord.equalsIgnoreCase(newPair1) || existingRecord.equalsIgnoreCase(newPair2);
    }

    @Override
    public void show(String userId) {
        if(Objects.nonNull(userId) && !userId.isBlank()) {
            ArrayList<ExpenseRecord> userExpenseRecords = new ArrayList<>(splitwiseRecordService.getAllRecordsForUserId(userId));
            if(Objects.nonNull(userExpenseRecords) && !userExpenseRecords.isEmpty()) {
                for(ExpenseRecord userExpenseRecord : userExpenseRecords) {
                    String s = userExpenseRecord.getBorrowerUserId() + " owes " + userExpenseRecord.getPayerUserId() + " : " + userExpenseRecord.getAmount();
                    System.out.println(s);
                }
            } else {
                System.out.println("No Balances");
            }
        } else {
            ArrayList<ExpenseRecord> expenseRecords = new ArrayList<>(splitwiseRecordService.getAllRecords());
            if(Objects.nonNull(expenseRecords) && !expenseRecords.isEmpty()) {
                for(ExpenseRecord expenseRecord : expenseRecords) {
                    String s = expenseRecord.getBorrowerUserId() + " owes " + expenseRecord.getPayerUserId() + " : " + expenseRecord.getAmount();
                    System.out.println(s);
                }
            } else {
                System.out.println("No Balances");
            }
        }
    }
}
