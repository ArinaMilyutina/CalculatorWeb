package service;

import entity.Operation;
import storage.JDBCOperationStorage;
import storage.OperationStorage;


import java.util.List;
import java.util.Optional;


public class CalculatorService extends Calculator {
    private static CalculatorService INSTANCE;

    private CalculatorService() {

    }

    public static CalculatorService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CalculatorService();

        }
        return INSTANCE;
    }

    public Optional<Operation> calculate(Operation operation) {

        switch (operation.getType()) {
            case sum -> {
                operation.setResult(sum(operation.getNum1(), operation.getNum2()));
                JDBCOperationStorage.getInstance().add(operation);
                return Optional.of(operation);
            }
            case div -> {
                operation.setResult(div(operation.getNum1(), operation.getNum2()));
                JDBCOperationStorage.getInstance().add(operation);
                return Optional.of(operation);
            }
            case mul -> {
                operation.setResult(mul(operation.getNum1(), operation.getNum2()));
                JDBCOperationStorage.getInstance().add(operation);
                return Optional.of(operation);
            }
            case res -> {
                operation.setResult(res(operation.getNum1(), operation.getNum2()));
                JDBCOperationStorage.getInstance().add(operation);
                return Optional.of(operation);
            }
        }
        return Optional.empty();

    }

    public List<Operation> findAll() {
        return JDBCOperationStorage.getInstance().findAll();
    }

    public List<Operation> findByType(double num1) {
        return JDBCOperationStorage.getInstance().findByOperation(num1);
    }

    public void deleteOperation(Operation.Type type) {
        JDBCOperationStorage.getInstance().deleteOperation(String.valueOf(type));
    }

    public void deleteHistory() {
        JDBCOperationStorage.getInstance().removeStorage();
    }

}