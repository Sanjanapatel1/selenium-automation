package testBase;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import page.objects.HomePageObjects;
import page.objects.InsuranceDataPageObjects;
import page.objects.ProductDataObjects;
import page.objects.VehicalDataPageObjects;
import page.objects.priceOptionsPageObjects;
import utility.ConfigProperties;
import utility.ExtentReport;
import utility.Screenshot;

public class BaseClass extends ObjectsRepo{

	public static WebDriver driver;
	public static ExtentReports reports;
	public static ExtentTest test;
	public static JavascriptExecutor js;


	@BeforeSuite
	public static void launchBrowser() throws Exception {

		reports= ExtentReport.extentReportSetup();
		

		driver = BrowserFactory.driver(ConfigProperties.getProperty("browser"));
		driver.manage().window().maximize();
		driver.get(ConfigProperties.getProperty("url"));	
		
		js = (JavascriptExecutor) driver;
	}


	@BeforeTest public static void setupMethods() throws Exception {

		homePage = new HomePageObjects(); 
		vehicalDataPage = new VehicalDataPageObjects(); 
		insuranceDataPage = new InsuranceDataPageObjects();
		productDataPage = new ProductDataObjects();
		selectPriceOptions = new priceOptionsPageObjects();
	}


	@BeforeMethod
	public void onStart(ITestResult result) {
		test = reports.createTest(result.getMethod().getMethodName());
	}

	@AfterMethod
	public static void getResult(ITestResult result) throws InterruptedException {

		if (result.getStatus() == ITestResult.FAILURE) {
			Thread.sleep(2000);

			test.log(Status.FAIL, "Test Case: "+result.getName()+" is failed");
			test.addScreenCaptureFromPath(Screenshot.getScreenshot(result.getMethod().getMethodName()));	

			test.log(Status.FAIL, "Test Case Failed is "+result.getThrowable());
		} 
		else if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName() +" test passed");
		} 
		else {
			test.log(Status.SKIP, result.getName() +" test skipped");
		}
//				reports.endTest(test);
	}	

	@AfterTest
	public static void endReport() {
		reports.flush();
	}

	//	@AfterSuite
	public static void tearDown() {
		driver.close();
	}
}
