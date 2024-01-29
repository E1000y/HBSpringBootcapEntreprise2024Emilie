
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../tag.jsp" %>
<jsp:include flush="true" page="../base.jsp"/>

<html>
<head>
    <title>Créez un compte</title>
    <div class = "container">
        <f:form action="${UrlRoute.URL_REGISTER}" method="post" modelAttribute="registerDTO" class= "col-md-5 col-sm-10 mx-auto mt-5">
            <f:input autocomplete="off" type="text" class="form-control mb-3" placeholder="Pseudo" path="nickname"/>
            <f:errors cssClass="invalid-feedback" path="nickname"/>
            <f:input autocomplete="off" type="text" class="form-control mb-3" placeholder="Email" path="email"/>
            <f:errors cssClass="invalid-feedback" path="email"/>
            <f:input autocomplete="off" type="date" class="form-control mb-3" placeholder="Date de naissance" path="birthAt"/>
            <f:errors cssClass="invalid-feedback" path="birthAt"/>
            <f:input autocomplete="off" type="password" class="form-control mb-3" placeholder="Password" path="password"/>
            <f:errors cssClass="invalid-feedback" path="password"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button class="btn btn-lg btn-primary btn-block" type="submit">S'inscrire</button>
            <h4 class="text-center">
                <a href="${contextPath}/login" class="btn-link">
                    Se Connecter
                </a>
            </h4>
        </f:form>
    </div>
</head>
<body>

</body>
</html>
