package ProjectUtils;


import java.io.*;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;


public class Uitilities 
{
	protected static AppiumDriver<MobileElement> Driver;
	protected static WebDriverWait Wait;
	private String properties = "/src/test/java/JSON_Properties/TestProperties.json";
	
	
	protected AppiumDriver<MobileElement> launchSession(String Device, int Timeout, int Polling ) throws InterruptedException, IOException, ParseException
	{
		JSONObject Values = this.readProperties( System.getProperty("user.dir") + properties );
		
		URL url = new URL( Values.get("URL").toString() );
		
		DesiredCapabilities Capabilities = new DesiredCapabilities();
		Capabilities.setCapability( "platformName" , Values.get( "platformName" ).toString() );
		Capabilities.setCapability( "automationName" , Values.get( "automationName" ).toString() );
		Capabilities.setCapability( "udid" , Device );
		Capabilities.setCapability( "app" , Values.get( "app" ).toString() );
		Capabilities.setCapability( "appWaitActivity", Values.get("appWaitActivity").toString() );
		
		Driver = new AndroidDriver<MobileElement> ( url , Capabilities );
		
		Driver.manage().timeouts().implicitlyWait( Timeout, TimeUnit.MILLISECONDS );
		Wait = new WebDriverWait( Driver, Polling );
		
		return Driver;
	}

	
	protected MobileElement findByText(String Text)
	{
		return (MobileElement) Driver.findElementByXPath("//*[@text='"+Text+"']");
	}
	
	
	protected JSONObject readProperties(String file) throws IOException, ParseException
	{
		FileReader DesiredCapabilities = new FileReader( file );
		JSONObject JSON = (JSONObject) new JSONParser().parse( DesiredCapabilities );
		JSONObject Properties = (JSONObject) JSON.get("DesiredCapabilities");
		
		return Properties;
	}
}
