package LinkCxOWeb.TestCase;

import java.awt.Robot;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ContinentalFsCloudWeb.Utils.ActionKeywords;
import ContinentalFsCloudWeb.Utils.TestUtilsWeb;

import ContinentalFsCloudWeb.BaseClass.TestBaseClassWeb;
import ContinentalFsCloudWeb.Pages.WebLoginWithMobileNumber;

public class WebTestCases extends TestBaseClassWeb {
	public static WebDriver driver;

	@Override
	public void TestBaseClassWeb() throws IOException {
//		 super();
//		 this.driver = driver;
		driver = TestBaseClassWeb.driver;
	}

	TestUtilsWeb testutilsWeb;
	ActionKeywords action1;
	WebLoginWithMobileNumber loginmethodweb;


	@BeforeTest
	public void setUp() throws IOException {
		System.out.println("Inside before");
		InitializeBrowser();
//		initializeBrowserEdge();
		testutilsWeb = new TestUtilsWeb(driver);
		action1 = new ActionKeywords();
		loginmethodweb = new WebLoginWithMobileNumber();

	}

	@Test(priority = 1)
	public void loginviaMobileNumber() throws IOException {

		testutilsWeb.extentReport();
		testutilsWeb.CreateHtmlTable(0, 0, 0);
		testutilsWeb.testCaseCreate("Tc 01 : Login With Mobile Number");
		try {
			loginmethodweb.enterMobileNumbmer();
			testutilsWeb.test.log(Status.INFO, "Enter Mobile Number");
			loginmethodweb.ClickOnArrowButton();
			testutilsWeb.test.log(Status.INFO, "Click on arrow");
			loginmethodweb.EnterOTP();
			testutilsWeb.test.log(Status.INFO, "Enter enter otp");
			loginmethodweb.ClickonVerifyButton();
			testutilsWeb.test.log(Status.INFO, "Click on verify ");
			Thread.sleep(3000);
			try {
				if (loginmethodweb.verifyUserIsAbletoLogin()) {
					testutilsWeb.passTestCase("User is able to login succesfully");
				}
			} catch (Exception e) {
				testutilsWeb.failTestCase("User is not able to login");
			}
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
			testutilsWeb.failTestCase("User is not able to login");
		}
	}

	
	

	@AfterTest
	public void teardown() {
		testutilsWeb.ExtentFlush();
//			driver.quit();
		TestBaseClassWeb.driver.quit();
	}
}
