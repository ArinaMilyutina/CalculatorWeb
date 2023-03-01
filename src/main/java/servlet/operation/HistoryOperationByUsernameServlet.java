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

@WebServlet("/historyOperationByUsername")
public class HistoryOperationByUsernameServlet extends HttpServlet {
    private final CalculatorService calculatorService = new CalculatorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        List<Operation> operation = calculatorService.findOperationByUsername(username);
        if (operation.isEmpty()) {
            operation.forEach(resp.getWriter()::println);
        } else {
            resp.getWriter().println("Operation not found");
        }

    }
}
