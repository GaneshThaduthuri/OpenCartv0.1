package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;


/*Data is valid  - login success - test pass  - logout
Data is valid -- login failed - test fail

Data is invalid - login success - test fail  - logout
Data is invalid -- login failed - test pass
*/

public class TC003LoginTestDDT extends BaseClass {
	
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups={"Regression","Master"})   //GETTING DATA PROVIODER FROM DIFFRENT CLASS.
	public void verify_loginDDT(String email,String pwd , String exp)
	{
		logger.info("**** Starting TC003LoginTestDDT *****");
			
		//Home page
			HomePage hp=new HomePage(driver);
			hp.myActClick();
			hp.loginOptClick(); //Login link under MyAccount
			System.out.println("home page done");
				
			
			//Login page
			LoginPage lp=new LoginPage(driver);
			lp.userInputAct(email);
			lp.pwdInputAct(pwd);
			lp.loginBtn(); //Login button
		
	
			//My Account Page
			MyAccountPage macc=new MyAccountPage(driver);
			boolean targetPage=macc.myAccountPageStatus();
			try {
			if(exp.equalsIgnoreCase("Valid"))
			{
				if(targetPage==true)
				{
					macc.clickLogOut();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			
			if(exp.equalsIgnoreCase("Invalid"))
			{
				if(targetPage==true)
				{
					macc.clickLogOut();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
	}
		catch(Exception e)
		{
			Assert.fail("An exception occurred: " + e.getMessage());
		}
			
		logger.info("**** Finished TC003LoginTestDDT *****");
	}
	
}







