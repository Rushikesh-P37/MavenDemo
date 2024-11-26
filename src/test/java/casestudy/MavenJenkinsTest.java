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

	@Test
	public void searchCity() {
		
		//1 way-Using JavaScriptExecutor Finding the total number of iframes
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		Integer noOfFrames= Integer.parseInt(exe.executeScript("return window.length").toString());
		System.out.println("Number of frames are: "+noOfFrames);
		
		//2 way-Finding the total number of elements that have the tag iframe
//		List <WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
//		System.out.println("Total number of iframe are: "+ iframeElements.size());
		
		driver.switchTo().defaultContent();
	
		WebElement search = driver.findElement(By.xpath("//input[@value='']"));
		Actions action = new Actions(driver);
		action.sendKeys("Pune");
		action.sendKeys(search,Keys.DOWN);
		action.sendKeys(search,Keys.ENTER);
		action.perform();
		
	}
	

	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}

}
