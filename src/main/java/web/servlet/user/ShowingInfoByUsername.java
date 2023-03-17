package web.servlet.user;

import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/showingUser")
public class ShowingInfoByUsername extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        Optional<User> user = UserService.getInstance().findByUser(username);
        if (user.isPresent()) {
            resp.getWriter().println(user.get());
        } else {
            resp.getWriter().println("User not found.");
        }
    }
}
