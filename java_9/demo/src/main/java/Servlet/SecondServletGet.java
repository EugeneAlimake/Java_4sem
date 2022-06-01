package Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.Locale;


@WebServlet(name = "SecondServletGet", urlPatterns = "/SecondServletGet")
public class SecondServletGet extends HttpServlet {

    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

    }
    protected  void  doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getAttribute("Name").toString();
 // response.setContentType("text/html; charset=UTF-8");
  //PrintWriter out = response.getWriter();
   //out.println("<h1> Текущее время:"+ LocalTime.now()+"</h1>");
     //   out.println("<h1>"+ name+"</h1>");
        request.setAttribute("Name",name);
    response.sendRedirect("Help");//переадресация

    }
}