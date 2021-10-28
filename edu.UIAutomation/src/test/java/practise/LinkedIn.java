package practise;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class LinkedIn {
	
@Test 
	
	public void browserLaunch() throws InterruptedException  {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		RemoteWebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.linkedin.com/signup");
		driver.findElementByXPath("//button[@class = 'third-party-join__btn third-party-join__google-btn']/span").click();
		Thread.sleep(5000);
		driver.findElementByCssSelector("identifierId").sendKeys("vignesh575768@gmail.com");
	//	driver.findElementByXPath("//input[@type='email']").sendKeys("vignesh575768@gmail.com");
		
}
}