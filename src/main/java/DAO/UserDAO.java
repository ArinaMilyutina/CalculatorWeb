package DAO;

import entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    void add(User user);

    Optional<User> findByUsername(String username);

    void deleteByUsername(String username);

    List<User> findAll();

    void removeStorage();
}
