<%--
  Created by IntelliJ IDEA.
  User: Alexandra
  Date: 8/13/2019
  Time: 12:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Case</title>
    <meta charset="utf-8">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

</head>
<body>
<form class="form-inline" action="<s:url value="/searchProducts"/>">
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">WebSHOP</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
                <select name="ordine">
                    <option value="1">Crescator</option>
                    <option value="2">Descrescator</option>
                </select>
        <li><a href="#">Cosul meu</a></li>
            <li><a href="#">Preferate</a></li>
        </ul>

            <input class="form-control" name="nume" type="text" placeholder="Search">
            <button class="btn btn-info" type="submit">Search</button>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="registration"><span class="glyphicon glyphicon-user"></span>Sign Up</a></li>
            <li><a href="login"><span class="glyphicon glyphicon-log-in"></span>Login</a></li>
        </ul>
    </div>
</nav>

<div align="left" class="container">

    <h3>Pret</h3>
    <div class="form-check" >
        <input class="form-check-input" type="radio" name="pret" id="pret1" value="option1" checked>
        <label class="form-check-label" for="pret1">
           Sub 5 RON
        </label>
    </div>
    <div class="form-check">
        <input class="form-check-input" type="radio" name="pret" id="pret2" value="option2">
        <label class="form-check-label" for="pret2">
           5-10 RON
        </label>
    </div>
    <div class="form-check">
        <input class="form-check-input" type="radio" name="pret" id="pret3" value="option3">
        <label class="form-check-label" for="pret3">
            10-50 RON
        </label>
    </div>
</div>
</form>

<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of products</h2></caption>
        <tr>
            <th>Nume</th>
            <th>Pret</th>
            <th>Cantitate</th>

        </tr>
        <c:forEach var="product" items="${listaProduselor}">
            <tr>
                <td><c:out value="${product.nume}" /></td>
                <td><c:out value="${product.pret}" /></td>
                <td><c:out value="${product.cantitate}" /></td>
            </tr>
        </c:forEach>
    </table>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
