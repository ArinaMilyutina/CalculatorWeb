package service;


import entity.User;
import storage.InMemoryUserStorage;
import storage.JDBCUserStorage;
import storage.UserStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {
    private static final UserStorage storageList = new InMemoryUserStorage();
    private static final JDBCUserStorage userStorage = new JDBCUserStorage();

    public void create(User user) {
        storageList.add(user);
        userStorage.add(user);
    }

    public static List<User> findAll() {
        return userStorage.findAll();
    }


    public Optional<User> findByUsername(String username) {
        return storageList.findByUsername(username);
    }

    public static List<User> deleteUser(String username) {
        userStorage.deleteByUsername(username);
        return new ArrayList<>();
    }

    public static Optional<User> findByUser(String username) {
        return userStorage.findByUsername(username);
    }
    public static void deleteHistory(){
        userStorage.removeStorage();
    }
}