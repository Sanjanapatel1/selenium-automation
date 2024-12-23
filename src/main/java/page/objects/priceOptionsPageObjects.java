package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.BaseClass;

public class priceOptionsPageObjects extends BaseClass {

	@FindBy(id="nextsendquote")
	WebElement btn_Next;
	
	public priceOptionsPageObjects() {
		PageFactory.initElements(driver,this);
	}
	
	public String getPriceOfSelectedOption(String plan) {
		String planXpath = "//table[@id='priceTable']//tr[1]//td[@data-label='"+plan+"']/span";
		return driver.findElement(By.xpath(planXpath)).getText();
		
		
	}
}
