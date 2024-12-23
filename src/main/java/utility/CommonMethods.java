package utility;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import testBase.BaseClass;

public class CommonMethods extends BaseClass {

	public static WebDriver driver;

	public void click(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(element + "Element not found");
		}
	}

	public void clear(WebElement element) {
		try {
			element.clear();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void sendKeys(WebElement element, String value) {
		try {
			element.clear();
			element.sendKeys(value);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String getText(WebElement element) {
		String text = "";
		try {
			text= element.getText();
			return text;
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return text;
	}

	public void selectDropdownOption(WebElement element, String valueToBeSelected) throws Exception {
		Select os = new Select(element);
		try {
			os.selectByVisibleText(valueToBeSelected);
		} catch(Exception e) {
			throw new Exception("Value is not present in dropdown for WebElement: "+element + "Value to be selected is: "+valueToBeSelected);
		}
	}
	
	//Select radio button
	public void selectRadioButtonValue(List<WebElement> element, String valueToBeSelected) {
		for (WebElement ref : element) {
			if(ref.getText().equalsIgnoreCase(valueToBeSelected)) {
				ref.click();
				break;
			}
			
		}
	}
	
	//selecting check boxes
		public void selectCheckBoxes(List<WebElement> element, String checks) {
			String[] checksArray = checks.split(",");
			for (String str : checksArray) {  
				for (WebElement ele : element) {
					if(ele.getText().equalsIgnoreCase(str)) {
						ele.click();
						break;
					}
				}
			}
			
		}
		
	//scroll down page
		public void scrollDown() {
			js.executeScript("window.scrollBy(0, 500);");
		}

}
