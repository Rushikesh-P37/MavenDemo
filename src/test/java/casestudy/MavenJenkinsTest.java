package casestudy;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class MavenJenkinsTest {
	WebDriver driver;
	
	@BeforeTest
	public void OpenBrowser() {
		String driverPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", driverPath+ "//Drivers//chromedriver.exe");
	}
	

	@Test
	public void getURL() {
		driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.get("https://in.bookmyshow.com/");
	}
	

	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}

}
