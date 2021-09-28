package businesslogics;

import org.openqa.selenium.WebDriver;

import pageObject.Login_Page_Objects;
import utilities.Element_Actions;

public class Login_Business_Logics {
	WebDriver driver = null;

	public Login_Business_Logics(WebDriver screen) {
		driver = screen;
	}

	Element_Actions action = new Element_Actions();
	Login_Page_Objects login_PO = new Login_Page_Objects();

	public void login_wc3School() {

		action.clickElement(driver, login_PO.Login_button_1);
		action.set_Values(driver, login_PO.Input_Email, "puttedmanjunath@gmail.com");
		action.set_Values(driver, login_PO.Input_Password, "3rb05@TE009");
		action.clickElement(driver, login_PO.Login_button_2);
		System.out.println("login succesful");
		action.wait_SomeTime(driver, login_PO.prifil_Name);

	}

}
