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
    <title>Room Table</title>
    <style>
        table,tr,th,td{
            border: 1px solid black ;
        }
    </style>
</head>
<body>
<table>
    <h1>Room Table</h1>
    <p><a href="add">Add new room</a></p>

    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Capacity</th>
        <th>Projector</th>
        <th>Whiteboard</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${rooms}" var="room">
        <tr>
            <td>${room.id}</td>
            <td>${room.name}</td>
            <td>${room.capacity}</td>
            <td>${room.projector}</td>>
            <td>${room.whiteboard}</td>>
            <td><a href="/rooms/${room.id}">View</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
