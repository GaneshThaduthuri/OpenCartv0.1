package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginValidation extends BaseClass{

	@Test(groups={"Regression","Master"})
	public void loginValidation() {
		try {
		logger.info("*********TC_002Login_Test********");
		HomePage hp=new HomePage(driver);
		hp.myActClick();
		hp.loginOptClick();
		
		logger.info("Login page opened and now we need to enter creds");
		LoginPage lp = new LoginPage(driver);
		lp.userInputAct(p.getProperty("email"));
		lp.pwdInputAct(p.getProperty("pwd"));
		lp.loginBtn();
		
		MyAccountPage map = new MyAccountPage(driver);
		String t = map.myActVerif();
		Assert.assertEquals(t, "My Account");
		logger.info("*********Completed Test********");
	}catch(Exception e) {
		System.out.println("Test TC002 failed...");
	}
		
	}

		
		
	

}
