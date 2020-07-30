package ProjectUtils;


import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.*;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;


@SuppressWarnings("rawtypes")
public class MobileActions extends Uitilities
{
	private AppiumDriver<MobileElement> Driver;
	private TouchAction Action;
	
	
	public MobileActions(AppiumDriver<MobileElement> Driver)
	{
		this.Driver = Driver;
	}
	
	
	public void scrollUp(int n)
	{
		Action = new TouchAction(Driver);
		
		Dimension Size = Driver.manage().window().getSize();
		
		int Width = (int) Size.width;
		int Height = (int) Size.height;
				
		while(n>0)
		{
			Action.press(PointOption.point(Width/2,Height/4)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(250))).moveTo(PointOption.point(Width/2,Height*3/4)).release().perform();
			n--;
		}
	}
	
	
	public void scrollDown(int n)
	{
		Action = new TouchAction(Driver);
		
		Dimension Size = Driver.manage().window().getSize();
		
		int Width = (int) Size.width;
		int Height = (int) Size.height;
		
		while(n>0)
		{
			Action.press(PointOption.point(Width/2,Height*3/4)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(250))).moveTo(PointOption.point(Width/2,Height/4)).release().perform();
			n--;
		}
	}
	
	
	public void scrollToElementById(MobileElement id)
	{
		Driver.findElement(MobileBy.AndroidUIAutomator("new IiScrollable(new UiScrollable(True)).scrollIntoView(new UiSelector().id("+ id +")))"));
	}
	
	
	public void scrollByText(String Text)
	{
		Driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\""+Text+"\"));"));
	}
	
	
	public void swipeBetweenElements(WebElement E1, WebElement E2)
	{
		Action = new TouchAction(Driver);	

		int x1 = E1.getLocation().getX() + E1.getSize().getWidth()/2;
		int y1 = E1.getLocation().getY() + E1.getSize().getHeight()/2;

		int x2 = E2.getLocation().getX() + E2.getSize().getWidth()/2;
		int y2 = E2.getLocation().getY() + E2.getSize().getHeight()/2;
		
		Action.press(PointOption.point(x2, y2)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(250))).moveTo(PointOption.point(x1, y1)).release().perform();
	}

	
	public void tapOnElement(String Name)
	{
		Action = new TouchAction(Driver);
		
		MobileElement E = super.findByText(Name);
		
		Action.tap(TapOptions.tapOptions().withElement(ElementOption.element(E))).release().perform();
	}
	
	
	public void slideAndSelectOne(List<WebElement> E, String Required)
	{
		boolean flag=true;
		
		while(flag)
		{
			Wait.until(ExpectedConditions.visibilityOfAllElements(E));
			
			for(int i=0 ; i<E.size() ; i++)
			{
				if(E.get(i).getText().equalsIgnoreCase(Required))
				{
					E.get(i).click();
					flag=false;
					break;
				}
			}
			if(flag)
				this.swipeBetweenElements(E.get(0), E.get(1));
		}
	}
	
	
	public void roboTyping(String Name) throws AWTException
	{
		Robot Robo = new Robot();

		Name=Name.toUpperCase();
		
		for(int i=0 ; i<Name.length() ; i++)
		{
			Robo.keyPress(Name.charAt(i));
			Robo.keyRelease(Name.charAt(i));
		}
	}
}
