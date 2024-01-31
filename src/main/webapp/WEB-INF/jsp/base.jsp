<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="tag.jsp" %>
<%
    Object title = request.getAttribute("title");
    if (title == null) {
        title = "Avis@Emilie";
    }
    request.setAttribute("title", title);
%>

<html>
    <head>
        <title>${title}</title>
        <link href="<c:url value="${contextPath}/css/main.css" />" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" rel="stylesheet">
        <script type="text/javascript" src="${contextPath}/js/page/search-bar.js"></script>
        <script type="text/javascript" src="${contextPath}/js/main.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="row w-100">
                <div class="col-6">
                    <a class="navbar-brand ms-3" href="${contextPath}/">
                        <i class="fa-brands fa-steam fa-3x"></i>
                    </a>
<%--                    <security:authorize access="isAuthenticated()">--%>
<%--                        <a href="#" class="btn btn-link">Liste des jeux</a>--%>
<%--                        <a href="#" class="btn btn-link">Commentaires</a>--%>
<%--                    </security:authorize>--%>
                </div>
                <div class="col-2">
                </div>
                <div class="col-4">
                    <security:authorize access="!isAuthenticated()">
                        <div class="d-flex justify-content-end">
                            <a class="nav-link" href="${UrlRoute.URL_LOGIN}">Login</a>
                        </div>
                    </security:authorize>
                    <security:authorize access="isAuthenticated()">
                        <div class="d-flex justify-content-end">
                            <span class="ms-2">
                                Bienvenue <security:authentication property="name"/>
                            </span>
                        </div>
                        <div class="d-flex justify-content-end">
                            <form class="m-0" method="POST" action="${UrlRoute.URL_LOGOUT}" autocomplete="off">
                                <button type="submit" tabindex="3" class="btn btn-link">Logout</button>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                            </form>
                        </div>
                    </security:authorize>
                </div>
            </div>
        </nav>