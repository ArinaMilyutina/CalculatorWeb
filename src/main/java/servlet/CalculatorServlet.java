package servlet;


import entity.Operation;
import entity.User;
import service.CalculatorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "Calc", value = "/calc")
public class CalculatorServlet extends HttpServlet {

    private final CalculatorService calculatorService = new CalculatorService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().setAttribute("myName", "Test");
        request.getSession().setAttribute("myName", "Test");
        request.setAttribute("myName", "Test");
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        response.getWriter().println(String.format("Hello %s!", currentUser.getName()));
        String num1 = request.getParameter("num1");
        String num2 = request.getParameter("num2");
        String type = request.getParameter("type");
        double a = Double.parseDouble(num1);
        double b = Double.parseDouble(num2);

        Optional<Operation> calculate = calculatorService.calculate(new Operation(a, b, type));

        if (calculate.isPresent()) {
            Operation operation = calculate.get();
            response.getWriter().println("Result = " + operation.getResult());
        } else {
            response.getWriter().println("Operation not found!");
        }
    }


}