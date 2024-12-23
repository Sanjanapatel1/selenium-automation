package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.BaseClass;

public class VehicalDataPageObjects extends BaseClass{
	
	@FindBy(id="make")
	WebElement dd_make;

	@FindBy(id="model")
	WebElement dd_model;
	
	@FindBy(id="fuel")
	WebElement dd_fuelType;

	@FindBy(xpath="//input[@id='cylindercapacity']")
	WebElement txt_cylindercapacity;

	@FindBy(xpath = "//input[@id='cylindercapacity']/following-sibling::span[@class='error']")
	WebElement error_cylinderCapacity;

	@FindBy(id="engineperformance")
	WebElement txt_engineperformance;

	@FindBy(id="dateofmanufacture")
	WebElement date_dateofmanufacture;

	@FindBy(id="numberofseats")
	WebElement dd_numberofseats;

	@FindBy(id="listprice")
	WebElement txt_listprice;

	@FindBy(id="annualmileage")
	WebElement txt_annualmileage;

	@FindBy(id="nextenterinsurantdata")
	WebElement btn_Next;

	//Object initialization
	
	public VehicalDataPageObjects() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public void enterVehicleData() throws Exception {
		cm.selectDropdownOption(dd_make, "Audi");
		txt_engineperformance.sendKeys("200");
		date_dateofmanufacture.sendKeys("11/11/2011");
		cm.selectDropdownOption(dd_numberofseats, "5");
		cm.selectDropdownOption(dd_fuelType, "Gas");
		cm.sendKeys(txt_listprice, "5000");
		cm.sendKeys(txt_annualmileage, "100");
	}

	public void clickOnNextButton() {
		btn_Next.click();
	}
}
