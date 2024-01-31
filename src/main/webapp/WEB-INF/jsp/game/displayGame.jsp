
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<jsp:include flush="true" page="../base.jsp"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <div class="container">
        <div>
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="${contextPath}/">Home</a></li>
                    <li class="breadcrumb-item"><a href="${UrlRoute.URL_GAME}/">Les jeux</a></li>
                    <li class="breadcrumb-item active" aria-current="page">${game.name}</li>
                </ol>
            </nav>
        </div>
        <div class="container d-flex ">
            <div class="col-3">
                <%@include file ="game-card.jsp"%>
            </div>
             <div class = "col-9">
                <security:authorize access="isAuthenticated()">

                    <f:form modelAttribute="reviewDto" method="post" action="${currentPath}" cssClass="p-5 col-md-8 col-sm-12 mx-auto">
                        <div class="mb-3 row">
                            <h2 class="py-3">Rédigez votre commentaire sur le jeu</h2>
                            <f:label path="description" class="col-sm-2 col-form-label ">Votre avis</f:label>
                            <div class="col-sm-10">
                                <f:textarea type="text" cssClass="form-control" path="description"/>
                                <f:errors path="description" cssClass="invalid-feedback"/>
                            </div>
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
                        <f:button class="btn btn-secondary" type="reset">Reset</f:button>
                        <f:button class="btn btn-primary">Submit</f:button>
                    </f:form>
                </security:authorize>
            </div>
        </div>
        <jsp:include flush="true" page="${contextPath}/WEB-INF/jsp/review/pagedReviews.jsp"/>
<%--        <%@include file="../review/pagedReviews.jsp"%>--%>

<%@ include file="../footer.jsp" %>