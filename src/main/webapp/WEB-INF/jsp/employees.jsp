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
    <title>Employee Table</title>
</head>
<body>
<table>
    <h1>Employees Table</h1>
    <p><a href="add">Add new employee</a></p>
    <tr>
        <td>ID</td>
        <td>NAME</td>
        <td>SURNAME</td>
        <td>SALARY</td>
        <td>ACTION</td>
        <td>ACTION byName</td>
    </tr>
    <c:forEach items="${employees}" var="employee">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.name}</td>
            <td>${employee.surname}</td>
            <td>${employee.salary}</td>
            <td><a href="/employees/${employee.id}">View</a></td>
            <td><a href="/employees/name/${employee.name}">ViewbyName</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
