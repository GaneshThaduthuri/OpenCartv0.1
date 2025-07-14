package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC001_ValidateRegistration extends BaseClass{
	//Testcase1: validate registration of user
	//WebDriver driver;
	//public TC001_ValidateRegistration(WebDriver driver){
		//super(driver);
		
	//}
    @Test(groups="Sanity")
	public void validating_Registration() {
    	
    	try {
    		
    	logger.info("Home Page Test has been started..");
	HomePage hp = new HomePage(driver);
	logger.info("clicked on my action option..");
	hp.myActClick();
	logger.info("clicked on registration option..");
	hp.regOptClick();
	
	
	logger.info("this is for random number creation only..");
	String ranPwd = randomNumberCreation();
	logger.info("Registration page is started and adding detail..");
	
	
    RegistrationPage reg = new RegistrationPage(driver);
    reg.fNameAct("demo");
    reg.lNameAct("demo1");
    reg.emailAct(randomAlphaNumeric()+".in");
    reg.telephoneAct(randomNumberCreation());
    reg.pwdAct(ranPwd+"aa");  //i want to intentionally fail this
    reg.cnfPwdAct(ranPwd);
    reg.radioBtnAct();
    reg.chkBoxAct();
    logger.info("submit button clicked...");
    reg.submitBtnAct();
    String msg = reg.valMsgAct();
    logger.info("checking the assertions...");
    Assert.assertEquals(msg,"Password confirmation does not match password!");
    logger.info("assertion passed..");
    	}
    	catch(Exception e) {
    		logger.info("test failed");
    		logger.debug("debug the test....");
    		Assert.fail();
    	
    	}
    
}
    
}
