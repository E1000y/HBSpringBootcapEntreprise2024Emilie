
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../tag.jsp" %>
<jsp:include flush="true" page="../base.jsp"/>

<html>
<head>
    <title>Créez un compte</title>
    <div class = "container">
        <form action="${urlRoute.URL_REGISTER}" class= "col-4 mx-auto mt-5">
            <input autocomplete="off" name="username" type="text" class="form-control mb-3" placeholder="Pseudo"/>
            <input autocomplete="off" name="email" type="text" class="form-control mb-3" placeholder="email"/>
            <input autocomplete="off" name="password" type="password" class="form-control" placeholder="Mot de passe"/>
            <input autocomplete="off" name="checkPassword" type="password" class="form-control" placeholder="Confirmez le Mot de passe"/>
            <label>
                Veuillez saisir votre date de naissance :
                <input type="date" name="bday"/>
            </label>
            <p class="invalid-feedback">${error}</p>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button class="btn btn-lg btn-primary btn-block" type="submit">S'Enregistrer</button>
            <h4 class="text-center">
                <a href="${contextPath}/login" class="btn-link">
                    Se Connecter
                </a>
        </form>
    </div>
</head>
<body>

</body>
</html>
