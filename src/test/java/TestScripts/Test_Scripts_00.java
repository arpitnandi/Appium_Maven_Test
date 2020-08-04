package TestScripts;


import java.io.IOException;
import java.util.*;

import cucumber.api.java.en.*;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import PageObjectModel.*;
import ProjectUtils.*;


public class Test_Scripts_00 extends Uitilities
{
	private Pages POM;
	private MobileActions Action;
	
	
	@Given("^Session started on Device$")
	public void Session_started_on_Device(Map<String,String> Table) throws InterruptedException, IOException, ParseException
	{
		Driver = launchSession(Table.get("Device"), 15000, 5000);
	}
	
	
	@When("^Started with dash board$")
	public void Started_with_dash_board()
	{
		POM = new Pages(Driver);
		
		Assert.assertTrue(POM.Navigation_Items.get(0).isDisplayed());
		Assert.assertTrue(POM.Incradible_India.isDisplayed());
		
		Wait.until(ExpectedConditions.elementToBeClickable(POM.Location_Dismiss));
		POM.Location_Dismiss.click();
	}

	
	@Given("^Slide and click on the (.*) block$")
	public void Slide_to_the_City_block_from_dash_board(String City) throws InterruptedException
	{
		POM = new Pages(Driver);
		Action = new MobileActions(Driver);

		Thread.sleep(1000);
		Wait.until(ExpectedConditions.visibilityOf(POM.Indian_Cities.get(2)));
		Action.slideAndSelectOne(POM.Indian_Cities, City);
	}

	
	@Then("^Verify the name of the selected (.*)$")
	public void Verify_the_name_of_the_selected_city(String City)
	{
		POM = new Pages(Driver);

		Wait.until(ExpectedConditions.visibilityOf(POM.Detail_Page_Header));
		Assert.assertEquals(City.toLowerCase(), POM.Detail_Page_Header.getText().toLowerCase());
	}
	
	
	@Then("^Scroll to Button and click on it$")
	public void Scroll_to_Button_and_click_on_it(Map<String,String> Table) throws InterruptedException
	{
		String Button = Table.get("Button");
		
		Action = new MobileActions(Driver);
		
		Action.scrollDown(4);
		
		Wait.until(ExpectedConditions.elementToBeClickable(super.findByText(Button)));
		super.findByText(Button).click();
		Thread.sleep(1000);
	}
}