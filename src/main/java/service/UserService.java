package service;


import entity.User;
import storage.JDBCUserStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {
    private static UserService INSTANCE;

    private UserService() {

    }

    public static UserService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserService();
        }
        return INSTANCE;
    }


    public void create(User user) {
        JDBCUserStorage.getInstance().add(user);
    }

    public List<User> findAll() {
        return JDBCUserStorage.getInstance().findAll();
    }

    public List<User> deleteUser(String username) {
        JDBCUserStorage.getInstance().deleteByUsername(username);
        return new ArrayList<>();
    }

    public Optional<User> findByUser(String username) {
        return JDBCUserStorage.getInstance().findByUsername(username);
    }

    public void deleteHistory() {
        JDBCUserStorage.getInstance().removeStorage();
    }
}