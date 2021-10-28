package practise;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DemoFramesWindows {
	@Test

	public void browserLaunch() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.linkedin.com/signup");
		
		//Switch to frames
		
		/*
		 * driver.switchTo().frame(""); driver.switchTo().parentFrame();
		 * driver.switchTo().defaultContent();
		 */
		
		//Switch to windows
		
		String parentWindowName = driver.getWindowHandle();
		System.out.println(parentWindowName);
		driver.findElementByXPath("//span[text()='Join with Google']").click();		
		
		
		Set<String> abcd = driver.getWindowHandles();
		String secondWindowName = null;
		
		for (String val : abcd) {
			//System.out.println(val);
			
			if(!val.equalsIgnoreCase(parentWindowName)) {
				secondWindowName = val;
			}
			
		}
		
		System.out.println("secondWindowName : "+ secondWindowName);
		
		
		driver.switchTo().window(secondWindowName);
		
		driver.switchTo().window(parentWindowName);
		
	}
}
