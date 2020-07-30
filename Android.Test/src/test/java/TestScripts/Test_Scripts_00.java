package TestScripts;


import java.net.MalformedURLException;
import java.util.*;

import cucumber.api.*;
import cucumber.api.java.en.*;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import PageObjectModel.*;
import ProjectUtils.*;


public class Test_Scripts_00 extends Uitilities
{
	protected Map<String, String> capabilities;
	protected Pages POM;
	protected MobileActions Action;
	
	
	@Given("^Session is started$")
	public void Session_is_started(DataTable Config) throws MalformedURLException, InterruptedException
	{
		this.capabilities = Config.asMap(String.class, String.class);
		
		Driver = launchSession(capabilities, 100000, 5000);
	}
	
	
	@When("^Started with dash board$")
	public void Started_with_dash_board()
	{
		POM = new Pages(Driver);
		
		Assert.assertTrue(POM.Navigation_Items.isDisplayed());
		Assert.assertTrue(POM.Incradible_India.isDisplayed());
		
		Wait.until(ExpectedConditions.elementToBeClickable(POM.Location_Dismiss));
		POM.Location_Dismiss.click();
	}

	
	@Given("^Slide and click on the (.*) block$")
	public void Slide_to_the_City_block_from_dash_board(String Name)
	{
		POM = new Pages(Driver);
		Action = new MobileActions(Driver);
		
		Wait.until(ExpectedConditions.elementToBeClickable(POM.Indian_Cities.get(2)));
		Action.slideAndSelectOne(POM.Indian_Cities, Name);
	}

	
	@Then("^Verify the name of the selected (.*)$")
	public void Verify_the_name_of_the_selected_city(String City)
	{
		POM = new Pages(Driver);
		
		Wait.until(ExpectedConditions.visibilityOf(POM.Detail_Page_Header));
		Assert.assertEquals(City.toUpperCase(), POM.Detail_Page_Header.getText().toUpperCase());
	}
	
	
	@Then("^Scroll to Name button and click on it$")
	public void Scroll_to_Name_button_and_click_on_it(Map<String,String> Data) throws InterruptedException
	{
		String Name = Data.get("Name");
		
		Action = new MobileActions(Driver);
		
		Action.scrollDown(4);
		
		Wait.until(ExpectedConditions.elementToBeClickable(super.findByText(Name)));
		super.findByText(Name).click();
		Thread.sleep(500);
	}
}