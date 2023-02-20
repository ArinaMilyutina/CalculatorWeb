package service;

import entity.Operation;
import storage.JDBCOperationStorage;
import storage.OperationStorage;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class CalculatorService {
    private static final OperationStorage operationStorage = new JDBCOperationStorage();

    public Optional<Operation> calculate(Operation operation) {

        switch (operation.getType()) {
            case "sum" -> {
                operation.setResult(sum(operation.getNum1(), operation.getNum2()));
                operationStorage.add(operation);
                return Optional.of(operation);
            }
            case "div" -> {
                operation.setResult(div(operation.getNum1(), operation.getNum2()));
                operationStorage.add(operation);
                return Optional.of(operation);
            }
            case "mul" -> {
                operation.setResult(mul(operation.getNum1(), operation.getNum2()));
                operationStorage.add(operation);
                return Optional.of(operation);
            }
            case "res" -> {
                operation.setResult(res(operation.getNum1(), operation.getNum2()));
                operationStorage.add(operation);
                return Optional.of(operation);
            }
        }
        return Optional.empty();

    }

    private double sum(double a, double b) {
        return a + b;
    }


    private double res(double a, double b) {
        return a - b;
    }


    private double div(double a, double b) {
        return a / b;
    }


    private double mul(double a, double b) {
        return a * b;
    }

    public static List<Operation> findAll() {
        return operationStorage.findAll();
    }

    public static Optional<Operation> findByType(String type) {
        return operationStorage.findByOperation(type);
    }

    public static List<Operation> deleteOperation(String type) {
        operationStorage.deleteOperation(type);
        return new ArrayList<>();
    }

    public static void deleteHistory() {
        operationStorage.removeStorage();
    }
}