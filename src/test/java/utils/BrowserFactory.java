package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

public class BrowserFactory {
    static WebDriver factoryDriver;
    private static HashMap<String, String> configurationMap = PropertiesFile.read("src/test/resources/environnement/config.properties");
    static String webBrowserType = configurationMap.get("browser");
    static boolean headless = Boolean.parseBoolean(configurationMap.get("isheadless"));

    public static WebDriver getFactoryDriver() {
        switch (webBrowserType) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                options.addArguments("--ignore-certificate-errors");
                options.addArguments("--disable-popup-blocking");
                options.addArguments("--incognito");
                options.setHeadless(headless);
                factoryDriver = new ChromeDriver(options);
                break;
            case "ie":
                break;
            case "firefox":
                break;
            default:
                break;
        }
        return factoryDriver;
    }

}
