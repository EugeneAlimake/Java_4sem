package Servlet;
import User.nation;
import db.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "Welcome", value = "/welc")
public class Welcome extends HttpServlet {
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        try {

            DBConnection dataBaseHandler = new DBConnection();
            ArrayList<nation> nations = dataBaseHandler.GetAllNations();
            req.setAttribute("nations",nations);

            getServletContext().getRequestDispatcher("/welcome.jsp").forward(req,resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
