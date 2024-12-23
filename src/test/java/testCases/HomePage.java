package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import page.objects.HomePageObjects;
import testBase.BaseClass;

public class HomePage extends BaseClass{
	
//	HomePageObjects homePage= new HomePageObjects();
	
	@Test (priority =0)
	public void verify_homePageTitle() {
		String actualPageTitle = homePage.homePageTitle();
		String expectedPageTitle = "Tricentis Vehicle Insurance";
		Assert.assertEquals(actualPageTitle, expectedPageTitle, "Page title is not as expected");
	}

	@Test (priority =1)
	public void homePageTitle_errortest() {
		String actualPageTitle = homePage.homePageTitle();
		String expectedPageTitle = "Tricentis Vehicle Insurance";
		Assert.assertEquals(actualPageTitle, expectedPageTitle, "Page title is not as expected");
	}
	
	@Test (priority =2)
	public void clickOn_automobileLink() {
		homePage.clickOnMotorcycleLink();
	}
	
}
