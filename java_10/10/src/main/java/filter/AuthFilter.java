package filter;
import User.Users;
import db.DBConnection;
import Servlet.Welcome;
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
    public void doFilter(ServletRequest req,
                         ServletResponse res,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);

        String loginURL = request.getContextPath() + "/auth";
        String registerURL = request.getContextPath() + "/registr";

        boolean loggedIn = session != null && session.getAttribute("user") != null;
        boolean loginRequest = request.getRequestURI().equals(loginURL) || request.getRequestURI().equals(loginURL + ".jsp");
        boolean registrRequest = request.getRequestURI().equals(registerURL) || request.getRequestURI().equals(registerURL + ".jsp");

        if(loggedIn || loginRequest || registrRequest) {
            chain.doFilter(req, res);
        }
        else {
            request.setAttribute("ErrorCode", "Ошибка авторизации");
            request.setAttribute("ErrorMessage", "Попытка войти на страницу welcome без авторизации");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
    @Override
    public void destroy() {
        filterConfig = null;
    }
}