package Tests;

import org.testng.annotations.Test;

import businesslogics.Login_Business_Logics;
import businesslogics.Setting_Business_Logics;
import init.SetUpClass;

public class TC01 extends SetUpClass {

	@Test
	public void meth1() throws Exception {

		Login_Business_Logics login = new Login_Business_Logics(driver);
		

		login.login_wc3School();

		System.out.println("runnning TC01");

		

	}

}
