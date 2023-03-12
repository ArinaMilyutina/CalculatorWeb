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
<body>
<%
    if (session.getAttribute("user") == null) {
        out.print("<button class=\"button button1\">\n" +
                "    <a href=\"/reg\">registration</a>\n" +
                "</button>" + "<p>\n" +
                "<button class=\"button button1\">\n" +
                "    <a href=\"/auth\">authorization</a>\n" +
                "</button>\n" +
                "</p>");
    } else {
        out.print("<p>\n" +
                "    <br>\n" +
                "    <button class=\"button button1\">\n" +
                "        <a href=\"/operation.jsp\">calculator</a>\n" +
                "    </button></p>\n" +
                "    <p>\n" +
                "    <button class=\"button button1\">\n" +
                "        <a href=\"/user.jsp\">user</a>\n" +
                "    </button>\n" +
                "    </p>\n" +
                "    <p>\n" +
                "    <button class=\"button button1\">\n" +
                "        <a href=\"/logout\">logout</a>\n" +
                "    </button>\n" +
                "    </p>\n" +
                "    </br>" );
    }
%>
</body>
</html>
