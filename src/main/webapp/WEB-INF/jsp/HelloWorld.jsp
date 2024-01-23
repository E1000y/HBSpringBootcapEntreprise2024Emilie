<%--
  Created by IntelliJ IDEA.
  User: HB
  Date: 23/01/2024
  Time: 09:31
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>

Hello World, this is the Users section.

<c:forEach items = "${users}" var = "user">
    <ul>
        <li>${user.email}</li>
        <li>${user.id}</li>
        <li>${user.password}</li>
        <li>${user.nickname}</li>
    </ul>

</c:forEach>

<c:forEach items = "${genre}" var="genre">
    <ul>
        <li>${genre.name}</li>
    </ul>
</c:forEach>

</body>
</html>
