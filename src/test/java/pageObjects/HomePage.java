package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;

public class HomePage extends BaseClass{
	
	
	public HomePage(WebDriver driver){
		super(driver);
	}
	
	//Locating WebElements
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement myAction;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement registerOpt;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement loginBtn;
	
	
	//actions
	public void myActClick(){
		myAction.click();
	}
	
	public void regOptClick() {
		registerOpt.click();
	}
	
	public void loginOptClick() {
		loginBtn.click();
	}
	
	
	
	
}
