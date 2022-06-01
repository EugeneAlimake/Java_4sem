<%--
  Created by IntelliJ IDEA.
  User: thesi
  Date: 21.05.2022
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:include page="header.jsp" />
<h3 style="color: red">${AddErrorMessage}</h3>
<c:if test="${nations == null}">
    <c:redirect url="/SubjectServlet"/>
</c:if>
<form>
    <a href="registr.jsp">Регистрация</a>
    <a href="login.jsp">Авторизация</a>
</form>
<center>
    <div1 >
        <table border="2" cellpadding="4">
            <tr>
                <th> Название семьи </th>
                <th> Численость в мире, млн чел </th>
            </tr>
            <c:forEach var="nation" items="${nations}">
                <tr>
                    <td>${nation.getName()}</td>
                    <td>${nation.getNumber()}</td>
                </tr>
            </c:forEach>
            <br>
        </table>
    </div1>
    <fieldset>
        <legend>add</legend>
            <form action="AddSubject" method="post" >
                <h3>Название народа:</h3>
                <input type="text" name="name"/>
                <h3>Численность в миллионах:</h3>
                <input type="text" name="country"/>
                <br/><br/>
                <input type="submit" value="Добавить" ><br/>
            </form>
    </fieldset>
        <fieldset>
            <legend>delete</legend>
            <form action="DeleteSubject" method="post" >
                <h3>Удалить по названию:</h3>
                <input type="text" name="namedelet"/>
                <input type="submit" value="Удалить" ><br/>
            </form>
        </fieldset>

    <fieldset>
        <legend>update</legend>
        <form action="UpdateSubject" method="POST">
            <h3>Название народа:</h3>
            <input name="name" type="text"/> <br/>
            <h3>Измените его численность:</h3>
            <input name="country" type="text" />
            <br/><br/>
            <input type="submit" value="Update"/>
        </form>
    </fieldset>
</center>
<jsp:include page="footer.jsp" />
</body>
</html>
