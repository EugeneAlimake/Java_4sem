<%@ taglib prefix="MyTag" uri="MyTag.tld" %>
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
<form action="Tags/core.jsp">
    <input type="submit" value="Теги core">
</form>
<form action="Tags/formatting.jsp">
    <input type="submit" value="Теги formatting">
</form>
<form action="Tags/sql.jsp">
    <input type="submit" value="Теги sql">
</form>
<form action="Tags/xml.jsp">
    <input type="submit" value="Теги xml">
</form>
<form action="Tags/functions.jsp">
    <input type="submit" value="Теги functions">
</form>
<a href="First">First</a>

</body>
</html>