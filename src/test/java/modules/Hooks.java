package modules;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import page_objects.GoogleSearchPage;

import static utils.BrowserFactory.getFactoryDriver;

public class Hooks {
    public static WebDriver driver;
    private GoogleSearchPage googleSearchPageObject = new GoogleSearchPage();

    @Before
    public void setUp(){
        driver = getFactoryDriver();
        PageFactory.initElements(driver, googleSearchPageObject);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
