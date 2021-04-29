package modules;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import modules.page_objects.GoogleSearchPage;
import utils.PropertiesFile;

import java.io.IOException;
import java.util.HashMap;

import static utils.BrowserFactory.getFactoryDriver;

public class Hooks {
    public static WebDriver driver;
    private final GoogleSearchPage googleSearchPageObject = new GoogleSearchPage();
    private static final HashMap<String, String> configurationMap = PropertiesFile.read("src/test/resources/environment/config.properties");
    static String webBrowserType = configurationMap.get("browser");
    static String baseUrl = configurationMap.get("baseUrl");

    @Before()
    public void cleanUp() throws IOException {
        Runtime rt = Runtime.getRuntime();
        switch (webBrowserType) {
            case "chrome":
                break;
            case "ie":
                break;
            case "firefox":
                break;
            case "edge-legacy":
            default:
                Process pr = rt.exec("taskkill /IM chromedriver.exe /F");
                break;
        }
    }

    @Before("@api")
    public void init(){
        RestAssured.baseURI = baseUrl;
    }

    @Before("@ui")
    public void setUp(){
        driver = getFactoryDriver();
        PageFactory.initElements(driver, googleSearchPageObject);
    }

    @After("@ui")
    public void tearDown(){
        driver.quit();
    }
}
