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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<form action="/calc" method="post">
    <div class="container">
        <div class="row align-items-center h-100">
            <div class="col-md-8 offset-md-5">
                <p>Authorization:</p>
                <div class="col-sm-4 my-auto">
                    <p><input type="number" class="form-control" name="num1" placeholder="Num 1"></p>
                    <p><input type="number" class="form-control" name="num2" placeholder="Num 2"></p>
                    <p><input type="text" class="form-control" name="type"
                              placeholder="Operation type(sum, div, res, mul)"></p>
                    <div class="d-grid gap-2">
                        <button class="btn btn-primary">Calculate</button>
                    </div>
                    <p style="color: darkblue">${result}</p>
                    <div class="d-grid gap-2">
                        <button class="btn btn-outline-primary"><a href="/">Menu</a></button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>
</html>
