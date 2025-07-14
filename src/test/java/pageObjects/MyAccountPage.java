package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;

public class MyAccountPage extends BaseClass{

	public MyAccountPage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="(//h2[normalize-space()='My Account'])[1]")
	WebElement myAccount;
	
	@FindBy(xpath="(//a[@class='list-group-item'][normalize-space()='Logout'])[1]")
	WebElement lOut;
	
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement myAccountPage;
	
	
	public String myActVerif() {
		return myAccount.getText();
		
	}
	
	public Boolean myAccountPageStatus() {
		return myAccountPage.isDisplayed();
	}
	
	public void clickLogOut() {
		lOut.click();
	}
}
