package service;

import entity.Operation;
import storage.JDBCOperationStorage;
import storage.OperationStorage;


import java.util.List;
import java.util.Optional;


public class CalculatorService extends Calculator {
    private final OperationStorage operationStorage = new JDBCOperationStorage();

    public Optional<Operation> calculate(Operation operation) {

        switch (operation.getType()) {
            case sum -> {
                operation.setResult(sum(operation.getNum1(), operation.getNum2()));
                operationStorage.add(operation);
                return Optional.of(operation);
            }
            case div -> {
                operation.setResult(div(operation.getNum1(), operation.getNum2()));
                operationStorage.add(operation);
                return Optional.of(operation);
            }
            case mul -> {
                operation.setResult(mul(operation.getNum1(), operation.getNum2()));
                operationStorage.add(operation);
                return Optional.of(operation);
            }
            case res -> {
                operation.setResult(res(operation.getNum1(), operation.getNum2()));
                operationStorage.add(operation);
                return Optional.of(operation);
            }
        }
        return Optional.empty();

    }

    public List<Operation> findAll() {
        return operationStorage.findAll();
    }

    public List<Operation> findByType(String type) {
        return operationStorage.findByOperation(type);
    }

    public void deleteOperation(Operation.Type type) {
        operationStorage.deleteOperation(String.valueOf(type));
    }

    public void deleteHistory() {
        operationStorage.removeStorage();
    }

}