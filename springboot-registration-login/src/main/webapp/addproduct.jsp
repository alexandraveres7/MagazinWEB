<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Alexandra
  Date: 8/27/2019
  Time: 12:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add product to db</title>
</head>
<body>

<div class="container">
<form:form method="POST" modelAttribute="produs" class="form-addproduct">
    <h2 class="form-addproduct-heading" >Add a product</h2>

      <div class="form-group ${error != null ? 'has-error' : ''}">
          <span>${message}</span>
          <input name="nume" type="text" class="form-control" placeholder="Nume produs"
                 autofocus="true"/>
          <input name="pret" type="number" step="any" class="form-control" placeholder="Pret"/>
          <span>${error}</span>
          <input name="cantitate" type="number" class="form-control" placeholder="Cantitate"
                 autofocus="true"/>

    <button class="btn btn-lg btn-primary btn-block" type="submit">Adauga produs in stoc</button>
</div>
</form:form>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
