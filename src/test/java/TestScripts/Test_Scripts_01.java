package TestScripts;


import java.awt.AWTException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import PageObjectModel.Pages;
import ProjectUtils.MobileActions;
import ProjectUtils.Uitilities;
import cucumber.api.java.en.Then;


public class Test_Scripts_01 extends Uitilities
{
	protected Pages POM;
	protected MobileActions Action;
	
	
	@Then("^Type (.*) inside the search edit$")
	public void type_City_inside_the_search_edit(String City) throws AWTException, InterruptedException
	{
		POM = new Pages(Driver);
		Action = new MobileActions(Driver);
		
		Wait.until(ExpectedConditions.visibilityOf(POM.Search_Edit));
		Thread.sleep(100);

		POM.Search_Edit.sendKeys(City);
		Thread.sleep(500);
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
	public void Select_the_best_matched_search_result() throws InterruptedException
	{
		POM = new Pages(Driver);
		
		Wait.until(ExpectedConditions.elementToBeClickable(POM.AutoSuggestedCities.get(0)));
		POM.AutoSuggestedCities.get(0).click();
		Thread.sleep(1000);
	}
	
	
	@Then("^Navigate back to the dash board$")
	public void Navigate_back_to_the_dash_board() throws InterruptedException 
	{
		POM = new Pages(Driver);
		Action = new MobileActions(Driver);
		
		Wait.until(ExpectedConditions.elementToBeClickable(POM.Go_Back));
		POM.Go_Back.click();
		
		Thread.sleep(1000);
		Wait.until(ExpectedConditions.visibilityOfAllElements(POM.Navigation_Items));
		
		Action.scrollUp(4);
		Assert.assertTrue(POM.Incradible_India.isDisplayed());
	}
	
	
	@Then("^Close the application$")
	public void Close_the_application()
	{
		Driver.closeApp();
	}
}
