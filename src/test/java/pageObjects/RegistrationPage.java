package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;

public class RegistrationPage extends BaseClass {
	
	public RegistrationPage(WebDriver driver){
		super(driver);
	
	}
	
	
	//Webelements
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement fName;
	
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement lName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement telNum;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement pwd;
	
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement cnfPwd;
	
	@FindBy(xpath = "(//input[@value='0'])[1]")
	WebElement radioBtn;
	
	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkBox;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement submitBtn;
	
	@FindBy(xpath="//div[@class='text-danger']")
	WebElement validationMsg;
	
	
	//actions for above webElements
	public void fNameAct(String fn) {
		fName.sendKeys(fn);
	}
	
	public void lNameAct(String ln) {
		lName.sendKeys(ln);
	}
	
	public void emailAct(String em) {
		email.sendKeys(em);
	}
	
	public void telephoneAct(String tn) {
		telNum.sendKeys(tn);
	}
	
	public void pwdAct(String pw) {
		pwd.sendKeys(pw);
	}
	
	public void cnfPwdAct(String cpw) {
		cnfPwd.sendKeys(cpw);
	}
	
	public void radioBtnAct() {
		radioBtn.click();
	}
	
	public void chkBoxAct() {
		chkBox.click();
	}
	
	public void submitBtnAct() {
		submitBtn.click();
	}
	
	public String valMsgAct() {
		return validationMsg.getText();   //i want the validation msg in string
	}
	
	
}
