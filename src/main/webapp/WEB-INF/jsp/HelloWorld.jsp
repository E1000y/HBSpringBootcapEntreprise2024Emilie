
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="tag.jsp" %>
<c:set var="title" scope="request" value="Coucou les gens !"/>
<jsp:include flush="true" page="base.jsp"/>

Hello World, this is the Users section.

<c:forEach items = "${users}" var = "user">
    <ul>
        <li>${user.email}</li>
        <li>${user.id}</li>
        <li>${user.password}</li>
        <li>${user.nickname}</li>
    </ul>
</c:forEach>

<c:forEach items = "${genre}" var="genre">
    <ul>
        <li>${genre.name}</li>
    </ul>
</c:forEach>

<%@ include file="footer.jsp" %>