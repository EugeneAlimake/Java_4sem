package Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "for7task", value = "/for7task")
public class for7task extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        int numberperedaem = 2;
        request.setAttribute("first", numberperedaem);
        request.getRequestDispatcher("/for7task2").include(request, response);
        int numberpoluchily = (int) request.getAttribute("second");
        PrintWriter pw = response.getWriter();
        pw.println("<html><body>");
        pw.println("<h4> Мы получаем число:" + numberpoluchily + "</h4>");
        pw.println("</body></html>");
        pw.close();
    }
}