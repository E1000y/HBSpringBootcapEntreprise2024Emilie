
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<jsp:include flush="true" page="../base.jsp"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <div class="container">
        <div>
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="${contextPath}/">Home</a></li>
                    <li class="breadcrumb-item"><a href="${UrlRoute.URL_GAME}">Les jeux</a></li>
                    <li class="breadcrumb-item active" aria-current="page">${game.name}</li>
                </ol>
            </nav>
        </div>
        <div class="row">
            <div class="col-3">
                 <%@include file="game-card.jsp"%>
            </div>
            <div class="col-9">
                <security:authorize access="hasRole('MODERATOR')">
                    <a class="ms-1 link-green" href="${UrlRoute.URL_GAME_UPLOAD_IMAGE}/${game.slug}" title="Téléverser l'image du jeu">
                        <i class="fa-solid fa-upload fa-2x"></i>
                    </a>
                </security:authorize>
                <div class="fs-6 mt-3">${game.description}</div>
                <div class="fs-2">Genre : ${game.genre.name}</div>
                <div class="fs-2">${game.classification.name}</div>
                <div class="fs-2"><c:forEach var="platform" items="${game.platforms}">
                    ${platform.name}
                </c:forEach>
                    <div >${game.businessModel.name}</div>
                </div>
            </div>
        </div>
        <div class="row">
                <div class="d-flex mt-3     ">
                    <security:authorize access="!hasRole('MODERATOR')">
                        <h2>Rédigez un commentaire sur le jeu</h2>
                        <button class="ms-2 btn btn-link"
                                title="Ajouter un commentaire"
                                data-hide-show-button="formReview"
                        >
                            <i class="fa fa-pen fa-2x"></i>
                        </button>
                    </security:authorize>
                        </div>
                    <security:authorize access="isAuthenticated()">
                        <div class="my-3 d-none"
                        data-hide-show-container="formReview"
                        >
                        <f:form modelAttribute="reviewDto" method="post" action="${currentPath}" cssClass="p-5 col-md-8 col-sm-12 mx-auto">
                            <div class="mb-3 row">
                                    <f:label path="description" class="col-sm-2 col-form-label ">Votre<br>avis</f:label>
                                    <div class="col-sm-10">
                                        <f:textarea type="text" cssClass="form-control" path="description"/>
                                        <f:errors path="description" cssClass="invalid-feedback"/>
                                    </div>


                                    <div class="mb-3 row">
                                        <f:label path="rating" class="col-sm-2 col-form-label">Note</f:label>
                                        <div class="col-sm-10">
                                            <f:input type="number" min="0" max="20" step="0.5" cssClass="form-control" path="rating"/>
                                            <f:errors path="rating" cssClass="invalid-feedback"/>
                                        </div>
                                    </div>

                                    <f:input type="number" path="userId" hidden="hidden"/>
                                    <f:input type="number" path="gameId" hidden="hidden"/>
                                    <div class="col-6">
                                        <f:button class="btn btn-secondary" type="reset">Reset</f:button>

                                        <f:button class="btn btn-primary">Submit</f:button>
                                    </div>
                                </div>
                        </f:form>

                        </div>
                    </security:authorize>

    </div>

        <div class="row">
            <%@ include file="../component/reviewList.jsp" %>
        </div>
    </div>

<%--        <%@include file="../review/pagedReviews.jsp"%>--%>

<%@ include file="../footer.jsp" %>