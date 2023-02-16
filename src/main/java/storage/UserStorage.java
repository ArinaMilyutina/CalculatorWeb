package storage;

import entity.User;

import java.util.Optional;

public interface UserStorage {
    void add(User user);

    Optional<User> findByUsername(String username);

}
