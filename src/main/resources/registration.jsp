
<!DOCTYPE html>

<html lang="en">
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

    <meta charset="UTF-8">
    <title>Registration</title>
</head>
<body>

<div class="container" style="padding-top: 200px">
    <div class="row">
        <div class="col-4">
        </div>
        <div class="col-4">
            <form method="post" action="${pageContext.request.contextPath}/registration">
    <div class="form-row">
        <div class="form-group col-md-4">
            <label for="email">Email</label>
            <input type="email" class="form-control" id="email" name = "email">
        </div>
        <div class="form-group col-md-4">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" name="password">
        </div>
        <div class="form-group">
            <div class="form-group col-md-4">
                <label for="checkpassword">Repeat your password</label>
                <input type="password" class="form-control" id="checkpassword" name="checkpassword">
                <c:if var= "${not_equal_passwords_error != null}">
                    <small id="passwordHelp" class="text-danger">
                    ${not_equal_passwords_error}
                    </small>
                    </c:if>



            </div>
    </div>
    <div class="form-group">
        <label for="name">Name</label>
        <input type="text" class="form-control" id="name" placeholder="Your Name" name = "name">
    </div>
    <div class="form-group">
        <label for="surname">Surname</label>
        <input type="text" class="form-control" id="surname" placeholder="your surname" name = "surname">
    </div>



    </div>
    <div class="form-group">
        <div class="form-check">
            <input class="form-check-input" type="checkbox" id="gridCheck">
            <label class="form-check-label" for="gridCheck">
                Check me out
            </label>
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Create an account</button>
</form>
        </div>
        </div>
        </div>

</body>
</html>
