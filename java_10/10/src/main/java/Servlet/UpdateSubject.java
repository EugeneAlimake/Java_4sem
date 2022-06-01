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

@WebServlet(name = "UpdateSubject", value = "/UpdateSubject")
public class UpdateSubject extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String country = request.getParameter("country");
        nation nationup = new nation(name, country);

            DBConnection dataBaseHandler = new DBConnection();
        try {
            dataBaseHandler.Update(name, country);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/welcome.jsp").forward(request, response);

    }
}
