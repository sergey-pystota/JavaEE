<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>

<div class="container" style="padding-top: 200px">
    <div class="row">
        <div class="col-4">
        </div>
        <div class="col-4">
            <form method="post" action="${pageContext.request.contextPath}/login">
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" id="email" aria-describedby="emailHelp" name="email">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" name="password">
                    <%
                        if (request.getAttribute("login_error") != null) {
                    %>
                    <small id="passwordHelp" class="text-danger">
                        ${login_error}
                    </small>
                    <%
                        }
                    %>
                </div>
                <button type="submit" class="btn btn-primary">Login</button>
                <p class="text-center"><a href="${pageContext.request.contextPath}/registration">Create an Account</a></p>
            </form>
        </div>
        <div class="col-4">
        </div>
    </div>
</div>


</body>
</html>