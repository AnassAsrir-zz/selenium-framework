package utils;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class BrowserFactory {
    static WebDriver factoryDriver;
    private static HashMap<String, String> configurationMap = PropertiesFile.read("src/test/resources/environment/config.properties");
    static String webBrowserType = configurationMap.get("browser");
    static boolean headless = Boolean.parseBoolean(configurationMap.get("isHeadless"));

    public static WebDriver getFactoryDriver() {
        String driversPath = "src/test/resources/drivers/";
        switch (webBrowserType) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", driversPath + "chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.setHeadless(headless);
                factoryDriver = new ChromeDriver(options);
                break;
            case "ie":
                System.setProperty("webdriver.ie.driver", driversPath + "IEDriverServer.exe");
                factoryDriver = new InternetExplorerDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", driversPath + "geckodriver.exe");
                factoryDriver = new FirefoxDriver();
                break;
            case "edge-legacy":
                //obsolete
                factoryDriver = new EdgeDriver();
            default:
                System.setProperty("webdriver.chrome.driver", driversPath + "chromedriver.exe");
                factoryDriver = new ChromeDriver();
                break;
        }
        factoryDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return factoryDriver;
    }

}
