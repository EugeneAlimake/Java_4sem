<%--
  Created by IntelliJ IDEA.
  User: thesi
  Date: 21.05.2022
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="styles/form-style.css">
</head>
<body>
<jsp:include page="header.jsp" />
<center>
    <div>
        <h3>${result}</h3><br>
        <div class="form">
            <h1>Вход в систему</h1>
            <form method="post" action="auth">
                <input name="login" type="text" placeholder="Username"><br>
                <input name="password" type="password" placeholder="Password"><br>
                <input class="button" type="submit" value="Войти">
                <a href="registr.jsp" >Регистрация </a>
            </form>

        </div>
    </div>
</center>
<jsp:include page="footer.jsp" />
</body>
</html>
