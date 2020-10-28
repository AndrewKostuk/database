package by.bsuir.Andrei.servlets;

import by.bsuir.Andrei.repository.PurchaseRepository;
import by.bsuir.Andrei.repository.PurchaseRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    private PurchaseRepository purchaseRepositoryImpl;

    @Override
    public void init() throws ServletException {
        purchaseRepositoryImpl = new PurchaseRepositoryImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/jsp/order.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String color = req.getParameter("color");
        int cost = Integer.parseInt(req.getParameter("cost"));
        String userName = (String)req.getSession().getAttribute("name");

        try {
            purchaseRepositoryImpl.save(name, color, cost, userName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getServletContext().getRequestDispatcher("/jsp/order.jsp").forward(req, resp);
    }
}
