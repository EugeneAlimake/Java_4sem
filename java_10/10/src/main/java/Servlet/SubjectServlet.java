package Servlet;

import User.Users;
import User.nation;
import db.DBConnection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "SubjectServlet", value = "/SubjectServlet")
public class SubjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBConnection dataBaseHandler = new DBConnection();
        ArrayList<nation> nations = null;
        try {
            nations = dataBaseHandler.GetAllNations();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        req.setAttribute("nations",nations);
        getServletContext().getRequestDispatcher("/welcome.jsp").forward(req,resp);
    }
}
