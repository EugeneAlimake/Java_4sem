package Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;



@WebServlet(name = "Help", urlPatterns = "/Help")
public class Help extends HttpServlet {
    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    //  response.sendRedirect("registr.jsp");
    }
    protected  void  doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.sendRedirect("registr.jsp");
       // request.getRequestDispatcher("registr.jsp").forward(request,response);//переопределение
    }
}
