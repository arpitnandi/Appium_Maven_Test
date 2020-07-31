package TestRunners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith( Cucumber.class )
@CucumberOptions(
	features = "src\\test\\java\\Features",
	glue = { "TestScripts" },
	monochrome = true,
	dryRun = true,
	plugin = { "pretty:target/Reports/Pretty.txt","html:target/Reports" }
)

public class Test_Runner_00 {

}
