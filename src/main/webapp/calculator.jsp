<%--
  Created by IntelliJ IDEA.
  User: arina
  Date: 06.03.2023
  Time: 23:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<style>
    input {
        background: #ffffff;
        color: #000000;
        padding: 10px;
        border-radius: 8px;
        border: 2px solid #0000ff;
        width: 250px;
        height: 40px;

    }

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
<form action="/calc" method="post">
    <p>Calculator:</p>
    <p><input type="number" name="num1" placeholder="Num 1"></p>
    <p><input type="number" name="num2" placeholder="Num 2"></p>
    <p><input type="text" name="type"
              placeholder="Operation type(sum, div, res, mul)"></p>
    <button class="button button1">calculate</button>
</form>
<p>${result}</p>
<p>
    <button class="button button1">
        <a href="/"> menu</a>
    </button>
</p>
</body>
</html>