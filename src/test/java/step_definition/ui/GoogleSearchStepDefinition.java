package step_definition.ui;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.ExcelReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static modules.Hooks.driver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static modules.page_objects.GoogleSearchPage.searchFor;

public class GoogleSearchStepDefinition {
    ExcelReader reader = new ExcelReader();
    String excelFilePath = "src/test/resources/Data/ExcelPOC.xlsx";
    String lookupWord, expectedResult;

    @Given("I open google search page")
    public void iOpenGoogleSearchPage() {
        driver.get("https://www.google.com/");
        try {
            WebElement securityPopUp = driver.findElement(By.id("zV9nZe"));
            if(securityPopUp.isDisplayed() && securityPopUp.isEnabled()) {
                securityPopUp.click();
            }
        }
        catch(Exception ignored) {}
    }

    @When("I lookup the word {string}")
    public void iLookupTheWord(String arg0) {
        searchFor(arg0);
    }

    @Then("search results display the word {string}")
    public void searchResultsDisplayTheWord(String arg0) {
        assertEquals(arg0 + " - Recherche Google", driver.getTitle());
    }

    @Given("my data is stored in sheet {string} and row {int}")
    public void myDataIsStoredInSheetAndRowRow_number(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException {
        List<Map<String,String>> testData =
                reader.getData(excelFilePath, sheetName);
        lookupWord = testData.get(rowNumber).get("lookup_word");
        expectedResult = testData.get(rowNumber).get("expected_result");
    }

    @When("I lookup the word")
    public void iLookupTheWord() {
        searchFor(lookupWord);
    }

    @Then("Then search should display the expected results")
    public void thenSearchShouldDisplayTheExpectedResults() {
        assertEquals(expectedResult + " - Recherche Google", driver.getTitle());
    }
}
