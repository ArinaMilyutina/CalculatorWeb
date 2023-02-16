package service;


import entity.User;
import storage.InMemoryUserStorage;
import storage.JDBCStorage;
import storage.UserStorage;

import java.util.Optional;

public class UserService {
    UserStorage storageList = new InMemoryUserStorage();
    UserStorage storageJDBS = new JDBCStorage();

    public void create(User user) {
        storageList.add(user);
        storageJDBS.add(user);
    }

    public Optional<User> findByUsername(String username) {
        return storageList.findByUsername(username);
    }

}