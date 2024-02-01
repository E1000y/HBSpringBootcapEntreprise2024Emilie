package fr.EmiliePaniagua.poec.exam.routes;

public class UrlRoute {

    public final static String URL_LOGIN = "/login";

    public final static String URL_GAME = "/game";

    public final static String URL_GAME_ID = URL_GAME + "/id";

    public final static String URL_REVIEW_CREATE = "/review/new";

    public final static String URL_REVIEW = "/review";

    public final static String URL_LOGOUT = "/logout";

    public final static String URL_REGISTER = "/register";

    public static final String URL_REVIEW_MODERATE = "/review/moderate";

    public static final String URL_USER ="/gamer";

    public static final String URL_USER_SHOW ="/gamer/{uuid}";

    public static final String URL_EXPORT = "/export";

    public static final String URL_GAME_NEW = "/game/new";

    public final static String URL_GAME_UPLOAD_IMAGE = URL_GAME + "/upload-image";

    public final static String URL_GAME_UPLOAD_IMAGE_PATH = URL_GAME + "/upload-image/{slug}";

    public final static String URL_GAME_SLUG = URL_GAME + "/{slug}";
}
