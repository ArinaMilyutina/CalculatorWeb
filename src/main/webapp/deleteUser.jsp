<%@ page import="service.UserService" %><%--
  Created by IntelliJ IDEA.
  User: arina
  Date: 07.03.2023
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete users</title>
</head>
<body>

<ul>
    <%
        UserService userService = new UserService();
        userService.deleteHistory();
        response.getWriter().println("History is deleted.");
    %>
</ul>
</body>
</html>
