package Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;



@WebServlet(name = "FirstServlet", urlPatterns = "/FirstServlet")
public class FirstServlet extends HttpServlet {
    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setAttribute("Name","Eugene");
        request.getRequestDispatcher("SecondServletPost").forward(request, response);
    }
    protected  void  doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setAttribute("Name","Eugene");
        request.getRequestDispatcher("SecondServletGet").forward(request, response);
    }
}
