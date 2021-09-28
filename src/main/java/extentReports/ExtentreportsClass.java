package extentReports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentreportsClass {
	
	public WebDriver driver;
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	@BeforeTest
	public void setExtent() {
		
		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("//C:\\WorkSpace\\ProjectPunch")+"/test_output/myReport.html");//C:\WorkSpace\ProjectPunch
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("functional report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("HostName", "local host");
		extent.setSystemInfo("os", "windows");
		extent.setSystemInfo("Tester", "Manju");
		extent.setSystemInfo("browser", "chrome");
				
	}
	
	@AfterTest
	public void endReport() {
		
		extent.flush();
	}
	
	@BeforeMethod
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", "F:\\study\\selenium\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/");

	}
		
	@Test
	public void hTMLText() {
		
		test = extent.createTest("HTMLTitleTest");
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "W3Schools Online Web Tutorials");
		
	}
	
	@Test
	public void hTMLLogoTest() {
				
		test = extent.createTest("hTMLLogoTest");
		Boolean status = driver.findElement(By.xpath("/html/body/div[3]/a[1]/i")).isDisplayed();
		Assert.assertTrue(status);
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		
		if (result.getStatus() == ITestResult.FAILURE) {
			
			   test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
			   test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent report
		
			   //String screenshotPath = NopCommerceTest.getScreenshot(driver, result.getName());
			  // test.addScreenCaptureFromPath(screenshotPath);// adding screen shot
			  } else if (result.getStatus() == ITestResult.SKIP) {
			   test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
			  }
			  else if (result.getStatus() == ITestResult.SUCCESS) {
			   test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
	}
		
	}
}

