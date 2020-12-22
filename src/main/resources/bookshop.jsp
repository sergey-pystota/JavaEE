<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Products</title>
</head>
<h2>Books for Users:</h2>
<body>
<c:forEach var="userbooks" items="${userbooks}">
    Title: ${userbooks.title}
    Author: ${userbooks.author}
    Description: ${userbooks.description}
    Price: ${userbooks.price}$
    <br>
</c:forEach>
<br>
<h2>All books:</h2>
<c:forEach var="books" items="${books}">
    ID: ${books.id}
    Title: ${books.title}
    Author: ${books.author}
    Description: ${books.description}
    Year of Publishing: ${books.year}
    Price: ${books.price}$
    <br>
</c:forEach>
</body>
</html>