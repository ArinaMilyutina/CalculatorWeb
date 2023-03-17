<%@ page import="service.CalculatorService" %><%--
  Created by IntelliJ IDEA.
  User: arina
  Date: 07.03.2023
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete history operation</title>
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
        width: 120px;
        height: 40px;
    }

    .button1 {
        border-radius: 12px;
    }
</style>
<body>

<ul>
    <%
        CalculatorService.getInstance().deleteHistory();
        response.getWriter().println("History is deleted.");
    %>
</ul>
<p>
    <button class="button button1">
        <a href="/"> menu</a>
    </button>
</p>
</body>
</html>
