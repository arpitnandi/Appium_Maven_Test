package TestRunners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith( Cucumber.class )
@CucumberOptions(
	features = "src\\test\\java\\Features",
	glue = { "TestScripts" },
	monochrome = true,
	dryRun = false,
	format = { "pretty",
			"html:target/Results",
			"junit:target/Results/Cucumber.html" }
)

public class Test_Runner_00 {

}
