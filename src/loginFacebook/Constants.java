package loginFacebook;

public class Constants {
	  public static String FACEBOOK_APP_ID = "597559877417795";
	  public static String FACEBOOK_APP_SECRET = "cf4cf377b71b3443432c870b073059f3";
	  public static String FACEBOOK_REDIRECT_URL = "https://localhost:8443/AccessFacebook/login-facebook";
	  public static String FACEBOOK_LINK_GET_TOKEN = "https://graph.facebook.com/oauth/access_token?client_id=%s&client_secret=%s&redirect_uri=%s&code=%s";
}
