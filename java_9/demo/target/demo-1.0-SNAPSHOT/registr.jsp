<%--
  Created by IntelliJ IDEA.
  User: thesi
  Date: 15.05.2022
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <title>Зарегистрируйтесь</title>
</head>
<body>
<h3>${result}</h3><br>
<div class="form">
    <h1>Зарегистрироваться</h1>
    <form method="post" action="registr">
        <input name="login" type="text" placeholder="Username"><br>
        <input name="password" type="password" placeholder="Password"><br>
        <input class="button" type="submit" value="Зарегистрироваться">
    </form>
</div>


</body>
</html>