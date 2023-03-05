package servlet.operation;


import entity.Operation;
import service.CalculatorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "Calculator", value = "/calc")
public class CalculatorServlet extends HttpServlet {

    private final CalculatorService calculatorService = new CalculatorService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num1 = request.getParameter("num1");
        String num2 = request.getParameter("num2");
        String type = request.getParameter("type");
        double a = Double.parseDouble(num1);
        double b = Double.parseDouble(num2);

        Optional<Operation> calculate = calculatorService.calculate(new Operation(a, b, Operation.Type.valueOf(type)));

        if (calculate.isPresent()) {
            Operation operation = calculate.get();
            response.getWriter().println("Result = " + operation.getResult());
        } else {
            response.getWriter().println("Operation not found!");
        }
    }


}