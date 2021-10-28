package practise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Erail extends BrowserLanuch {
	@BeforeTest
	public void loadRedBus()
	{
		browserlaunch("https://www.erail.in/");

	}
	@Test(priority=1)
	public void print() throws InterruptedException 
	{
		Thread.sleep(5000);
		driver.findElementByXPath("//input[@id ='txtStationFrom']").clear();
		driver.findElementByXPath("//input[@id='txtStationTo']").clear();
		Thread.sleep(2000);
		driver.findElementByXPath("//input[@id ='txtStationFrom']").sendKeys("MAS");
		driver.findElementByXPath("//div[@title ='Mgr Chennai Ctr']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//input[@id='txtStationTo']").clear();
		Thread.sleep(2000);
		driver.findElementByXPath("//input[@id ='txtStationTo']").sendKeys("SBC");
		driver.findElementByXPath("//div[@title='Ksr Bengaluru']").click();
		driver.findElementById("chkSelectToOnly").click();
		driver.findElementByXPath("//input[@id='chkSelectFromOnly']").click();
		
		List<WebElement> elementName2 = driver.findElements(By.xpath("//div[@id='divMainWrapper']/div/div/table/tbody/tr"));
		
		int k = elementName2.size();
        System.out.println("No. of Trains Available : "+(k-2));
        for(int i=1;i<=k-1;i++)
        {
        	if(i==9)
        	{
        		continue;
        	}
        	else
        	{
        	String train_no = driver.findElementByXPath("//div[@id='divMainWrapper']/div/div/table[1]/tbody/tr["+i+"]/td[1]").getText();
        	System.out.println("Train No."+i+" is "+train_no);
        	}
        }
        int i =1;
        String a = driver.findElementByXPath("//div[@id='divMainWrapper']/div/div/table["+i+"]/tbody/tr["+i+"]/td["+i+"]").getText();
        System.out.println("Train Name : "+a);
	}
	@AfterTest
	public void CloseBrowser() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.close();
	}

}
