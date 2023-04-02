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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>

<body>
<%
    if (session.getAttribute("user") == null) {
        out.print("<form>\n" +
                "    <div class=\"container\">\n" +
                "        <div class=\"row align-items-center h-100\">\n" +
                "            <div class=\"col-md-8 offset-md-5\">\n" +
                "                <div class=\"col-sm-4 my-auto\">\n" +
                "                    <div class=\"d-grid gap-2\">\n" +
                "                        <button class=\"btn btn-primary\"><a href=\"/reg\" style=\"color: aliceblue\">Registration</a>\n" +
                "                        </button>\n" +
                "                        <button class=\"btn btn-primary\"><a href=\"/auth\" style=\"color: aliceblue\">Authorization</a>\n" +
                "                        </button>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</form>");
    } else {
        out.print("<form>\n" +
                "  <div class=\"container\">\n" +
                "    <div class=\"row align-items-center h-100\">\n" +
                "      <div class=\"col-md-8 offset-md-5\">\n" +
                "        <div class=\"col-sm-4 my-auto\">\n" +
                "          <div class=\"d-grid gap-2\">\n" +
                "            <button class=\"btn btn-primary\"><a href=\"/operation.jsp\" style=\"color: aliceblue\">Operations</a></button>\n" +
                "            <button class=\"btn btn-primary\"><a href=\"/user.jsp\" style=\"color: aliceblue\">Users</a></button>\n" +
                "            <button class=\"btn btn-primary\"><a href=\"/logout\" style=\"color: aliceblue\">Logout</a></button>\n" +
                "          </div>\n" +
                "        </div>\n" +
                "      </div>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "</form>");
    }
%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>
</html>
