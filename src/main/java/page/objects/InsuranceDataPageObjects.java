package page.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.BaseClass;

public class InsuranceDataPageObjects extends BaseClass {
	
	@FindBy(id="firstname")
	WebElement txt_firstname;
	
	@FindBy(id="lastname")
	WebElement txt_lastname;
	
	@FindBy(id="birthdate")
	WebElement date_birthdate;
	
	/////gender
	@FindBy(xpath = "//input[@name='Gender']/parent::label")
	List<WebElement> rdo_Gender;
	
	@FindBy(id="country")
	WebElement dd_country;
	
	@FindBy(id="zipcode")
	WebElement txt_zipcode;
	
	@FindBy(id="city")
	WebElement txt_city;
	
	@FindBy(id="occupation")
	WebElement dd_occupation;
	
	////hobbies
	@FindBy(xpath = "//input[@name='Hobbies']/parent::label")
	List<WebElement> chk_hobbies;
	
	@FindBy(id="website")
	WebElement txt_website;
	
	@FindBy(id="open")
	WebElement btn_PictureOpenButton; 
	
	@FindBy(id="nextenterproductdata")
	WebElement btn_Next;

	//Object initialization
	
	public InsuranceDataPageObjects() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions

	public void enterInsuranceData() throws Exception {
		cm.sendKeys(txt_firstname, "testFirstName");
		cm.sendKeys(txt_lastname, "testlastName");
		cm.sendKeys(date_birthdate, "11/11/2000");
		cm.selectRadioButtonValue(rdo_Gender, "Male");
		cm.selectDropdownOption(dd_country, "India");
		cm.sendKeys(txt_zipcode, "400098");
		cm.selectDropdownOption(dd_occupation, "Farmer");
		cm.selectCheckBoxes(chk_hobbies, "Speeding");
		cm.sendKeys(txt_website, "www.google.com");
	}
	
	public void clickOnNextButton() {
		btn_Next.click();
	}
}
