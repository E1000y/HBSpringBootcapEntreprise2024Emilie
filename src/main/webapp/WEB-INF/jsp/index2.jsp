
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="tag.jsp" %>
<jsp:include flush="true" page="base.jsp"/>


<div class="container">
    <div>
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item active" aria-current="page">Accueil</li>
                <li class="breadcrumb-item"><a href="${UrlRoute.URL_GAME}">Les jeux</a></li>
                <li class="breadcrumb-item"><a href="${UrlRoute.URL_REVIEW}">Les avis</a></li>
            </ol>
        </nav>
    </div>
    <div class="d-flex justify-content-around">
        <h1>
            Les derniers jeux
        </h1>
        <security:authorize access="isAuthenticated()">
            <a href="${UrlRoute.URL_GAME}" class="btn btn-link">Voir tous les jeux</a>
        </security:authorize>
        <security:authorize access="hasRole('MODERATOR')">
            <a href="${UrlRoute.URL_GAME_NEW}" class="ms-2">
                <i class="fa fa-circle-plus link-green fs-2 text-success"></i>
            </a>
        </security:authorize>
    </div>
    <div class="row">
        <c:forEach items = "${games}" var = "game">
            <div class="col-md-4 col-12-sm p-1">
                <%@ include file="game/game-card.jsp"%>
            </div>
        </c:forEach>
    </div>
</div>


<div class="container">
    <div class="d-flex">
        <div>
            <h1>les derniers commentaires</h1>
        </div>
        <security:authorize access="isAuthenticated()">
            <div class="px-5">
                <a href="${UrlRoute.URL_REVIEW}" class="btn btn-link">Voir tous les commentaires</a>
            </div>
        </security:authorize>
    </div>

    <security:authorize access="hasRole('MODERATOR')">
        <div>
            <a href="${UrlRoute.URL_EXPORT}" class="btn btn-link">
                <i class="fa-solid fa-file-excel me-1 text-success"></i>
                Télécharger export Excel
            </a>
        </div>
    </security:authorize>

<%--    <%@include file="review/pagedReviews.jsp"%>--%>
        <%@ include file="component/reviewList.jsp" %>
    </div>

</div>

<%@ include file="footer.jsp" %>
