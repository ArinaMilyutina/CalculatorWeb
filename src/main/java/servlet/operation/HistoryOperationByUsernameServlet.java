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

@WebServlet("/historyOperationByUsername")
public class HistoryOperationByUsernameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        Optional<Operation> operation = CalculatorService.findOperationByUsername(username);
        if (operation.isPresent()) {
            resp.getWriter().println(operation.get());
        } else {
            resp.getWriter().println("Operation not found");
        }

    }
}
