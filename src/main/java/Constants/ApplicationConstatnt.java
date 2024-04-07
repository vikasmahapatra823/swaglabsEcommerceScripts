package Constants;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class ApplicationConstatnt {


    public static Map<Long, WebDriver> driverMap = new HashMap<>();

    public static Map<String, String> globalDataMap = new HashMap<>();

    public static final String PORTAL_URL = "https://www.saucedemo.com/";
    public static final String USERNAME = "standard_user";

    public static final String PASSWORD = "secret_sauce";

}
