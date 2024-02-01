<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<c:set var="title" scope="request" value="${user.nickname}"/>
<jsp:include flush="true" page="${contextPath}/WEB-INF/jsp/base.jsp"/>

<div class="container mt-5 ">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a class="btn-link" href="${contextPath}/">Accueil</a></li>
            <li class="breadcrumb-item"><a class="btn-link" href="${contextPath}${UrlRoute.URL_GAME}">Les jeux</a></li>
            <li class="breadcrumb-item active" aria-current="page">${user.nickname}</li>
            <li class="breadcrumb-item active"><a class="btn-link" href="#user-reviews">Les commentaires</a></li>
        </ol>
    </nav>
    <h1>${user.nickname}</h1>

    Date de naissance : ${user.birthAt}<br>
    ${dateUtils.getAgeFromDate(user.birthAt)} ans
    <c:if test="${user.moderator}">
        l'utilisateur est modérateur
    </c:if>
    <c:if test="${!user.moderator}">
        l'utilisateur n'est pas modérateur
        ${dateUtils.getAgeFromDate(user.birthAt)} ans
    </c:if>
    <div class="col d-flex justify-content-start">${dateUtils.getDateFormat(user.birthAt, "dd MMMM yyyy")}</div>
    <div>0${user.birthAt}0</div>


    <c:set var="classGamer" scope="request" value="Gamer"/>
    <c:if test="${!user.isModerator}">
        <p>${dateUtils.getAgeFromDate(user.birthAt)} ans</p>
    </c:if>

    <div id="user-reviews"
         class="my-5"
    >
        <h2>Commentaires</h2>
        <c:if test="${pageReviews.content.size() > 0}">
        <div class="d-flex justify-content-between">
            <div class="d-flex">
                <!-- Label à afficher -->
                <c:set var="label" scope="request" value="Date"/>
                <!-- Sur quelle propriété de l'objet on souhaite trier -->
                <c:set var="sortable" value="createdAt"/>
                <%@ include file="../component/sortable.jsp" %>

                <c:set var="label" scope="request" value="Note"/>
                <c:set var="sortable" value="rating"/>
                <%@ include file="../component/sortable.jsp" %>

                <c:set var="label" scope="request" value="Joueur"/>
                <c:set var="sortable" value="gamer.nickname"/>
                <%@ include file="../component/sortable.jsp" %>

                <%@ include file="../component/filter-reset.jsp" %>
            </div>

            <c:set var="page" scope="request" value="${pageReviews}"/>
            <%@ include file="../component/pagination-number.jsp" %>
        </div>
        <div class="row">
            <c:forEach items="${pageReviews.content}" var="review">
                <div class="col-lg-4 col-md-6 col-sm-12 mt-4">
                    <%@ include file="../review/review-card.jsp" %>
                </div>
            </c:forEach>
        </div>
        <%@ include file="../component/pagination.jsp" %>
    </div>
    </c:if>
</div>