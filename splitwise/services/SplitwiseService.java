package splitwise.services;

import java.util.ArrayList;

public interface SplitwiseService {
    boolean addExpense(String payerUserId, ArrayList<String> borrowerUserIdList, double totalAmount, SplitType splitType, ArrayList<Double> borrowedAmountList);
    void show(String userId);
}
