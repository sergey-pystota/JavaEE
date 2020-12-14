package by.teachmeskills.servlet;

import by.teachmeskills.module.User;
import by.teachmeskills.repository.InDataUserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
req.getRequestDispatcher("/registration.jsp").forward(req,resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
         AtomicLong idGenerator = new AtomicLong(1);
        String password = req.getParameter("password");
        String checkPassword = req.getParameter("checkpassword");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");

        if (!password.equals(checkPassword)) {
            req.setAttribute("not_equal_passwords_error", "Password and double check password are not equal");
            req.getRequestDispatcher("/registration.jsp").forward(req, resp);


        } else {
            User user = new User();

            user.setEmail(email);
            user.setName(name);
            user.setSurname(surname);
            user.setPassword(password);
            System.out.println(user.toString());
            InDataUserRepository.getInstance().save(user);

            resp.sendRedirect("/login");

        }
    }
}
