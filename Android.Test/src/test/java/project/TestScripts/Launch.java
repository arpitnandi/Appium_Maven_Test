package project.TestScripts;

import java.util.*;

import io.appium.java_client.*;
import project.Base.*;

public class Launch extends BaseClass
{
	public static AppiumDriver<MobileElement> D = null;
	
	public static void main(String[] args) throws Exception 
	{
		Map<String, String> capabilities = new HashMap<String, String> ();
		
		capabilities.put( "URL", "http://localhost:4723/wd/hub" );
		capabilities.put( "platformName", "Android" );
		capabilities.put( "platformVersion", "8" );
		capabilities.put( "deviceName", "Pixel_XL_API_26" );
		capabilities.put( "app", "D:\\Download\\Cleartrip_com.cleartrip.android.apk" );
		capabilities.put( "automationName", "UiAutomator2" );
		capabilities.put( "autoGrantPermissions", "true" );
		
		D = launchSession( capabilities );
	}
}