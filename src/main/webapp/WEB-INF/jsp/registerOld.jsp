<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 06.05.2023
  Time: 23:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Registration</title>
    <style>
        .xeta {
            color: red;
            font-size: large;
            display: block;
        }
    </style>
</head>
<body>
<h1> Zehmet olmasa formu doldurun</h1>
<%-- getde registration form ucun olan hissede registerin urlsini vermisem ona gore gormur ozume not--%>
<form:form modelAttribute="registrationForm" method="post" action="register">
    Name: <form:input path="name"/> <br/>
    <span> <form:errors path="name" cssClass="xeta"/></span>

    Surname: <form:input path="surname"/> <br/>
    <span> <form:errors path="surname" cssClass="xeta"/></span>

    Email: <form:input path="email"/> <br/>
    <span> <form:errors path="email" cssClass="xeta"/></span>

    Mobile: <form:input path="phone"/> <br/>
    <span> <form:errors path="phone" cssClass="xeta"/></span>

    Password: <form:password path="password"/> <br/>
    <span> <form:errors path="password" cssClass="xeta"/></span>

    PasswordConfirmation: <form:password path="passwordConfirmation"/> <br/>
    <span> <form:errors path="passwordConfirmation" cssClass="xeta"/></span>

    <input type="submit" value="Qeydiyyatdan kec">
</form:form>
</body>
</html>
