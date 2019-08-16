<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create an account</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
  <div class="container">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>
    </c:if>
  </div>

  <div align="left">
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
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
