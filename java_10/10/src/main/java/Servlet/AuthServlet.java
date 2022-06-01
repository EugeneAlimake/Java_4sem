package Servlet;

import User.Users;
import db.DBConnection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import static java.util.Objects.nonNull;

@WebServlet(name = "AuthServlet", value = "/auth")
public class AuthServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, ServletException, IOException {
        DBConnection dataBase = new DBConnection();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String hashPassword = null;
        if (nonNull(password)) {
            hashPassword = DigestUtils.md5Hex(password);
        }
        if (login==null  || password==null) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(req, res);
        }
        if (login.isEmpty()  || password.isEmpty()) {
            req.setAttribute("result", "Поля не заполнены");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(req, res);
        }
        String role = null;

        Users user = null;
        try {
            user = dataBase.GetByUsername(login, password);

        } catch (SQLException throwables) {
            req.setAttribute("result", "SQL Error");
        }
        if (user != null) {
            role = user.getRole();
            if (!user.getPassword().equals(password)) {
                req.setAttribute("result", "Ошибка при вводе данных");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
                requestDispatcher.forward(req, res);
            }
            else if(role.equals("user")){
                HttpSession session = req.getSession();
                Cookie cookie = new Cookie(user.getUsername(), user.getRole()+" "+new Date(session.getLastAccessedTime())+" "+new Date(session.getCreationTime()));
                res.addCookie(cookie);
                req.setAttribute("result", user.getUsername());
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/welcome.jsp");
                requestDispatcher.forward(req, res);
            }
            else if(role.equals("admin")){
                HttpSession session = req.getSession();
                Cookie cookie = new Cookie(user.getUsername(), user.getRole()+" "+new Date(session.getLastAccessedTime())+" "+new Date(session.getCreationTime()));
                res.addCookie(cookie);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/welcome.jsp");
                requestDispatcher.forward(req, res);
            }

        }
        else  { RequestDispatcher requestDispatcher = req.getRequestDispatcher("registr.jsp");
            requestDispatcher.forward(req, res);}

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final HttpSession session = request.getSession();

        session.removeAttribute("login");
        session.removeAttribute("password");
        session.removeAttribute("role");

        response.sendRedirect("auth");
        /*        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request,response);*/
    }
}