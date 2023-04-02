
<html>
<head>
        <title>Registration</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    </head>
<body>
<form action="/reg" method="post">
    <div class="container">
        <div class="row align-items-center h-100">
            <div class="col-md-8 offset-md-5">
                <p>Registration:</p>
                <div class="col-sm-4 my-auto">
    <p><input type="text" class="form-control" name="name" required placeholder="Name"></p>
    <p><input type="text" class="form-control" name="username" required placeholder="Username"></p>
    <p><input type="password" class="form-control" name="password" required placeholder="Password"></p>
                    <div class="d-grid gap-2">
                        <p style="color: red">${message}</p>
                        <button class="btn btn-success">Sign up</button>
                        <button class="btn btn-primary"><a href="/auth" style="color: aliceblue">Authorization</a>
                        </button>
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
