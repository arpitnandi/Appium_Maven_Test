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
		DCapabilities.setCapability( "platformName" , Capabilities.get( "platformName" ) );
		DCapabilities.setCapability( "automationName" , Capabilities.get( "automationName" ) );
		DCapabilities.setCapability( "platformVersion" , Capabilities.get( "platformVersion" ) );
		DCapabilities.setCapability( "udid" , Capabilities.get( "udid" ) );
		DCapabilities.setCapability( "app" , Capabilities.get( "app" ) );
		DCapabilities.setCapability( "appWaitActivity", Capabilities.get("appWaitActivity") );
		
		Driver = new AndroidDriver<MobileElement> ( url , DCapabilities );
		
		Driver.manage().timeouts().implicitlyWait( Timeout, TimeUnit.MILLISECONDS );
		Wait = new WebDriverWait( Driver, Polling );
		
		return Driver;
	}

	
	protected MobileElement findByText(String Text)
	{
		return (MobileElement) Driver.findElementByXPath("//*[@text='"+Text+"']");
	}
}
