package project.PageObjectModal;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Pages 
{
	WebDriver Driver;
	
	public Pages(WebDriver Driver)
	{
		PageFactory.initElements(Driver, this);
		this.Driver=Driver;
	}
	
	
	//Element locators
	@FindBy(xpath="//*[@*='Incredible India']")
	public WebElement Incradible_India;
	
	
	@FindBy(id="com.cleartrip.android:id/bottom_navigation_bar_item_container")
	public WebElement Navigation_Items;
	
	
	@FindBy(xpath="//*[@*='com.cleartrip.android:id/ctActionBar']/android.widget.TextView")
	public WebElement Detail_Page_Header;
	
	
	@FindBy(xpath="//*[@text='Incredible India']/../androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout/android.widget.TextView[1]")
	public List<WebElement> Indian_Cities;
	
	
	@FindBy(xpath="//*[@*='Navigate up']")
	public WebElement Go_Back;
	
	
	@FindBy(id="okBtn")
	public WebElement Location_OK;

	
	@FindBy(id="dismissBtn")
	public WebElement Location_Dismiss;
	
	
	@FindBy(id="filter_edittext")
	public WebElement Search_Edit;
	
	
	@FindBy(id="searchResTxt")
	public WebElement SearchResults;
	
	
	@FindBy(xpath="//*[contains(@resource-id,'localityName_in_setLocation')]")
	public List<WebElement> AutoSuggestedCities; 
}
