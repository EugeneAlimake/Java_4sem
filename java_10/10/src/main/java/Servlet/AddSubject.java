package Servlet;
import  User.nation;
import  User.Users;
import db.DBConnection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddSubject", value = "/AddSubject")
public class AddSubject extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String country = request.getParameter("country");

        if (name.isEmpty() || country.isEmpty()) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/welcome.jsp");
            requestDispatcher.forward(request, response);
        } else {
            try {
                nation newnat = new nation(name, country);
                DBConnection dataBaseHandler = new DBConnection();
                nation newforcheack= new nation();
                newforcheack = dataBaseHandler.GetByname(name);
                if (newforcheack != null) {
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/welcome.jsp");
                    requestDispatcher.forward(request, response);
                } else {
                    try {
                            dataBaseHandler.AddNations(newnat);


                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/welcome.jsp");
                    requestDispatcher.forward(request, response);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}