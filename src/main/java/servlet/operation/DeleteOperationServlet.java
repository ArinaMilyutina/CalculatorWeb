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

@WebServlet("/deleteOperation")
public class DeleteOperationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        List<Operation> operationList = CalculatorService.deleteOperation(type);
        if (operationList.isEmpty()) {
            resp.getWriter().println("There is no operation.");
        } else {
            resp.getWriter().println("Operation is deleted.");
        }
    }
}
