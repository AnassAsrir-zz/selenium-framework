package step_definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static modules.Hooks.driver;
import static org.junit.Assert.assertTrue;
import static page_objects.GoogleSearchPage.searchFor;

public class GoogleSearchStepDefinition {

    @Given("I open google search page")
    public void iOpenGoogleSearchPage() {
        driver.get("https://www.google.com/");
    }

    @When("I lookup the word {string}")
    public void iLookupTheWord(String arg0) {
        searchFor(arg0);
    }

    @Then("search results display the word {string}")
    public void searchResultsDisplayTheWord(String arg0) {
        assertTrue(driver.getTitle().contains(arg0));
    }
}
