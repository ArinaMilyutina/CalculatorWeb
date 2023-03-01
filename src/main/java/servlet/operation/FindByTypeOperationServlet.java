package servlet.operation;

import entity.Operation;
import service.CalculatorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/findByTypeOperation")
public class FindByTypeOperationServlet extends HttpServlet {
    private final CalculatorService calculatorService = new CalculatorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        List<Operation> operationList = calculatorService.findByType(type);
        if (operationList.isEmpty()) {
            resp.getWriter().println("Operation not found");

        } else {
            operationList.forEach(resp.getWriter()::println);
        }
    }
}
