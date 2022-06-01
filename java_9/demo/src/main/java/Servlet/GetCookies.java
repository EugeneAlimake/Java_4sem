package Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;



@WebServlet(name = "GetCookies", value = "/cookies")
public class GetCookies extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();

        PrintWriter pw = response.getWriter();
        pw.println("<html>");
        for (Cookie cookie : cookies) {
            pw.println("<p>"+" Name user:" + cookie.getName() + "; role : " + cookie.getValue() + "</p>");
        }

        pw.println("</html>");
    }
}

