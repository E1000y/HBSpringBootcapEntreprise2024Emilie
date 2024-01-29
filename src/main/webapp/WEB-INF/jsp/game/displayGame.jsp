
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<jsp:include flush="true" page="../base.jsp"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <div class="container">
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="${contextPath}/">Home</a></li>
                <li class="breadcrumb-item"><a href=${contextPath}/${UrlRoute.URL_GAME}">Les jeux</a></li>
                <li class="breadcrumb-item active" aria-current="page">${game.name}</li>
            </ol>
        </nav>
        <h1>${game.name}</h1>
        <img class="w-10" src ="${game.image}">

    <%--<f:form modelAttribute="reviewDto" method="post" action="">--%>
    <%--    <f:label path="title">Title</f:label>--%>
    <%--    <f:input type="text" path="title"/>--%>
    <%--</f:form>--%>

    <%--    ${s:mvcUrl('AppReview#create').arg(0, game.slug).build()}--%>

        <security:authorize access="isAuthenticated()">
            <f:form modelAttribute="reviewDto" method="post" action="${currentPath}" cssClass="p-5 col-md-8 col-sm-12 mx-auto">
                <div class="mb-3 row">
                    <f:label path="description" class="col-sm-2 col-form-label">Description</f:label>
                    <div class="col-sm-10">
                        <f:textarea type="text" cssClass="form-control" path="description"/>
                        <f:errors path="description" cssClass="invalid-feedback"/>
                    </div>
                </div>

                <div class="mb-3 row">
                    <f:label path="rating" class="col-sm-2 col-form-label">Rating</f:label>
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

<%@ include file="../footer.jsp" %>