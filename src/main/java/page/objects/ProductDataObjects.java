package page.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.BaseClass;

public class ProductDataObjects extends BaseClass {

	@FindBy(id="startdate")
	WebElement date_startdate;
	
	@FindBy(id="insurancesum")
	WebElement dd_insurancesum;
	
	@FindBy(id="meritrating")
	WebElement dd_meritrating;
	
	@FindBy(id="damageinsurance")
	WebElement dd_damageinsurance;
	
	////optional products
	@FindBy(xpath = "//input[@name='Optional Products[]']/parent::label")
	List<WebElement> chk_optionalProducts;
	
	@FindBy(id="courtesycar")
	WebElement dd_courtesycar;
	
	
	@FindBy(id="nextselectpriceoption")
	WebElement btn_Next;
	
	
	public ProductDataObjects() {
		PageFactory.initElements(driver,this);
	}
	
	public void enterProductData() throws Exception {
		cm.sendKeys(date_startdate, "01/07/2025");
		cm.selectDropdownOption(dd_insurancesum, "3.000.000,00");
		cm.selectDropdownOption(dd_meritrating, "Bonus 1");
		cm.selectDropdownOption(dd_damageinsurance, "No Coverage");
		cm.selectCheckBoxes(chk_optionalProducts, "Euro Protection");
		cm.selectDropdownOption(dd_courtesycar, "Yes");
	}
	
	public void clickOnNextButton() {
		btn_Next.click();
	}
}
