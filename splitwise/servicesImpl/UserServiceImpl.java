package splitwise.servicesImpl;

import splitwise.models.User;
import splitwise.models.UserRecords;
import splitwise.services.UserService;

import java.util.ArrayList;

public class UserServiceImpl implements UserService {
    private UserRecords userRecords;

    public UserServiceImpl(UserRecords userRecords) {
        this.userRecords = userRecords;
    }

    @Override
    public boolean addUser(String userId, String name, String email, String phoneNumber) {
        User user = new User(userId, name, email, phoneNumber);
        ArrayList<User> users = userRecords.getUserRecords();
        return users.add(user);
    }

    @Override
    public boolean addUser(User user) {
        ArrayList<User> users = userRecords.getUserRecords();
        return users.add(user);
    }

    @Override
    public boolean deleteUser(String userId) {
        ArrayList<User> users = userRecords.getUserRecords();
        for(User user : users) {
            if(user.getUserId().equalsIgnoreCase(userId)){
                return users.remove(user);
            }
        }
        return false;
    }

    @Override
    public boolean isUserPresent(String userId) {
        ArrayList<User> users = userRecords.getUserRecords();
        for(User user : users) {
            if(user.getUserId().equalsIgnoreCase(userId)){
                return true;
            }
        }
        return false;
    }
}
