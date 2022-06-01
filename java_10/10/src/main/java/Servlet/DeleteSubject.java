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

@WebServlet(name = "DeleteSubject", value = "/DeleteSubject")
public class DeleteSubject extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String name = request.getParameter("namedelet");
        if (name.isEmpty() ) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/welcome.jsp");
            requestDispatcher.forward(request, response);
        } else {
            try {
                DBConnection dataBaseHandler = new DBConnection();
                if (dataBaseHandler.Remove(name)) {
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/welcome.jsp");
                    requestDispatcher.forward(request, response);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/welcome.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
