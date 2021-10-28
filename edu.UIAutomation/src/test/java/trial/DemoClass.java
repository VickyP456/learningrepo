package trial;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DemoClass {
	
	@Test
	public void browserLaunch() throws InterruptedException {
		
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");  
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://demoqa.com/alerts");
		/*
		 * driver.findElementById("email_create").sendKeys("qwerty@gmail.com");
		 * driver.findElementById("email").sendKeys("asdfgh@gmail.com");
		 * driver.findElementByXPath("//button[@id='SubmitCreate']/span").click();
		 */
        driver.findElementById("alertButton").click();
        
        Thread.sleep(5000);
        
        driver.switchTo().alert().accept();
        
        System.out.println("alert clicked");
        
        
		
	}

}
