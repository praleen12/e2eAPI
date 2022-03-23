package testRunner;



import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/features/addNewPlace.feature", glue = {"stepDefination"}
,monochrome = true
,plugin = {"pretty", "json:target/cucumber.json"}

		)
public class TestRunner {

}
