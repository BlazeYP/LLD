package librarymgmtsystem.models;

public class User extends Person{
    private Integer borrowedBooksCount;


    public Integer getBorrowedBooksCount() {
        return borrowedBooksCount;
    }

    public void setBorrowedBooksCount(Integer borrowedBooksCount) {
        this.borrowedBooksCount = borrowedBooksCount;
    }
}
