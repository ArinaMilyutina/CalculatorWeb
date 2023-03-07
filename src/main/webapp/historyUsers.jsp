<%@ page import="entity.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: arina
  Date: 07.03.2023
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>History users</title>
</head>
<body>
<ul>
    <%
        List<User> operationList = (List<User>) request.getAttribute("operations");
        if (operationList.isEmpty()) {
            response.getWriter().println("User is empty");
        } else {
            operationList.forEach(response.getWriter()::println);
        }
    %>

</ul>

</body>
</html>
