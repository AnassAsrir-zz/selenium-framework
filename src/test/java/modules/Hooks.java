package modules;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import modules.page_objects.GoogleSearchPage;
import utils.PropertiesFile;

import java.util.HashMap;

import static utils.BrowserFactory.getFactoryDriver;

public class Hooks {
    public static WebDriver driver;
    private GoogleSearchPage googleSearchPageObject = new GoogleSearchPage();
    private static HashMap<String, String> configurationMap = PropertiesFile.read("src/test/resources/environment/config.properties");
    static String baseUrl = configurationMap.get("baseUrl");

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
