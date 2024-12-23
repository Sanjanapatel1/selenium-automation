package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;

import testBase.BrowserFactory;

public class Screenshot {

	
	public static String getScreenshot(String screenshotName) {
		
		//Create Screenshot folder
		File directory = new File("Screenshots");
		if (! directory.exists()){
			directory.mkdir();
		}
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date date = new Date();
		String actualDate = format.format(date);
		
		//date
		String path = System.getProperty("user.dir")+"/Screenshots/"+ screenshotName+ "_" + actualDate
		+ ".jpeg";

		TakesScreenshot ts = (TakesScreenshot) BrowserFactory.driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(path);

		try {
			Files.copy(source, destination);
		} catch (IOException e) {
			System.out.println("Capture Failed " + e.getMessage());
		}
		return path;
	}
}
