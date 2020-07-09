package project.TestScripts;


import java.awt.AWTException;
import java.net.MalformedURLException;
import java.util.*;

import cucumber.api.*;
import cucumber.api.java.en.*;
import project.PageObjectModal.Pages;
import project.Utils.*;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class Test_Scripts_00 extends ProjectUtilities
{
	protected Map<String, String> capabilities;
	protected Pages POM;
	protected MobileActions Action;
	
	String[] Text = {"Incredible India","SEE ALL CITIES","Across the oceans"};
	
	
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
		
		Wait.until(ExpectedConditions.elementToBeClickable(POM.Indian_Cities.get(0)));
	}

	
	@Given("^Slide and click on the (.*) block$")
	public void Slide_to_the_City_block_from_dash_board(String Name)
	{
		POM = new Pages(Driver);
		Action = new MobileActions(Driver);
		
		Action.slideAndSelectOne(POM.Indian_Cities, Name);
	}

	
	@Then("^Verify the name of the selected (.*)$")
	public void Verify_the_name_of_the_selected_city(String City)
	{
		POM = new Pages(Driver);
		
		Wait.until(ExpectedConditions.visibilityOf(POM.Detail_Page_Header));
		Assert.assertEquals(City.toUpperCase(), POM.Detail_Page_Header.getText().toUpperCase());
	}
	
	
	@Then("^Scroll to (.*) button and click on it$")
	public void Scroll_to_Name_button_and_click_on_it(String Name)
	{
		Action = new MobileActions(Driver);
		
		Action.scrollDown(3);	
		
		Wait.until(ExpectedConditions.elementToBeClickable(super.findByText(Name)));
		super.findByText(Name).click();
	}
	

	@Then("^Type (.*) inside the search edit$")
	public void type_City_inside_the_search_edit(String Name) throws AWTException, InterruptedException
	{
		POM = new Pages(Driver);
		Action = new MobileActions(Driver);
		
		Wait.until(ExpectedConditions.visibilityOf(POM.Search_Edit));
		Thread.sleep(100);

		Action.roboTyping(Name);
		
		Thread.sleep(200);
	}

	
	@Then("^Verify the search results for (.*)$")
	public void Verify_the_search_results_for_City(String City) throws InterruptedException
	{
		POM = new Pages(Driver);
		
		Wait.until(ExpectedConditions.attributeContains(POM.SearchResults, "text", "Search results (1)"));
		Thread.sleep(200);

		Wait.until(ExpectedConditions.visibilityOfAllElements(POM.AutoSuggestedCities));
		List<WebElement> Cities = POM.AutoSuggestedCities;
		
		for(WebElement C : Cities)
			Assert.assertTrue(C.getText().toUpperCase().startsWith(City.toUpperCase()));
	}
	
	
	@Then("^Select the best matched search result$")
	public void Select_the_best_matched_search_result()
	{
		POM = new Pages(Driver);
		
		Wait.until(ExpectedConditions.elementToBeClickable(POM.AutoSuggestedCities.get(0)));
		POM.AutoSuggestedCities.get(0).click();
	}
	
	
	@Then("^Navigate back to the dash board$")
	public void Navigate_back_to_the_dash_board() 
	{
		POM = new Pages(Driver);
		Action = new MobileActions(Driver);
		
		Wait.until(ExpectedConditions.elementToBeClickable(POM.Go_Back));
		POM.Go_Back.click();
		
		Wait.until(ExpectedConditions.visibilityOf(POM.Navigation_Items));
		Wait.until(ExpectedConditions.visibilityOf(POM.Navigation_Items));
		
		Action.scrollByText(Text[0]);
		
		Assert.assertTrue(POM.Incradible_India.isDisplayed());
	}
	
	
	@Then("^Close the application$")
	public void Close_the_application()
	{
		Driver.closeApp();
	}
}