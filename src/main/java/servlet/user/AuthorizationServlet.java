
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
        getServletContext().getRequestDispatcher("/authorization.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Optional<User> byUsername = userService.findByUser(username);
        if (byUsername.isPresent()) {
            User user = byUsername.get();
            if (user.getPassword().equals(password)) {
                req.getSession().setAttribute("currentUser", user);
                req.setAttribute("username", username);
                req.setAttribute("password", password);
                getServletContext().getRequestDispatcher("/authorization.jsp").forward(req, resp);
            } else {
                resp.getWriter().println("Wrong password!");
                getServletContext().getRequestDispatcher("/authorization.jsp").forward(req, resp);
            }
        } else {
            resp.getWriter().println("User not found!");
            getServletContext().getRequestDispatcher("/authorization.jsp").forward(req, resp);
        }
    }
}

