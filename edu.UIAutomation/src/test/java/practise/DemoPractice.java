package practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class DemoPractice extends BrowserLanuch{
	
	
	@Test 
	public void testExecution(String cityName) throws InterruptedException  {
		
		browserlaunch("http://automationpractice.com/index.php");
				
		driver.findElementByXPath("//a[@class='login']").click();
		driver.findElementById("email_create").sendKeys("vicky4456@gmail.com");
		driver.findElementById("email_create").sendKeys(cityName);
		driver.findElementByXPath("//button[@id='SubmitCreate']/span").click();
		driver.findElementById("customer_firstname").sendKeys("Vignesh");
		driver.findElementById("customer_lastname").sendKeys("Vicky");
		driver.findElementById("passwd").sendKeys("Vicky@456");
		
		WebElement day = driver.findElementById("days");
		Select obj1 = new Select(day);
		obj1.selectByValue("18");
		
		WebElement month = driver.findElementById("months");
		Select obj2 = new Select(month);
		obj2.selectByIndex(12);
		
		WebElement year = driver.findElementById("years");
		Select obj3 = new Select(year);
		obj3.selectByValue("1998");
		
		driver.findElementById("newsletter").click();
		driver.findElementById("optin").click();
		driver.findElementById("company").sendKeys("TCS");
		driver.findElementById("address1").sendKeys("moolakulam");
		driver.findElementById("address2").sendKeys("reddiarpalayam");
		driver.findElementById("city").sendKeys("puducherry");
		
		WebElement state = driver.findElementById("id_state");
		Select obj4 = new Select(state);
		obj4.selectByVisibleText("Delaware");
		
		driver.findElementById("other").sendKeys("ntg");
		driver.findElementById("phone").sendKeys("8610764870");
		driver.findElementById("phone_mobile").sendKeys("67568979");
		driver.findElementById("alias").clear();
	}
	
	@AfterMethod
	public void browserClose() {
		driver.close();
		
	}

}
