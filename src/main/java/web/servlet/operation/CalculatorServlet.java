package web.servlet.operation;


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
        getServletContext().getRequestDispatcher("/calculator.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num1 = request.getParameter("num1");
        String num2 = request.getParameter("num2");
        String type = request.getParameter("type");

        Optional<Operation> result = getResult(num1, num2, type);
        if (result.isPresent()) {
            response.getWriter().println(result.get());
        }
        if (result.isEmpty() || num1 == null || num2 == null || type == null) {
            response.getWriter().println("Check the input data!!!");
        }
        request.setAttribute("num1", num1);
        request.setAttribute("num2", num2);
        request.setAttribute("type", type);
        request.setAttribute("result", result.get());
        getServletContext().getRequestDispatcher("/calculator.jsp").forward(request, response);
    }

    private Optional<Operation> getResult(String num1, String num2, String type) {
        Optional<Operation.Type> types = selectOperation(type);
        if (types.isPresent()) {
            Operation.Type operations = types.get();
            double a = Double.parseDouble(num1);
            double b = Double.parseDouble(num2);
            Operation operation = new Operation(a, b, operations);
            return calculatorService.calculate(operation);
        }
        return Optional.empty();
    }

    Optional<Operation.Type> selectOperation(String type) {
        switch (type) {
            case "sum" -> {
                return Optional.of(Operation.Type.sum);
            }
            case "mul" -> {
                return Optional.of(Operation.Type.mul);
            }
            case "div" -> {
                return Optional.of(Operation.Type.div);
            }
            case "res" -> {
                return Optional.of(Operation.Type.res);
            }
        }
        return Optional.empty();
    }


}