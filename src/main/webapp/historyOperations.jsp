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
    <title>HistoryOperation</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
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
<div class="col-sm-1 my-auto">
    <div class="d-grid gap-2">
        <button class="btn btn-outline-primary"><a href="/">Menu</a></button>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>
</html>
