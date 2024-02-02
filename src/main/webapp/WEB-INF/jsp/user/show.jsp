<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<c:set var="title" scope="request" value="${user.nickname}"/>
<jsp:include flush="true" page="${contextPath}/WEB-INF/jsp/base.jsp"/>

<div class="container mt-5 ">
    <div>
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="${contextPath}/">Home</a></li>
                <li class="breadcrumb-item"><a href="${UrlRoute.URL_GAME}">Les jeux</a></li>
                <li class="breadcrumb-item"><a href="${UrlRoute.URL_REVIEW}">Les avis</a></li>
                <li class="breadcrumb-item active" aria-current="page">${user.nickname}</li>
            </ol>
        </nav>
    </div>
    <h1>${user.nickname}</h1>

    <c:set var="classGamer" scope="request" value="Gamer"/>
    <c:if test="${!user.moderator}">
        <div>Date de naissance : ${user.birthAt} (${dateUtils.getAgeFromDate(user.birthAt)} ans)</div>
    </c:if>

    <c:if test="${user.moderator}">
        l'utilisateur est modérateur
    </c:if>
    <c:if test="${!user.moderator}">
        l'utilisateur n'est pas modérateur
    </c:if>


    <div id="user-reviews"
         class="my-5"
    >
        <h2>Commentaires</h2>
        <div class="row">
            <%@ include file="../component/reviewList.jsp" %>
        </div>
</div>