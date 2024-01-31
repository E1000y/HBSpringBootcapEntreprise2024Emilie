
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="tag.jsp" %>
<jsp:include flush="true" page="base.jsp"/>

<%--<div class="container">--%>
<%--    <h1>Instant-Faking</h1>--%>

<%--    <h2 class="my-5">Les dernières sorties</h2>--%>
<%--    <div class="row">--%>
<%--        <c:forEach items="${gamesReleased}" var="game">--%>
<%--            <a class="col-4 mt-2 main-game-card" href="${s:mvcUrl('AppGame#show').arg(0, game.slug).build()}">--%>
<%--                <div class="game-card">--%>
<%--                    <div class="game-card-img">--%>
<%--                        <img alt="${game.name}" src="${game.thumbnailCover}">--%>
<%--                    </div>--%>
<%--                    <div class="d-flex justify-content-between">--%>
<%--                        <p>${game.name}</p>--%>
<%--                        <p>${game.price}€</p>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </a>--%>
<%--        </c:forEach>--%>
<%--    </div>--%>
<%--</div>--%>


<div class="container">
    <div class="d-flex justify-content-around">
       <div>
       </div>
        <h1>
            Les derniers jeux
        </h1>
        <security:authorize access="isAuthenticated()">
            <a href="${UrlRoute.URL_GAME}/" class="btn btn-link">Voir tous les jeux</a>
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
                <a href="${UrlRoute.URL_REVIEW}/" class="btn btn-link">Voir tous les commentaires</a>
            </div>
        </security:authorize>
    </div>

<%--    <%@include file="review/pagedReviews.jsp"%>--%>

    <div class = "container row">
            <c:forEach items = "${reviews}" var = "review">


<%--                    <div class = "row m-3 col-md-3 ">--%>
                        <div class="col-lg-4 col-md-6 col-sm-12 mt-4">
                <%@include file="review/review-card.jsp"%>
<%--                <div class = "card bg-black m-3 col-lg-3 col-md-6 col-sm-12">--%>
<%--                        ${review.id}--%>
<%--                        ${review.description}--%>
<%--                        ${jspUtils.getStringRating(review.rating)}/20--%>
<%--                    </div>--%>
                    </div>


            </c:forEach>

    </div>

</div>

<%@ include file="footer.jsp" %>
