package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Element_Actions {

	public void clickElement(WebDriver driver, String XPath) {

		driver.findElement(By.xpath(XPath)).click();

	}

	public void set_Values(WebDriver driver, String XPath, String value) {

		driver.findElement(By.xpath(XPath)).sendKeys(value);

		// driver.findElement(By.xpath(XPath)).sendKeys(PW);

	}

	public void wait_SomeTime(WebDriver driver, String xPath) {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));

	}

	public boolean isElementDisplayed(WebDriver driver, String xpath) {

		boolean isPresent = false;
		try {

			isPresent = driver.findElement(By.xpath(xpath)).isDisplayed();

		} catch (Exception e)

		{

			e.printStackTrace();
			return isPresent;
		}
		return isPresent;

	}

}
