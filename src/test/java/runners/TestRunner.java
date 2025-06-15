package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/java/Features" }
			, glue = { "step" }
			, plugin = { "pretty", "html:reports/htmlReports.html"
					, "rerun:target/failedrerun.txt" }
			)
public class TestRunner {
	
}
