package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import page.objects.HomePageObjects;

public class VehicleData_ErrorTests {

HomePageObjects hm =new HomePageObjects();
	
	@Test
	public void verify_VehicleData() {
		String actualPageTitle = hm.homePageTitle();
		String expectedPageTitle = "test";
		Assert.assertEquals(actualPageTitle, expectedPageTitle, "Page title is not as expected");
	}
}
