package project.TestRunners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith( Cucumber.class )
@CucumberOptions(
	features = "src\\test\\java\\project\\Features",
	glue = { "project.TestScripts" },
	monochrome = true,
	dryRun = false,
	format = { "pretty", "html:target/Results" }
)

public class Test_Runner_00 {

}
