//package servlet.operation;
//
//import entity.Operation;
//import entity.User;
//import service.CalculatorService;
//import service.UserService;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet("/findByTypeOperation")
//public class FindByTypeOperationServlet extends HttpServlet {
//    private final CalculatorService calculatorService = new CalculatorService();
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        getServletContext().getRequestDispatcher("/findByTypeOperation.jsp").forward(req, resp);
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String type = req.getParameter("type");
////        List<Operation> operationList = calculatorService.findByType(type);
//////        if (operationList.isEmpty()) {
//////            getServletContext().getRequestDispatcher("/findByTypeOperation.jsp").forward(req, resp);
//////
//////        } else {
//////            if (operationList.isEmpty()) {
//////                resp.getWriter().println("Operation not found");
//////
//////            } else {
//////                operationList.forEach(resp.getWriter()::println);
//////            }
//            req.setAttribute("type",type);
//            getServletContext().getRequestDispatcher("/findByTypeOperation.jsp").forward(req, resp);
//        }
//
//
//    }
//
