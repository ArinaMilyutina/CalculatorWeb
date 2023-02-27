package entity;

public class Operation {
    private double num1;
    private double num2;
    private double result;
    private String type;
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public Operation(double num1, double num2, String type) {
        this.num1 = num1;
        this.num2 = num2;
        this.type = type;
    }

    public Operation(int id, double num1, double num2, double result, String type) {
        this.num1 = num1;
        this.num2 = num2;
        this.result = result;
        this.type = type;
        this.id = id;
    }

    public Operation(double num1, double num2, double result, String type) {
        this.num1 = num1;
        this.num2 = num2;
        this.result = result;
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

    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public void setResult(double result) {
        this.result = result;
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