<%--
  Created by IntelliJ IDEA.
  User: thesi
  Date: 15.05.2022
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>${result}</h3><br>
<div class="form">
    <h1>Вход в систему</h1>
    <form method="post" action="auth">
        <input name="login" type="text" placeholder="Username"><br>
        <input name="password" type="password" placeholder="Password"><br>
        <input class="button" type="submit" value="Войти">
    </form>
</div>
</body>
</html>
