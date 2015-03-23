<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: shcheki
  Date: 20.03.2015
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title> all the News</title>
</head>
<script src="../web/js/jquery-1.11.2.js" type="text/javascript"></script>
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
    <tr> <td colspan="3" id="title"></td></tr>
    <c:forEach var="news" items="${requestScope.News}">
        <tr>
            <td><c:out value="${news.numNews}"/></td>
            <td><c:out value="${news.title}"/> </td>
            <td><c:out value="${news.text}"/> </td>
    </c:forEach>
    <td><form action="test" method="POST">
        <input type="text" name="title" value="Заголовок новости" />
        <input type="text" name="numNews" value="Номер новости" />
        <textarea rows="100" cols="50" name="textNews">Введите текст</textarea>
        <input type="submit"/>
    </form> </td>
    </tr>
</table>
</body>
</html>
