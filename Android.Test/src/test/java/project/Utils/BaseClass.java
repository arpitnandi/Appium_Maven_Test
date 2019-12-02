package project.Utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;

public class BaseClass 
{
	public AppiumDriver<MobileElement> D = null;
	public WebDriverWait W = null;
	public Actions A = null;
	
	public AppiumDriver<MobileElement> launchSession( Map<String, String> cap, int Timeout, int Polling ) throws MalformedURLException, InterruptedException
	{
		URL url = new URL( cap.get( "URL" ) );
		
		DesiredCapabilities DCap = new DesiredCapabilities();
		DCap.setCapability( "platformName" , cap.get( "platformName" ) );
		DCap.setCapability( "platformVersion" , cap.get( "platformVersion" ) );
		DCap.setCapability( "deviceName" , cap.get( "deviceName" ) );
		DCap.setCapability( "app" , cap.get( "appPath" ) + cap.get( "app" ) );
		DCap.setCapability( "automationName" , cap.get( "automationName" ) );
		DCap.setCapability( "autoGrantPermissions" , Boolean.parseBoolean( cap.get( "autoGrantPermissions" ) ) );
		
		D = new AndroidDriver<MobileElement> ( url , DCap );
		
		D.manage().timeouts().implicitlyWait( Timeout, TimeUnit.SECONDS );
		W = new WebDriverWait( D, Polling );
		A = new Actions( D );
		
		return D;
	}

	public WebElement element( String By, String locator )
	{
		WebElement E = null;

		if( By.endsWith( "accessibilityId" ) )
			E = D.findElementByAccessibilityId( locator );
		
		if( By.endsWith( "id" ) )
			E = D.findElementById( locator );
		
		if( By.endsWith( "class" ) )
			E = D.findElementByClassName( locator );
		
		if( By.endsWith( "cssSelector" ) )
			E = D.findElementByCssSelector( locator );

		if( By.endsWith( "linkText" ) )
			E = D.findElementByLinkText( locator );
		
		if( By.endsWith( "name" ) )
			E = D.findElementByName( locator );

		if( By.endsWith( "partialLinkText" ) )
			E = D.findElementByPartialLinkText( locator );

		if( By.endsWith( "tagName" ) )
			E = D.findElementByTagName( locator );

		if( By.endsWith( "xPath" ) )
			E = D.findElementByXPath( locator );
		
		return E;
	}
	
	public List<MobileElement> elements( String By, String locator )
	{
		List<MobileElement> Es = new ArrayList<MobileElement> ();

		if( By.endsWith( "accessibilityId" ) )
			Es = D.findElementsByAccessibilityId( locator );
		
		if( By.endsWith( "id" ) )
			Es = D.findElementsById( locator );
		
		if( By.endsWith( "class" ) )
			Es = D.findElementsByClassName( locator );
		
		if( By.endsWith( "cssSelector" ) )
			Es = D.findElementsByCssSelector( locator );

		if( By.endsWith( "linkText" ) )
			Es = D.findElementsByLinkText( locator );
		
		if( By.endsWith( "name" ) )
			Es = D.findElementsByName( locator );

		if( By.endsWith( "partialLinkText" ) )
			Es = D.findElementsByPartialLinkText( locator );

		if( By.endsWith( "tagName" ) )
			Es = D.findElementsByTagName( locator );

		if( By.endsWith( "xPath" ) )
			Es = D.findElementsByXPath( locator );
		
		return Es;
	}
}
