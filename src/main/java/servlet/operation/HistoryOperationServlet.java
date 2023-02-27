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

@WebServlet("/historyOperation")
public class HistoryOperationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Operation> operationList = CalculatorService.findAll();
        if (operationList.isEmpty()) {
            resp.getWriter().println("Operation not found.");
        } else {
            operationList.forEach(resp.getWriter()::println);
        }

    }
}
