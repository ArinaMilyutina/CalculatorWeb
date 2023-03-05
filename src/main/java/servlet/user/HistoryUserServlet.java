package servlet.user;

import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/historyUser")
public class HistoryUserServlet extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> allUsers = userService.findAll();
        if (allUsers.isEmpty()) {
            resp.getWriter().println("User is empty");
        } else {
            allUsers.forEach(resp.getWriter()::println);
        }
    }
}
