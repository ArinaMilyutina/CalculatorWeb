package servlet.user;


import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "Reg", value = "/reg")
public class RegistrationServlet extends HttpServlet {

    private final UserService userService = new UserService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User();
        user.setName(name);
        user.setUsername(username);
        user.setPassword(password);
        userService.create(user);
        if (name == null | username == null | password == null) {
            resp.getWriter().println("Registration failed");
        } else {
            resp.getWriter().println("Registration is completed.");
        }
    }
}