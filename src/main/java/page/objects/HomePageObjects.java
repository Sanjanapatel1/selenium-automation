package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.BaseClass;

public class HomePageObjects extends BaseClass {
	
	@FindBy(id="nav_automobile") 
	WebElement link_automobile;
	
	@FindBy(id="nav_truck")
	WebElement link_truck;

	@FindBy(id="nav_camper")
	WebElement link_camper;
	
	@FindBy(id="nav_motorcycle")
	WebElement link_motorcycle;

	//Object initialization
	
	public HomePageObjects() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public String homePageTitle() {
		return driver.getTitle();
	}
	
	public void clickOnMotorcycleLink() {
		cm.click(link_automobile);	
	}
	
	
}
