package splitwise.models;

import java.util.ArrayList;

public class UserRecords {
    private ArrayList<User> userRecords;

    public UserRecords() {
    }

    public UserRecords(ArrayList<User> userRecords) {
        this.userRecords = userRecords;
    }

    public ArrayList<User> getUserRecords() {
        return userRecords;
    }

    public void setUserRecords(ArrayList<User> userRecords) {
        this.userRecords = userRecords;
    }
}
