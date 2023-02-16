package service;

import entity.Operation;


import java.util.Optional;


public class CalculatorService {
    public Optional<Operation> calculate(Operation operation) {

        switch (operation.getType()) {
            case "sum" -> {
                operation.setResult(sum(operation.getNum1(), operation.getNum2()));
                return Optional.of(operation);
            }
            case "div" -> {
                operation.setResult(div(operation.getNum1(), operation.getNum2()));
                return Optional.of(operation);
            }
            case "mul" -> {
                operation.setResult(mul(operation.getNum1(), operation.getNum2()));
                return Optional.of(operation);
            }
            case "res" -> {
                operation.setResult(res(operation.getNum1(), operation.getNum2()));
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

}