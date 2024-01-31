<%--
  Created by IntelliJ IDEA.
  User: HB
  Date: 29/01/2024
  Time: 13:07
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>

<%--Ceci est la page des reviews--%>

<%--</body>--%>
<%--</html>--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<c:set var="title" scope="request" value="Avis"/>
<jsp:include flush="true" page="${contextPath}/WEB-INF/jsp/base.jsp"/>

<%@ include file="../component/reviewList.jsp" %>

<%@ include file="../footer.jsp" %>