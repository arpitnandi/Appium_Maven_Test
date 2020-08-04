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
	private String JSON_Properties = "/src/test/java/JSON_Properties/";
	private String PropertyFileName = "TestProperties.json";
	
	
	protected AppiumDriver<MobileElement> launchSession(String udid, int Timeout, int Polling ) throws InterruptedException, IOException, ParseException
	{
		JSONObject Array = this.getJsonObject(System.getProperty("user.dir")+JSON_Properties+PropertyFileName);
		JSONObject Value = (JSONObject) Array.get("DesiredCapabilities");
		
		URL url = new URL(Value.get("URL").toString());
		
		DesiredCapabilities Capabilities = new DesiredCapabilities();
		Capabilities.setCapability("platformName", Value.get("platformName"));
		Capabilities.setCapability("automationName", Value.get("automationName"));
		Capabilities.setCapability("udid", udid);
		Capabilities.setCapability("app", Value.get("app"));
		Capabilities.setCapability("appWaitActivity", Value.get("appWaitActivity"));
		
		Driver = new AndroidDriver<MobileElement> (url, Capabilities);
		
		Driver.manage().timeouts().implicitlyWait(Timeout, TimeUnit.MILLISECONDS);
		Wait = new WebDriverWait(Driver, Polling);
		
		return Driver;
	}

	
	protected MobileElement findByText(String Text)
	{
		return (MobileElement) Driver.findElementByXPath("//*[@text='"+Text+"']");
	}
	
	
	protected JSONObject getJsonObject(String FilePath) throws IOException, ParseException
	{
		FileReader JsonContaxt = new FileReader(FilePath);
		JSONObject Value = (JSONObject) new JSONParser().parse(JsonContaxt);
		
		return Value;
	}
}
