<%@ page import="entity.User" %>
<%@ page import="java.util.Optional" %>
<%@ page import="service.UserService" %>
<%@ page import="validator.UserValidator" %>
<%@ page import="java.util.Objects" %><%--
  Created by IntelliJ IDEA.
  User: arina
  Date: 07.03.2023
  Time: 01:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<style>
    input {
        background: #ffffff;
        color: #000000;
        padding: 10px;
        border-radius: 12px;
        border: 2px solid #0000ff;
        width: 220px;
        height: 40px;
    }

    .button {
        background-color: #ffffff;
        border: 2px solid #0000ff;
        color: blue;
        padding: 10px;
        text-align: left;
        text-decoration: none;
        display: inline-block;
        font-size: 12px;
        margin: 4px 2px;
        text-transform: uppercase;
        width: 120px;
        height: 40px;
    }

    .button1 {
        border-radius: 12px;
    }

</style>
<body>
<form action="/reg" method="post">
    <p style="color: blue">Registration:</p>
    <p><input type="text" name="name" placeholder="Name"></p>
    <p><input type="text" name="username" placeholder="Username"></p>
    <p><input type="password" name="password" placeholder="Password"></p>
    <button class="button button1">Submit</button>
</form>
<p style="color: red">${message}</p>
</body>
</html>
