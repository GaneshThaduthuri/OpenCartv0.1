package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;

public class LoginPage extends BaseClass{
	
	public LoginPage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement userNameInput;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement pwdInput;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginB;
	
	

	public void userInputAct(String email) {
		userNameInput.sendKeys(email);
	}
	
	public void pwdInputAct(String pwd) {
		pwdInput.sendKeys(pwd);
	}
	
	public void loginBtn() {
		loginB.click();
	}
	
	
}
