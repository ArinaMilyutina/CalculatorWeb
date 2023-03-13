package web.servlet.operation;

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
    private final CalculatorService calculatorService = new CalculatorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Operation> operationList = calculatorService.findAll();
        req.setAttribute("operations", operationList);
        getServletContext().getRequestDispatcher("/historyOperations.jsp").forward(req, resp);
    }


}


