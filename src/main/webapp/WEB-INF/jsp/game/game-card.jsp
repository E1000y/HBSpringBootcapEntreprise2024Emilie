
<%@ page contentType="text/html;charset=UTF-8" %>

<div class="card bg-black">
    <div class="col text-center h-100">
        <a href="${UrlRoute.URL_GAME}/${game.slug}">
            <img src = "${game.image}" class ="image-game rounded img-cropped">
        </a>
        <br>  ${game.name}
    </div>
</div>
