package ContinentalFsCloudWeb.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ContinentalFsCloudWeb.BaseClass.TestBaseClassWeb;
import ContinentalFsCloudWeb.Utils.ActionKeywords;
//import LinkCxOWeb.utils.ActionKeywords;

public class WebLoginWithMobileNumber extends TestBaseClassWeb {

	public WebLoginWithMobileNumber() {
		super();
		PageFactory.initElements(driver, this);
	}

	ActionKeywords action = new ActionKeywords();

	@FindBy(xpath = "//input[@id=\"outlined-basic\"]")
	private WebElement EnterMobileNo;

	public void enterMobileNumbmer() {
//		waitForElementToLoad(EnterMobileNo);
		action.sendKeysElement(EnterMobileNo, "9162849798");
	}

	@FindBy(xpath = "//button[@aria-label='next']")
	private WebElement arrowBtn;

	public void ClickOnArrowButton() {
		action.clickElement(arrowBtn);
	}

	@FindBy(xpath = "//input[@aria-label='Please enter verification code. Digit 1']")
	private WebElement Enterotp1;

	@FindBy(xpath = "//input[@aria-label='Digit 2']")
	private WebElement Enterotp2;

	@FindBy(xpath = "//input[@aria-label='Digit 3']")
	private WebElement Enterotp3;

	@FindBy(xpath = "//input[@aria-label='Digit 4']")
	private WebElement Enterotp4;

	@FindBy(xpath = "//input[@aria-label='Digit 5']")
	private WebElement Enterotp5;

	@FindBy(xpath = "//input[@aria-label='Digit 6']")
	private WebElement Enterotp6;

	public void EnterOTP() throws InterruptedException {
		action.sendKeysElement(Enterotp1, "1");
		Thread.sleep(500);
		action.sendKeysElement(Enterotp2, "9");
		Thread.sleep(500);
		action.sendKeysElement(Enterotp3, "8");
		Thread.sleep(500);
		action.sendKeysElement(Enterotp4, "9");
		Thread.sleep(500);
		action.sendKeysElement(Enterotp5, "8");
		Thread.sleep(500);
		action.sendKeysElement(Enterotp6, "9");
		Thread.sleep(500);
	}

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement Verifybtn;

	public void ClickonVerifyButton() {
		action.clickElement(Verifybtn);
	}

	@FindBy(xpath = "(//h5s[.='Prabhat Kumar'])[2]")
	private WebElement verifylogin;

	public boolean verifyUserIsAbletoLogin() {
		return action.isDisplay(verifylogin);
	}
	@FindBy(xpath = "/html/body/div[1]/div[2]/div/main/div/div[1]/div/div/div/div[3]/button[1]")
	//h2[normalize-space()='Jobs']
//	@FindBy(xpath = "//h2[normalize-space()='Jobs']")
	private WebElement ClickonPostBtn1;

	public void ClickOnPostoption() throws InterruptedException {
		Thread.sleep(2000);
		action.isClickable(ClickonPostBtn1);
	}
	
}
