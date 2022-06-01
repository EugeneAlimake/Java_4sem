package MyTag;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "First", value = "/First")
public class First extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Яблоко");
        strings.add("Груша");
        request.setAttribute("items", strings);

        getServletContext().getRequestDispatcher("/first.jsp").forward(request, response);
    }
}