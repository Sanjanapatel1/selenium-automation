package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import page.objects.HomePageObjects;
import testBase.BaseClass;

public class VehicleData_EndToEndTests extends BaseClass {
	
	@Test
	public void verify_VehicleData() throws Exception {
		vehicalDataPage.enterVehicleData();
		vehicalDataPage.clickOnNextButton();
		
		insuranceDataPage.enterInsuranceData();
		insuranceDataPage.clickOnNextButton();
		
		productDataPage.enterProductData();
		productDataPage.clickOnNextButton();
		
		
		  Assert.assertEquals(selectPriceOptions.getPriceOfSelectedOption("Gold"),"473.00", "Pricing for gold plan is not matching."); 
		  Assert.assertEquals(selectPriceOptions.getPriceOfSelectedOption("Silver"), "160.00", "Pricing for silver plan is not matching."); //
		  Assert.assertEquals(selectPriceOptions.getPriceOfSelectedOption("Platinum"), "929.00", "Pricing for platimum plan is not matching."); //
		  Assert.assertEquals(selectPriceOptions.getPriceOfSelectedOption("Ultimate"), "1,770.00", "Pricing for ultimate plan is not matching.");
		 		
	}
	
	
	
}
