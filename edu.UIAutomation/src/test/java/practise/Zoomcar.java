package practise;

import org.testng.annotations.BeforeTest;

public class Zoomcar extends BrowserLanuch{

	@BeforeTest
	public void loadRedBus()
	{
		browserlaunch("https://www.erail.in/");

	}
}
