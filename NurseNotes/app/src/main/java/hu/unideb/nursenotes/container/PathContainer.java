package hu.unideb.nursenotes.container;

import okhttp3.MediaType;

import static path.activity.ActivityPath.ACTIVITY_PATH;
import static path.client.ClientPath.CLIENT_PATH;
import static path.login.LoginPath.LOGIN_PATH;
import static path.register.RegisterPath.REGISTER_PATH;

public class PathContainer {

    private static final String SERVER_URL = "http://91.144.105.1:8080";

    public static final String REGISTRATION_URL = SERVER_URL + REGISTER_PATH;

    public static final String LOGIN_URL = SERVER_URL + LOGIN_PATH;

    public static final String CLIENT_ADD_URL = SERVER_URL + CLIENT_PATH;

    public static final String ACTIVITY_ADD_URL = SERVER_URL + ACTIVITY_PATH;

    public static final String GET_ALL_CLEINT = SERVER_URL + CLIENT_PATH;

    public static final int UNKNOW_ERROR = 999;

    public static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");


}
