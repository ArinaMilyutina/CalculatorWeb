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
<body>
<ul>
    <%
        CalculatorService calculatorService = new CalculatorService();
        calculatorService.deleteHistory();
        response.getWriter().println("History is deleted.");
    %>
</ul>
</body>
</html>
