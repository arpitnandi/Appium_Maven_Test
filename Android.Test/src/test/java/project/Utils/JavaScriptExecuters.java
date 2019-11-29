package project.Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavaScriptExecuters extends BaseClass
{
JavascriptExecutor JS = (JavascriptExecutor) D;
	
	public void scrollUp( long V )
	{
		JS.executeScript("window.scrollBy(-"+V+",0)");
	}
	
	public void scrollDown( long V )
	{
		JS.executeScript("window.scrollBy("+V+",0)");
	}
	
	public void scrollLeft( long H )
	{
		JS.executeScript("window.scrollBy(0,-"+H+")");
	}
	
	public void scrollRight( long H )
	{
		JS.executeScript("window.scrollBy(0,"+H+")");
	}
	
	public void scrollTop()
	{
		JS.executeScript("window.scrollTo(-document.body.scrollHeight,0)");
	}
	
	public void scrollBottom()
	{
		JS.executeScript("window.scrollTo(document.body.scrollHeight.0)");
	}
	
	public void scrollForElement( WebElement E )
	{
		JS.executeScript("arguments[0].scrollIntoView();",E);
	}
}
