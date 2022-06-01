package filter;
import User.Users;
import db.DBConnection;
import jakarta.servlet.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import static java.util.Objects.nonNull;
public class AuthFilter implements Filter  {
    private FilterConfig filterConfig;
    private String indexPath;
    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        filterConfig = fConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

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
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("user_menu.jsp");
                requestDispatcher.forward(req, res);
            }
            else if(role.equals("admin")){
                HttpSession session = req.getSession();
                Cookie cookie = new Cookie(user.getUsername(), user.getRole()+" "+new Date(session.getLastAccessedTime())+" "+new Date(session.getCreationTime()));
                res.addCookie(cookie);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("admin_menu.jsp");
                requestDispatcher.forward(req, res);
            }

        }
        else  { RequestDispatcher requestDispatcher = req.getRequestDispatcher("registr.jsp");
            requestDispatcher.forward(req, res);}
        filterChain.doFilter(servletRequest, servletResponse);
    }
    @Override
    public void destroy() {
            filterConfig = null;
    }
}
