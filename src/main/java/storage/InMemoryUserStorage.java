package storage;

import entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryUserStorage implements UserStorage {
    private final static List<User> users = new ArrayList<>();


    @Override
    public void add(User user) {
        users.add(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

}
