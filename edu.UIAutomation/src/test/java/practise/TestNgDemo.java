package practise;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNgDemo extends BrowserLanuch{
	@AfterMethod
	public void givingBillandgettingCash() throws InterruptedException {
		System.out.println("After Method ::: Bill generated ad payment made by card");
		Thread.sleep(5000);
	}
	
	@BeforeMethod
	public void gettingOrder() throws InterruptedException {
		System.out.println("Before Method ::: What would you like to have ......");
		Thread.sleep(5000);

	}
	
	@Test(priority=1)
	public void Hotelcus1() throws InterruptedException {
		browserlaunch("https://oceanacademy.in/");
		driver.findElementByXPath("(//a[@id='ab'])[1]/i").click();
		
		System.out.println("Test ::: Welcome to my Hotel!! Enjoy the day....Customer 1");
		Thread.sleep(5000);

	}

	//(enabled=false)
	@Test(priority=2)
	public void Hotelcus2() throws InterruptedException {
		System.out.println("Test ::: Welcome to my Hotel!! Enjoy the day....Customer 2");
		Thread.sleep(5000);	
	}
	
	@Test (priority=3, dependsOnMethods={"Hotelcus1"})
	public void Hotelcus3() throws InterruptedException {
		System.out.println("Test ::: Welcome to my Hotel!! Enjoy the day....Customer 3");
		Thread.sleep(5000);

	}
	@BeforeSuite
	public void cleanEnviroment() throws InterruptedException {
		System.out.println("Before Suite ::: Tales, chairs vesssels needs to be cleaned properly.....");
		Thread.sleep(5000);
	}
	
	
	
	
}
