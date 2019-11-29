package project.Utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;

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
}
