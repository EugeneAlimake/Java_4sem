package Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;


@WebServlet(name = "SecondServletPost", urlPatterns = "/SecondServletPost")
public class SecondServletPost extends HttpServlet {
    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        String name = request.getAttribute("Name").toString();
        out.println("<h4>Текущее время"+ LocalTime.now()+"</h4>");
        out.println("<h1>"+ name+"</h1>");

    }
    protected  void  doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

    }

}