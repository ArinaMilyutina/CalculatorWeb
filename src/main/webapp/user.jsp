<%--
  Created by IntelliJ IDEA.
  User: arina
  Date: 07.03.2023
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu users</title>
</head>
<style>
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
        width: 150px;
        height: 40px;
    }

    .button1 {
        border-radius: 12px;
    }

</style>
<body>
<form action="/Users" method="post">
    <br>
    <button class="button button1">
        <a href="deleteUser.jsp">Delete User</a>
    </button>
    <p>
        <button class="button button1">
            <a href="showingUser.jsp">History users</a>
        </button>
    </p>
    </br>
</form>

</body>
</html>
