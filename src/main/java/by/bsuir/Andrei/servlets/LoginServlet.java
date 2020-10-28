package by.bsuir.Andrei.servlets;


import by.bsuir.Andrei.repository.UserRepository;
import by.bsuir.Andrei.repository.UserRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserRepository userRepositoryImpl;

    @Override
    public void init() {
        userRepositoryImpl = new UserRepositoryImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        boolean userExist = false;
        try {
            userExist = userRepositoryImpl.isUserExist(name, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (userExist) {
            String color = req.getParameter("color");
            Cookie colorCookie = new Cookie("color", color);
            resp.addCookie(colorCookie);
            HttpSession session = req.getSession();
            session.setAttribute("name", name);
            resp.sendRedirect(req.getContextPath() + "/order");
        } else {
            doGet(req, resp);
        }
    }
}
