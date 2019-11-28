package project.Base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;

public class BaseClass 
{
	public static AppiumDriver<MobileElement> launchSession( Map<String, String> cap ) throws MalformedURLException
	{
		URL url = new URL( cap.get( "URL" ) );
		
		DesiredCapabilities DCap = new DesiredCapabilities();
		DCap.setCapability( "platformName" , cap.get( "platformName" ));
		DCap.setCapability( "platformVersion" , cap.get( "platformVersion" ));
		DCap.setCapability( "deviceName" , cap.get( "deviceName" ));
		DCap.setCapability( "app" , cap.get( "app"));
		DCap.setCapability( "automationName" , cap.get( "automationName" ));
		DCap.setCapability( "autoGrantPermissions" , Boolean.parseBoolean( cap.get( "autoGrantPermissions" ) ) );
		
		AppiumDriver<MobileElement> D = new AndroidDriver<MobileElement> ( url , DCap );
		
		return D;
	}
}
