package librarymgmtsystem.repositoriesImpl;

import librarymgmtsystem.models.User;
import librarymgmtsystem.repositories.UserRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class IMUserRepositoryImpl implements UserRepository {
    private final Map<UUID, User> userMap;

    public IMUserRepositoryImpl() {
        this.userMap = new HashMap<>();
    }

    @Override
    public void addUser(User user) {
        userMap.put(user.getUuid(), user);
    }

    @Override
    public void removeUser(UUID userId) {
        userMap.remove(userId);
    }

    @Override
    public User getUser(UUID userId) {
        return userMap.get(userId);
    }
}
