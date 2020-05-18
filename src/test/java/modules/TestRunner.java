package modules;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        plugin = {"pretty", "json:target/json/results.json"},
        features = {"src/test/resources/features"},
        glue = {"modules","step_definition"},
        tags = {""}
)

public class TestRunner {
    //Todo: create test run configuration
}
