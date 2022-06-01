package Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "for7task2", value = "/for7task2")
public class for7task2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int numberpoluchaem = (int)request.getAttribute("first");
        numberpoluchaem=numberpoluchaem+10;
        request.setAttribute("second", numberpoluchaem);
    }

}
