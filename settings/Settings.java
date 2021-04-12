package settings;

public class Settings {
    private static String URL = "https://www.google.com";

    public static void setUrl(String setUrl) {
        URL = setUrl;
    }

    public static String getUrl() {
        return URL;
    }
}
