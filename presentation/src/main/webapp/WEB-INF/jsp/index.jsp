<%--
  Created by IntelliJ IDEA.
  User: odemura
  Date: 21.03.2020
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<form method="post">
    <input type="text" name="firstName">
    <input type="text" name="lastName">
    <button type="submit">Отправить</button>
</form>

<p>Сколько раз какая буква встречается в имени и фамилии</p>
<c:forEach items="${mapWords}" var="map">
    <p>${map.key} : ${map.value}</p>
</c:forEach>

<p>Фамилия без самой встречающейся буквы: ${string}</p>

</body>
</html>
