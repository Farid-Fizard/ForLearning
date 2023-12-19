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
    <title>Room Details</title>
</head>
<body>
<c:choose>
    <c:when test="${not empty room}">
        <h1>Room Info</h1>
        Id:${room.id} <br>
        Name:${room.name}<br>
        Capacity:${room.capacity}<br>
        Projector:${room.projector}<br>
        Whiteboard:${room.whiteboard}<br>
    </c:when>
    <c:otherwise>
        <h2>Room not found !</h2>
    </c:otherwise>
</c:choose>


</body>
</html>
