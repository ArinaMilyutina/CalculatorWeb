package service;


import entity.User;
import storage.JDBCUserStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {
    private static final JDBCUserStorage userStorage = new JDBCUserStorage();

    public void create(User user) {
        userStorage.add(user);
    }

    public List<User> findAll() {
        return userStorage.findAll();
    }

    public List<User> deleteUser(String username) {
        userStorage.deleteByUsername(username);
        return new ArrayList<>();
    }

    public Optional<User> findByUser(String username) {
        return userStorage.findByUsername(username);
    }

    public void deleteHistory() {
        userStorage.removeStorage();
    }
}