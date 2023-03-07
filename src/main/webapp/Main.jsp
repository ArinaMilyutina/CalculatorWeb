<%--
  Created by IntelliJ IDEA.
  User: arina
  Date: 07.03.2023
  Time: 03:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
</head>
<style>
    .button {
        background-color: #ffffff;
        border: 2px solid #0000ff;
        padding: 10px;
        text-align: left;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
        margin: 4px 2px;
        width: 150px;
        height: 50px;
        text-transform: uppercase;

    }

    .button1 {
        border-radius: 12px;
    }

</style>

<form action="/main" method="post">
    <br>
    <button class="button button1">
        <a href="/registration.jsp">Registration</a>
    </button>
    <p>
        <button class="button button1">
            <a href="authorization.jsp">Authorization</a>
        </button>
    </p>
    </br>
</form>
</form>

</body>
</html>
