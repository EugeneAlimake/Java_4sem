<%--
  Created by IntelliJ IDEA.
  User: thesi
  Date: 27.05.2022
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="MyTag" uri="MyTag.tld" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"
           prefix="fn" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <h2>Пользовательские теги</h2>
    <MyTag:vsubmit/>
    <c:set var = "items" value = "${items}"/>
    <c:set var = "iter" value = "${items.iterator()}"/>
    <MyTag:table nameTable="Продукты" countItem="${fn:length(items)}">
        <c:out value="${iter.next()}"/>
    </MyTag:table>
</div>
</body>
</html>
