package practise;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TakingSnapshot extends BrowserLanuch {

	@Test
	public void takeScreenShot() throws InterruptedException {

		browserlaunch("https://oceanacademy.in/");
		driver.findElementByXPath("(//a[@id='ab'])[1]/i").click();
		
		WebDriverWait wait = new WebDriverWait(driver,45);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("(//button[text()='BOOK NOW'])[1]")));
				
		//30 sec		
		//Thread.sleep(30000);
		
		//add the date & time and append it to the file name 
		  File source = driver.getScreenshotAs(OutputType.FILE);
		  		  		 
		  File destination = new File("./snap/screenshot.jpg");
		  
		  try {
			  FileUtils.copyFile(source, destination); 
			  } 
		  catch (IOException e) {
			  System.out.println("Exception occured :: "+ e); 
			  }	 
		  
	}
	
	
	@AfterTest
	public void browserClose() {
		driver.close();
	}

}
