
<%@ page contentType="text/html;charset=UTF-8" %>

<div class="d-flex justify-content-between">
    <div class="d-flex">

        <c:set var="label" scope="request" value="Date de publication"/>
        <c:set var="sortable" value="createdAt"/>
        <%@ include file="../component/sortable.jsp" %>

        <c:set var="label" scope="request" value="Note"/>
        <c:set var="sortable" value="rating"/>
        <%@ include file="../component/sortable.jsp" %>

        <c:set var="label" scope="request" value="Jeu"/>
        <c:set var="sortable" value="game.name"/>
        <%@ include file="../component/sortable.jsp" %>

        <c:set var="label" scope="request" value="Joueur"/>
        <c:set var="sortable" value="gamer.nickname"/>
        <%@ include file="../component/sortable.jsp" %>

        <span class="mt-auto mb-2">
                    <a href="${currentUrl}" class="btn-link" title="Réinitialiser les filtres">
                        <i class="fa fa-filter-circle-xmark"></i>
                    </a>
        </span>
        <div  class="mt-auto mb-2">
            <span>
                page ${pagedReviews.number + 1} sur ${pagedReviews.totalPages}
            </span>

        </div>
    </div>
</div>



<div class="row">
    <c:forEach items="${pagedReviews.content}" var="review">
        <div class="col-lg-4 col-md-6 col-sm-12 mt-4">
            <%@ include file="../review/review-card.jsp" %>
        </div>
    </c:forEach>
</div>

<div>
    <c:set var="page" scope="request" value="${pagedReviews}"/>
    <%@ include file="../component/pagination.jsp" %>

</div>