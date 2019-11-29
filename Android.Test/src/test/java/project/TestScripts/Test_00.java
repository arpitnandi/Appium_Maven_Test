package project.TestScripts;

import java.util.*;

import cucumber.api.*;
import cucumber.api.java.en.*;
import io.appium.java_client.*;
import project.Utils.*;

public class Test_00 extends BaseClass
{
	public AppiumDriver<MobileElement> D = null;
	public Map<String, String> capabilities = null;
	
	@Given("^Open App with following configurations$")
	public void Open_App_with_following_configurations( DataTable Config ) throws Throwable 
	{
		capabilities = Config.asMap(String.class, String.class);
		
		D = launchSession( capabilities, 20000, 1000000 );
	}

	@Given("^some other precondition$")
	public void some_other_precondition() throws Throwable {}

	@When("^I complete action$")
	public void i_complete_action() throws Throwable {}

	@When("^some other action$")
	public void some_other_action() throws Throwable {}

	@When("^yet another action$")
	public void yet_another_action() throws Throwable {}

	@Then("^I validate the outcomes$")
	public void i_validate_the_outcomes() throws Throwable {}

	@Then("^check more outcomes$")
	public void check_more_outcomes() throws Throwable {}

	@Given("^I want to write a step with (.*)$")
	public void i_want_to_write_a_step_with_name( int name ) throws Throwable {}

	@When("^I check for the (\\d+) in step$")
	public void i_check_for_the_value_in_step(int value) throws Throwable {}

	@Then("^I verify the (.*) in step$")
	public void i_verify_the_status_in_step( String status ) throws Throwable 
	{
		D.closeApp();
	}
}