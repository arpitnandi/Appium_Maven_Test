package project.Utils;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;


public class ProjectUtilities 
{
	protected static AppiumDriver<MobileElement> Driver;
	protected static WebDriverWait Wait;
	
	
	protected AppiumDriver<MobileElement> launchSession( Map<String, String> Capabilities, int Timeout, int Polling ) throws MalformedURLException, InterruptedException
	{
		URL url = new URL( Capabilities.get( "URL" ) );
		
		DesiredCapabilities DCapabilities = new DesiredCapabilities();
		DCapabilities.setCapability( "deviceName" , Capabilities.get( "deviceName" ) );
		DCapabilities.setCapability( "platformName" , Capabilities.get( "platformName" ) );
		DCapabilities.setCapability( "platformVersion" , Capabilities.get( "platformVersion" ) );
		DCapabilities.setCapability( "automationName" , Capabilities.get( "automationName" ) );
		DCapabilities.setCapability( "app" , Capabilities.get( "app" ) );
		DCapabilities.setCapability( "appPackage" , Capabilities.get( "appPackage" ) );
		DCapabilities.setCapability( "appWaitActivity", Capabilities.get("appWaitActivity") );
		
		Driver = new AndroidDriver<MobileElement> ( url , DCapabilities );
		
		Driver.manage().timeouts().implicitlyWait( Timeout, TimeUnit.MILLISECONDS );
		Wait = new WebDriverWait( Driver, Polling );
		
		return Driver;
	}
	
	
	protected MobileElement findByLocator(String Locator, String Value)
	{
		MobileElement E=null;
		
		if(Locator.equalsIgnoreCase("id"))
			E=Driver.findElementById(Value);
		
		if(Locator.equalsIgnoreCase("accessibilityId"))
			E=Driver.findElementByAccessibilityId(Value);
		
		if(Locator.equalsIgnoreCase("className"))
			E=Driver.findElementByClassName(Value);

		if(Locator.equalsIgnoreCase("name"))
			E=Driver.findElementByName(Value);
		
		if(Locator.equalsIgnoreCase("cssSelector"))
			E=Driver.findElementByCssSelector(Value);

		if(Locator.equalsIgnoreCase("image"))
			E=Driver.findElementByImage(Value);

		if(Locator.equalsIgnoreCase("linkText"))
			E=Driver.findElementByLinkText(Value);

		if(Locator.equalsIgnoreCase("partialLinkText"))
			E=Driver.findElementByPartialLinkText(Value);

		if(Locator.equalsIgnoreCase("tagName"))
			E=Driver.findElementByTagName(Value);

		if(Locator.equalsIgnoreCase("xpath"))
			E=Driver.findElementByXPath(Value);

		if(Locator.equalsIgnoreCase("custom"))
			E=Driver.findElementByCustom(Value);
		
		return E; 
	}

	
	protected MobileElement findByText(String Text)
	{
		return Driver.findElementByXPath("//*[@text='"+Text+"']");
	}
}
