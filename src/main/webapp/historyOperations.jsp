<%@ page import="entity.Operation" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: arina
  Date: 07.03.2023
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>History operations</title>
</head>
<body>
<ul>
    <%
        List<Operation> operationList = (List<Operation>) request.getAttribute("operations");
        if (operationList.isEmpty()) {
            response.getWriter().println("History is empty");
        } else {
            operationList.forEach(response.getWriter()::println);
        }
    %>

</ul>
</body>
</html>