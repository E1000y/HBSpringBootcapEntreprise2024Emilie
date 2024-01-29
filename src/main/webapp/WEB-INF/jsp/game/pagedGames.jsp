<%--
  Created by IntelliJ IDEA.
  User: HB
  Date: 29/01/2024
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<c:forEach items="${pagedGames.content}" var="game">--%>
<%--    --%>

<%--</body>--%>
<%--</html>--%>


<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<c:set var="title" scope="request" value="Avis"/>
<jsp:include flush="true" page="${contextPath}/WEB-INF/jsp/base.jsp"/>

<div class="container">
    <div class="d-flex justify-content-between">
        <div class="d-flex">
            <!-- Label à afficher -->
            <c:set var="label" scope="request" value="Date de sortie"/>
            <!-- Sur quelle propriété de l'objet on souhaite trier -->
            <c:set var="sortable" value="publishedAt"/>
            <%@ include file="../component/sortable.jsp" %>

            <c:set var="label" scope="request" value="Nom"/>
            <c:set var="sortable" value="name"/>
            <%@ include file="../component/sortable.jsp" %>

<%--            <c:set var="label" scope="request" value="Jeu"/>--%>
<%--            <c:set var="sortable" value="game.name"/>--%>
<%--            <%@ include file="../component/sortable.jsp" %>--%>

<%--            <c:set var="label" scope="request" value="Joueur"/>--%>
<%--            <c:set var="sortable" value="gamer.nickname"/>--%>
<%--            <%@ include file="../component/sortable.jsp" %>--%>

            <span class="mt-auto mb-2">
                <a href="${currentUrl}" class="btn-link" title="Réinitialiser les filtres">
                    <i class="fa fa-filter-circle-xmark"></i>
                </a>
            </span>
        </div>
        <div  class="mt-auto mb-2">
            <span>
                page ${pagedGames.number + 1} sur ${pagedGames.totalPages}
            </span>
        </div>
    </div>
    <div class="row">
        <c:forEach items="${pagedGames.content}" var="game">
            <div class="col-md-3 px-1">
            <%@include file="game-card.jsp"%>
            </div>
        </c:forEach>
    </div>
    <c:set var="page" scope="request" value="${pagedGames}"/>
    <%@ include file="../component/pagination.jsp" %>

</div>

<%@ include file="../footer.jsp" %>