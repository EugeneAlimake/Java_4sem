<%--
  Created by IntelliJ IDEA.
  User: thesi
  Date: 27.05.2022
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sql</title>
</head>
<body>
 <sql:setDataSource var="contacts" driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"
 url="jdbc:sqlserver://DESKTOP-45NETQ3;databaseName=User;trustServerCertificate=true;encrypt=false;IntegratedSecurity=false"
                    user="sa" password="12345"/>
 <sql:query dataSource="${contacts}" var="books" >
     SELECT * FROM Users where username = ?
     <sql:param value="Alimake" />
 </sql:query>
<sql:query dataSource="${contacts}" var="contacts">
 SELECT * FROM Users
 </sql:query>
 <table border = "1" width = "100%">
     <tr>
         <th>Name</th>
         <th>Password</th>
         <th>Role</th>
     </tr>

     <c:forEach var = "row" items = "${contacts.rows}">
         <tr>
             <td> <c:out value = "${row.username}"/></td>
             <td> <c:out value = "${row.password}"/></td>
             <td> <c:out value = "${row.role}"/></td>
         </tr>
     </c:forEach>
 </table>
 <table border = "1" width = "100%">
     <tr>
         <th>Name</th>
         <th>Password</th>
         <th>Role</th>
     </tr>

     <c:forEach var = "row" items = "${books.rows}">
         <tr>
             <td> <c:out value = "${row.username}"/></td>
             <td> <c:out value = "${row.password}"/></td>
             <td> <c:out value = "${row.role}"/></td>
         </tr>
     </c:forEach>
 </table>
</body>
</html>
