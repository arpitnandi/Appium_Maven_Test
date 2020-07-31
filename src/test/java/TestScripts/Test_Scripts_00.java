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
	public String Emulator = "emulator-5554";
	public String Galaxy = "Galaxy_Nexus_API_22";
	public String Pixel = "Pixel_API_29";
	
	
	private Pages POM;
	private MobileActions Action;
	
	
	@Given("^Session is started$")
	public void Session_is_started() throws InterruptedException, IOException, ParseException
	{
		Driver = launchSession(Emulator,15000, 5000);
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
	public void Slide_to_the_City_block_from_dash_board(String Name) throws InterruptedException
	{
		POM = new Pages(Driver);
		Action = new MobileActions(Driver);

		Thread.sleep(1000);
		Wait.until(ExpectedConditions.visibilityOf(POM.Indian_Cities.get(2)));
		Action.slideAndSelectOne(POM.Indian_Cities, Name);
	}

	
	@Then("^Verify the name of the selected (.*)$")
	public void Verify_the_name_of_the_selected_city(String City)
	{
		POM = new Pages(Driver);

		Wait.until(ExpectedConditions.visibilityOf(POM.Detail_Page_Header));
		Assert.assertEquals(City.toLowerCase(), POM.Detail_Page_Header.getText().toLowerCase());
	}
	
	
	@Then("^Scroll to Name button and click on it$")
	public void Scroll_to_Name_button_and_click_on_it(Map<String,String> Data) throws InterruptedException
	{
		String Name = Data.get("Name");
		
		Action = new MobileActions(Driver);
		
		Action.scrollDown(4);
		
		Wait.until(ExpectedConditions.elementToBeClickable(super.findByText(Name)));
		super.findByText(Name).click();
		Thread.sleep(1000);
	}
}