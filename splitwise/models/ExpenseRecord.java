package splitwise.models;

public class ExpenseRecord {
    private String expenseId;
    private String payerUserId;
    private String borrowerUserId;
    private double amount;

    public ExpenseRecord() {
    }

    public ExpenseRecord(String expenseId, String payerUserId, String borrowerUserId, double amount) {
        this.expenseId = expenseId;
        this.payerUserId = payerUserId;
        this.borrowerUserId = borrowerUserId;
        this.amount = amount;
    }

    public ExpenseRecord(String payerUserId, String borrowerUserId, double amount) {
        this.payerUserId = payerUserId;
        this.borrowerUserId = borrowerUserId;
        this.amount = amount;
    }

    public ExpenseRecord(ExpenseRecord expenseRecord) {
        this.expenseId = expenseRecord.getExpenseId();
        this.payerUserId = expenseRecord.payerUserId;
        this.borrowerUserId = expenseRecord.borrowerUserId;
        this.amount = expenseRecord.amount;
    }

    public String getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(String expenseId) {
        this.expenseId = expenseId;
    }

    public String getPayerUserId() {
        return payerUserId;
    }

    public void setPayerUserId(String payerUserId) {
        this.payerUserId = payerUserId;
    }

    public String getBorrowerUserId() {
        return borrowerUserId;
    }

    public void setBorrowerUserId(String borrowerUserId) {
        this.borrowerUserId = borrowerUserId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
