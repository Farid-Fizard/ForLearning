<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 07.07.2023
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Room</title>
</head>
<body>
<h1>Add New Room</h1>
<form method="post" action="/rooms/add">
    Name: <input type="text" name="name"> </br>
    Capacity: <input type="number" name="capacity"> </br>
    Projector: <input type="radio" name="projector" value="1">Yes &nbsp;
    <input type="radio" name="projector" value="0">No &nbsp; </br>
    Whiteboard: <input type="radio" name="whiteboard" value="1">Yes &nbsp;
    <input type="radio" name="whiteboard" value="0">No&nbsp; </br>
    <input type="submit" value="Save"> &nbsp; <input type="reset" value="Clear">
</form>
</body>
</html>
