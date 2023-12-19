<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 05.07.2023
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Employee Details</title>
</head>
<body>
<c:choose>
    <c:when test="${not empty employee}">
        <h1>Employee Profile</h1>
        Id:${employee.id} <br>
        Name:${employee.name}<br>
        Surname:${employee.surname}<br>
        Salary:${employee.salary}<br>
    </c:when>
    <c:otherwise>
        <h2>Employee not found !</h2>
    </c:otherwise>
</c:choose>


</body>
</html>
