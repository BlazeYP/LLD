package splitwise.services;

import splitwise.models.User;

public interface UserService {
    boolean addUser(String userId, String name, String email, String phoneNumber);
    boolean addUser(User user);
    boolean deleteUser(String userId);
    boolean isUserPresent(String userId);
}
