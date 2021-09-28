package businesslogics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageObject.Setting_Page_Objects;
import utilities.Element_Actions;

public class Setting_Business_Logics {
	
	WebDriver driver = null;

	public Setting_Business_Logics(WebDriver screen) {
		driver = screen;
	}

	Element_Actions action = new Element_Actions();
	Setting_Page_Objects setting_PO = new Setting_Page_Objects();
	
	public void setting_module() throws Exception {
		
		action.clickElement(driver, setting_PO.setting);
		
		Thread.sleep(2000);
		
		if(action.isElementDisplayed(driver, setting_PO.button_update_profile)){

			System.out.println("Update profile Element is Present");

			}else{

			System.out.println("Update profile Element is not Present");

			}
		
	}

}
