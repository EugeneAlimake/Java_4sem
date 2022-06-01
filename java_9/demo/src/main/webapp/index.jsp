<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<div class="horizontal">

    <form action="Time" method="get">
        <input type="submit" value="Получить информацию">
    </form>

</div>
<a href="cookies">Получить куки</a>

<h3>${result}</h3><br>
<div class="form">
    <h1>Вход в систему</h1>
    <form method="post" action="auth">
        <input name="login" type="text" placeholder="Username"><br>
        <input name="password" type="password" placeholder="Password"><br>
        <input class="button" type="submit" value="Войти">
    </form>
</div>
<a href="registr.jsp">Зарегистрироваться</a>
<form action="FirstServlet" method="get">
    <input type="submit" value="GET" />
</form>
<form action="FirstServlet" method="post">
    <input type="submit" value="POST" />
</form>
<form action="for7task" method="get">
    <input type="submit" value="7 задание" />
</form>
<form action="for8task" method="get">
    <input type="submit" value="8 задание" />
</form>
</body>
</html>