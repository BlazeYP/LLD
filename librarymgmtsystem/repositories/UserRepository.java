package librarymgmtsystem.repositories;

import librarymgmtsystem.models.User;

import java.util.UUID;

public interface UserRepository {
    void addUser(User user);
    void removeUser(UUID userId);
    User getUser(UUID userId);
}
