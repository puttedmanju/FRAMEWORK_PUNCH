package init;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utilities.Constants;

public class SetUpClass {

	protected WebDriver driver = null;
	String url = new Constants().Wc3_url;

	@BeforeClass
	public void launch_Bro() {

		System.setProperty("webdriver.chrome.driver", "F:\\study\\selenium\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to(url);
		driver.manage().window().maximize();

	}

	@AfterClass
	public void tear_Down_Page() {

		driver.close();
		driver.quit();

	}

	public void Extent_Reports() {

	}

}
