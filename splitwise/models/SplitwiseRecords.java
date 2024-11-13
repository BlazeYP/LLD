package splitwise.models;

import java.util.ArrayList;

public class SplitwiseRecords {
    private ArrayList<ExpenseRecord> expenseRecords;

    public SplitwiseRecords(ArrayList<ExpenseRecord> expenseRecords) {
        this.expenseRecords = expenseRecords;
    }

    public ArrayList<ExpenseRecord> getExpenseRecords() {
        return expenseRecords;
    }

    public void setExpenseRecords(ArrayList<ExpenseRecord> expenseRecords) {
        this.expenseRecords = expenseRecords;
    }
}
