
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
    <h1>Les derniers jeux</h1>
    <div class="row">
        <c:forEach items = "${games}" var = "game">
            <div class="card bg-black col-md-3 m-1  ">
<%--                <a href="#" class="">--%>
<%--                    <img src = "${game.image}">--%>
<%--                </a>--%>
<%--                ${game.name}--%>
               <div class="col text-center">
<%--                   <a href="${s:mvcUrl('AppGame#show').arg(0, game.name).build()}">--%>
                    <img src = "${game.image}" class ="rounded img-cropped">
<%--                   </a>--%>
                     <br>  ${game.name}</div>
            </div>
        </c:forEach>
    </div>
</div>




<div class="container">
    <h1>les derniers commentaires</h1>
    <div class = "row">

            <c:forEach items = "${reviews}" var = "review">
                <div class = "card bg-black m-3 col-lg-3 col-md-6 col-sm-12">
                        ${review.id}
                        ${review.description}
                        ${review.rating}/20

                </div>
            </c:forEach>

    </div>

</div>

<%@ include file="footer.jsp" %>
