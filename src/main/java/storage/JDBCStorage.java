package storage;

import entity.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

public class JDBCStorage implements UserStorage {

    Connection connection;
    public JDBCStorage() {
        try {
            this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "arinemiller22");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void add(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into users values(default, ?, ?, ?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.empty();
    }
}
