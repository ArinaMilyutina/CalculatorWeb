package storage;

import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCUserStorage extends AbstractStorage implements UserStorage {
    String DELETE_USERS = "truncate table users";
    String SELECT_USERS = "select*from users";
    String DELETE_BY_USERNAME = "delete from users where username=?";
    String INSERT_USERS = "insert into users values(default, ?, ?, ?)";
    String FIND_USER_BY_USERNAME = "select * from users where username = ?";

    private static JDBCUserStorage INSTANCE;

    private JDBCUserStorage() {

    }

    public static JDBCUserStorage getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new JDBCUserStorage();
        }
        return INSTANCE;
    }

    @Override
    public void add(User user) {
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(INSERT_USERS);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteByUsername(String username) {
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(DELETE_BY_USERNAME);
            preparedStatement.setString(1, username);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> findAll() {
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_USERS);
            List<User> userList = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                User users = new User(id, name, username, password);
                userList.add(users);
            }
            return userList;

        } catch (SQLException ignored) {
        }
        return new ArrayList<>();
    }

    @Override
    public void removeStorage() {
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(DELETE_USERS);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }

    @Override
    public Optional<User> findByUsername(String username) {
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(FIND_USER_BY_USERNAME);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String password = resultSet.getString(4);
            User user = new User(id, name, username, password);
            return Optional.of(user);
        } catch (SQLException ignored) {

        }
        return Optional.empty();
    }
}