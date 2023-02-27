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

@WebServlet("/showingOperation")
public class ShowingInfoByTypeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        Optional<Operation> operationList = CalculatorService.findByType(type);
        if (operationList.isPresent()) {
            resp.getWriter().println(operationList.get());
        } else {
            resp.getWriter().println("Operation not found");
        }
    }
}
