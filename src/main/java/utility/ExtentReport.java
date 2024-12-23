package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	
	public static ExtentReports reports;

	public static ExtentReports extentReportSetup() {
		
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date date = new Date();
		String actualDate = format.format(date);
		
		String reportpath = System.getProperty("user.dir") + "/Reports/ExecutionReport_"+actualDate+".html";
		
		ExtentSparkReporter spark = new ExtentSparkReporter(reportpath);
		reports = new ExtentReports();
		
		reports.setSystemInfo("Author:", "QA");
		reports.setSystemInfo("Browser:", "Chrome");
		reports.setSystemInfo("Selenium version:", "4.2.2");
		
		reports.attachReporter(spark);
		
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Test Document");
		spark.config().setReportName("QA Automation report");

		return reports;
		
	}
}
