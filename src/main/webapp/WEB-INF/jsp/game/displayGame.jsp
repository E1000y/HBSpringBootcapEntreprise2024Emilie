<%--
  Created by IntelliJ IDEA.
  User: HB
  Date: 24/01/2024
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<jsp:include flush="true" page="../base.jsp"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>${game.name}</h1>
    <div class="container">
        <img class="w-10" src ="${game.image}">
    </div>

</body>
</html>
