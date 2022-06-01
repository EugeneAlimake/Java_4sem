<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: thesi
  Date: 15.05.2022
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>USER</title>
</head>
<body>
<h1>Hello USER</h1>
<h3>${result}</h3><br>
<p>
<%Date date = new Date();%>
<%= date %>
</p>
<a href="auth">Вернуться</a>
</body>
</html>

</body>
</html>
