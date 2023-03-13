package storage;

import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCUserStorage implements UserStorage, JDBCConstantes {

    @Override
    public void add(User user) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS);
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
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_USERNAME);
            preparedStatement.setString(1, username);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> findAll() {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            Statement statement = connection.createStatement();
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
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }

    @Override
    public Optional<User> findByUsername(String username) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_USER_BY_USERNAME);
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
