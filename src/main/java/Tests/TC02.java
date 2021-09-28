package Tests;

import org.testng.annotations.Test;

import businesslogics.Login_Business_Logics;
import businesslogics.Setting_Business_Logics;
import init.SetUpClass;

public class TC02 extends SetUpClass {
	@Test
	public void meth1() throws Exception {

		Setting_Business_Logics setting = new Setting_Business_Logics(driver);
		Login_Business_Logics login = new Login_Business_Logics(driver);

		login.login_wc3School();
		
		Thread.sleep(2000);

		setting.setting_module();

		System.out.println("runjning TC02");

	}

}
