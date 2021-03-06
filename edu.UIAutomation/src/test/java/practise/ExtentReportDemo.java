package practise;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportDemo extends BrowserLanuch{
	ExtentReports reports;
	ExtentTest test;
	
	@Test
	public void reportgeneration() {
		
		Logger log = LogManager.getLogger();
		
		browserlaunch("https://www.google.com/intl/en-GB/gmail/about/#");
		
		reports =new ExtentReports("./reports/ExexctionReport123.html"); 
		test = reports.startTest("ReportDemo");
		
		driver.findElementByXPath("(//span[text()='Create an account'])[1]").click();
		
		String val = driver.getTitle();
		System.out.println("Tile of the page is ::"+val);
		log.info("Tile of the page is ::"+val);

		//add the date & time and append it to the file name 
		  File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		  		  		 
		  File destination = new File("./snap/screenshot123.jpg");
		  
	
			  try {
				FileUtils.copyFile(source, destination);
			} catch (IOException e) {
				  System.out.println("Exception occured :: "+ e); 
				  log.error("Exception occured :: "+ e);
			} 
			  	
		  
		  
		  if(val.equalsIgnoreCase("Create your Google Account")) {
				test.log(LogStatus.PASS, "Testcases Executed successfully");
				log.warn("Testcases Executed successfully");

			}else {
				test.log(LogStatus.FAIL, "Error occured while Executing Testcases...."+test.addScreenCapture("./../snap/screenshot123.jpg"));
				System.out.println("Tile of the page is not getting populated correctly");
				log.info("Testcases Failed due to error");


			}
		  
		  
	}
	
	
	@AfterClass
	public void endTest() {
		reports.endTest(test);
		reports.flush();

		driver.close();

	}

}
