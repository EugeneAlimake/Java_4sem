<%--
  Created by IntelliJ IDEA.
  User: thesi
  Date: 27.05.2022
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Formatting</title>
</head>
<body>
<h4>Работа с датами</h4>
<jsp:useBean id="now" class="java.util.Date" />
<fmt:setLocale value="en-EN"/>
Вывод даты в формате English<br/>
Сегодня: <fmt:formatDate value="${now}" /><br/>
<fmt:setLocale value="ru-RU"/>
<fmt:timeZone value="GMT+4:00">
Вывод даты в формате Russian<br/>
Сегодня: <fmt:formatDate value="${now}"  type="both"
                         dateStyle="full" timeStyle="full"/> /><br/>
</fmt:timeZone>
Стиль времени:
(short): <fmt:formatDate value="${now}"
                         type="time" timeStyle="short" /><br/>
(medium):<fmt:formatDate value="${now}"
                         type="time" timeStyle="medium" /><br/>
(long): <fmt:formatDate value="${now}"
                        type="time" timeStyle="long" /><br/><br/>
<h4>Перевод чисел</h4>
<c:set var="currentNumber" value="554"/>
<c:out value="Вывод формата числа : ${currentNumber}"/> <br/>
Формат (по умолчанию) :
<fmt:formatNumber value="${currentNumber}" /><br/>
Процентный формат :
<fmt:formatNumber value="${currentNumber}"
                  type="percent"/><br/>
<fmt:setLocale value="be-BY"/>
Белорусские рубли :
<fmt:formatNumber value="${currentNumber}"
                  type="currency"/><br/>
Французская валюта :
<fmt:setLocale value="fr-FR"/>
<fmt:formatNumber value= "${currentNumber}" type="currency"/><br/>
<c:set var="currentDate" value="28-12-2012" />
<fmt:parseDate value="${currentDate}" var="parsedCurrentDate" pattern="dd-MM-yyyy" />
<p>Current date after parsing: <c:out value="${parsedCurrentDate}" /></p>
</body>
</html>

