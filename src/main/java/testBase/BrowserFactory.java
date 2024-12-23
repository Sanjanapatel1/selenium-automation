package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class BrowserFactory {

	public static WebDriver driver;
	
	public static WebDriver driver(String browser) throws Exception {
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();	
			return driver;
		}
		
		else if(browser.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
			return driver;
		}
		
		throw new Exception(browser + " not found");
		
	}
}
