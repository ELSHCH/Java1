<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: shcheki
  Date: 20.03.2015
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title> Guests book</title>
</head>
<script src="js/jquery-1.11.2.js" type="text/javascript"></script>
<script>
      $(document).ready(function() {
     $.post("/test", function (r) {
     setTimeout(function () {
     $('#title').html(r);
     },10000);
     console.log(JSON.stringify(r));
     });
     });
</script>
<body>
<table border="1">
    <tr>
        <td colspan="4" id="title">Guest book </td>
    </tr>
    <c:forEach var="guests" items="${requestScope.Guests}">
    <tr>
        <td><c:out value="${guests.firstname}"/></td>
        <td><c:out value="${guests.lastname}"/></td>
        <td><c:out value="${guests.useremail}"/></td>
        <td><c:out value="${guests.textComment}"/></td>
    </tr>
    </c:forEach>
    </table>
</body>
</html>
