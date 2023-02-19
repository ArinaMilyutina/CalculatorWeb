
package servlet.user;


import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;


@WebServlet("/auth")
public class AuthorizationServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Optional<User> byUsername = userService.findByUsername(username);
        if (byUsername.isPresent()) {
            User user = byUsername.get();
            if (user.getPassword().equals(password)) {
                req.getSession().setAttribute("currentUser", user);
            } else {
                resp.getWriter().println("Wrong password!");
            }
        } else {
            resp.getWriter().println("User not found!");
        }
    }
}
