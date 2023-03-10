package entity;

public class Operation {
    private double num1;
    private double num2;
    private double result;
    private Type type;
    private int id;

    public enum Type {
        sum,
        mul,
        res,
        div
    }

    public void setId(int id) {
        this.id = id;
    }

    public Operation(double num1, double num2, Type type) {
        this.num1 = num1;
        this.num2 = num2;
        this.type = type;
    }


    public Operation(int id, double num1, double num2, double result, Type type) {
        this.num1 = num1;
        this.num2 = num2;
        this.result = result;
        this.type = type;
        this.id = id;
    }


    public Operation() {
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }

    public double getResult() {
        return result;
    }

    public int getId() {
        return id;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "num1=" + num1 +
                ", num2=" + num2 +
                ", result=" + result +
                ", type='" + type + '\'' +
                ", id=" + id +
                '}';
    }
}