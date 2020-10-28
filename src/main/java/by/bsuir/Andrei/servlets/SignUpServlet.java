package by.bsuir.Andrei.servlets;

import by.bsuir.Andrei.repository.UserRepository;
import by.bsuir.Andrei.repository.UserRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.time.LocalDate;

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {
    private UserRepository userRepositoryImpl;

    @Override
    public void init() {
        userRepositoryImpl = new UserRepositoryImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/jsp/signUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        LocalDate birthDate = LocalDate.parse(req.getParameter("birthDate"));

        boolean busyName = false;
        try {
           busyName = userRepositoryImpl.isNameTaken(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (!busyName) {
            try {
                userRepositoryImpl.save(name, password, birthDate);
                PrintWriter printWriter = resp.getWriter();
                printWriter.write("Congratulations! You just signed up");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            PrintWriter printWriter = resp.getWriter();
            printWriter.write("Already taken. Try to set another name");
        }
    }
}
