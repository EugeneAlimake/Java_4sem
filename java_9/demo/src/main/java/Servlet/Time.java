package Servlet;

import java.io.*;
import java.time.LocalTime;
import java.util.Enumeration;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "Time", value = "/Time")
public class Time extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = response.getWriter();
        try {
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<title>FirstServlet</title>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<h1>Текущее время " + LocalTime.now() + "</h1>");
            writer.println("<p>Версия и номер протокола " + "<b>" + request.getProtocol() + "</b>" + "</p>");
            writer.println("<p >IP-адреса клиента, от имени которого пришел запрос и его имя " + "<b>" + request.getRemoteAddr() + "  " + request.getRemoteUser() + "</b>" + "</p>");
            writer.println("<p >Имя метода доступа к ресурсам, на основе которого построен запрос " + "<b>" + request.getMethod() + "</b>" + "</p>");
            writer.println("<p >URL-адрес, который клиент использовал для выполнения запроса " + "<b>" + request.getRequestURL() + "</b>" + "</p>");
            writer.println("<p >часть URL-адреса этого запроса, которая вызывает сервлет " + "<b>" + request.getServletPath() + "</b>" + "</p>");
            writer.println("<p >Возвращает любую дополнительную информацию о пути, связанную с URL-адрес, который клиент отправил при выполнении этого запроса " + "<b>" + request.getPathInfo() + "</b>" + "</p>");
            writer.println("<p >Информация о заголовках");
            Enumeration<String> headerNames = request.getHeaderNames();
            while(headerNames.hasMoreElements()){
                String name = headerNames.nextElement();
                String headerValues = request.getHeader(name);
                writer.println(name + ":  " + headerValues);
            }
            writer.println("</p>");
            writer.println("</br><a href='/demo-1.0-SNAPSHOT'>Вернуться</a>");
            writer.println("</body>");
            writer.println("</html>");
        } finally {
            writer.close();
        }

    }
}