package servlet.user;


import entity.User;
import service.UserService;
import validator.UserValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;


@WebServlet(name = "Reg", value = "/reg")
public class RegistrationServlet extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (name != null | username != null | password != null && UserValidator.isValidUsername(Objects.requireNonNull(username)) && UserValidator.isValidPassword(Objects.requireNonNull(password))) {
            User user = new User();
            user.setName(name);
            user.setUsername(username);
            user.setPassword(password);
            userService.create(user);
            resp.getWriter().println("Registration is completed.");
        } else {
            resp.getWriter().println("Registration failed. Check the correctness of the entered data!");
        }
    }
}