package web.servlet.user;


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
import java.util.Optional;


@WebServlet(value = "/reg")
public class RegistrationServlet extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/reg.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Optional<User> byUsername = userService.findByUser(username);
        if (byUsername.isEmpty() && (UserValidator.isValidUsername(Objects.requireNonNull(username)) && UserValidator.isValidPassword(Objects.requireNonNull(password)))) {
            userService.create(new User(name, username, password));
            resp.sendRedirect("/auth");
            return;
        } else {
            req.setAttribute("message", "Registration failed. Check the correctness of the entered data!");
        }
        getServletContext().getRequestDispatcher("/reg.jsp").forward(req, resp);

    }

}
