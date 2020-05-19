package modules;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import page_objects.GoogleSearchPage;

public class Hooks {
    public static WebDriver driver;
    private GoogleSearchPage googleSearchPageObject = new GoogleSearchPage();

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        PageFactory.initElements(driver, googleSearchPageObject);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
