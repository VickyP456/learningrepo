package trial;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class DemoSelectClass {
@Test 
	
	public void browserLaunch() throws InterruptedException  {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		RemoteWebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		driver.findElementById("email_create").sendKeys("vicky4453@gmail.com");
		driver.findElementById("SubmitCreate").click();
	
				
		WebElement state = driver.findElementById("id_state");
		Select objSelect= new Select(state);
		objSelect.selectByValue("51");
		
		Thread.sleep(5000);
		objSelect.selectByVisibleText("Pennsylvania");
		
		
		
		
	}

}
