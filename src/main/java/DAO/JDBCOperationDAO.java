package DAO;

import entity.Operation;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class JDBCOperationDAO extends AbstractDAO implements OperationDAO {
    private static final String INSERT_OPERATIONS = " insert into operations values (default,?,?,?,?)";
    private static final String FIND_OPERATIONS_BY_TYPE = "select *from operations where type=?";
    private static final String DELETE_BY_TYPE = "delete from operations where type=?";
    private static final String SELECT_OPERATIONS = "select *from operations";
    private static final String DELETE_OPERATIONS = "truncate table operations";
    private static JDBCOperationDAO INSTANCE;

    private JDBCOperationDAO() {

    }

    public static JDBCOperationDAO getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new JDBCOperationDAO();
        }
        return INSTANCE;
    }

    @Override
    public void add(Operation operation) {
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(INSERT_OPERATIONS);
            preparedStatement.setDouble(1, operation.getNum1());
            preparedStatement.setDouble(2, operation.getNum2());
            preparedStatement.setDouble(3, operation.getResult());
            preparedStatement.setString(4, operation.getType().name());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

    }

    @Override
    public List<Operation> findByOperation(String type) {
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(FIND_OPERATIONS_BY_TYPE);
            return getOperations(type, preparedStatement);
        } catch (SQLException ignored) {

        }
        return new ArrayList<>();
    }

    private List<Operation> getOperations(String type, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, type);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Operation> operations = new ArrayList<>();
        while (resultSet.next()) {
            Operation operation = new Operation();
            operation.setId(resultSet.getInt("id"));
            operation.setNum1(resultSet.getDouble("num1"));
            operation.setNum2(resultSet.getDouble("num2"));
            operation.setResult(resultSet.getDouble("result"));
            operation.setType(Operation.Type.valueOf(resultSet.getString("type")));
            operations.add(operation);
        }
        return operations;
    }

    @Override
    public void deleteOperation(String type) {
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(DELETE_BY_TYPE);
            preparedStatement.setString(1, type);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Operation> findAll() {
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_OPERATIONS);
            List<Operation> operationList = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                double num1 = resultSet.getDouble("num1");
                double num2 = resultSet.getDouble("num2");
                double result = resultSet.getDouble("result");
                String type = resultSet.getString("type");
                Operation operation = new Operation(id, num1, num2, result, Operation.Type.valueOf(type));
                operationList.add(operation);
            }
            return operationList;

        } catch (SQLException ignored) {

        }
        return new ArrayList<>();

    }

    @Override
    public void removeStorage() {
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(DELETE_OPERATIONS);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}