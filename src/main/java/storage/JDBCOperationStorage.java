package storage;

import entity.Operation;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCOperationStorage implements OperationStorage {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String PASSWORD = "arinemiller22";
    private static final String USERNAME = "postgres";

    @Override
    public void add(Operation operation) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(" insert into operations values (default,?,?,?,?)");
            preparedStatement.setDouble(1, operation.getNum1());
            preparedStatement.setDouble(2, operation.getNum2());
            preparedStatement.setDouble(3, operation.getResult());
            preparedStatement.setString(4, operation.getType());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

    }

    @Override
    public Optional<Operation> findByOperation(String type) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(" select *from operations where type=?");
            preparedStatement.setString(1, type);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int id = resultSet.getInt(1);
            Double num1 = resultSet.getDouble(2);
            Double num2 = resultSet.getDouble(3);
            Double result = resultSet.getDouble(4);
            Operation operation = new Operation(id, num1, num2, result, type);
            return Optional.of(operation);
        } catch (SQLException e) {

        }
        return Optional.empty();
    }

    @Override
    public void deleteOperation(String type) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from operations where type=?");
            preparedStatement.setString(1, type);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Operation> findAll() {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(" select *from operations");
            List<Operation> operationList = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                double num1 = resultSet.getDouble("num1");
                double num2 = resultSet.getDouble("num2");
                double result = resultSet.getDouble("result");
                String type = resultSet.getString("type");
                Operation operation = new Operation(id, num1, num2, result, type);
                operationList.add(operation);
            }
            return operationList;

        } catch (SQLException e) {

        }
        return new ArrayList<>();

    }

    @Override
    public void removeStorage() {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement("truncate table operations");
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Optional<Operation> findOperationByUsername(String username) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement("select num1,num2,result,type from operations,users where username=?");
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            double num1 = resultSet.getDouble("num1");
            double num2 = resultSet.getDouble("num2");
            double result = resultSet.getDouble("result");
            String type = resultSet.getString("type");
            Operation operation = new Operation(num1, num2, result, type);
            return Optional.of(operation);

        } catch (SQLException e) {

        }
        return Optional.empty();
    }
}
