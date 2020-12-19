package by.teachmeskills.servlet;

import by.teachmeskills.module.User;
import by.teachmeskills.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }


    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        List<User> allUsers = UserRepository.getInstance().getAll();
        Optional<User> user = allUsers.stream().filter(u -> u.getEmail().equals(email) && u.getPassword().equals(password)).findAny();
        if (user.isPresent()) {
            req.getSession().setAttribute("email", user.get().getEmail());
            req.getSession().setAttribute("authorized", "true");
            req.getSession().setAttribute("name", user.get().getName());
            req.getSession().setAttribute("surname", user.get().getSurname());

            resp.sendRedirect("/profile");

        } else {
            req.setAttribute("login_error", "Email or password is incorrect!");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
