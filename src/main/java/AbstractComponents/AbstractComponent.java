package AbstractComponents;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class AbstractComponent{
	
	WebDriver driver;
	//public static final EXPLICIT_WAIT = 10;
	
	public AbstractComponent(AndroidDriver driver) 
	{
		this.driver=driver;
	}

	public void click(MobileElement mobileElement) 
	{
		mobileElement.click();
	}
	
//	public void Keys(MobileElement StartEndDate)
//	{
//		AndroidElement startdate= (AndroidElement) driver.findElementById("android:id/pickers");
//		startdate.sendKeys(Keys.TAB);
//		startdate.sendKeys(Keys.ARROW_DOWN);
//	}
//	public void WaitForElementVisible(MobileElement element)
//	{
//		WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT);
//		wait.until(ExpectedConditions.visibilityOf(element));
//	}
	
//	public Select DropDownSelection(String element, WebElement designation)
//	{
//		
//		//AndroidElement selectElement = (AndroidElement) driver.findElement(By.id("com.linkcxo:id/designation"));
//        Select select = new Select(designation);
//        // select an option by its visible text
//        select.selectByVisibleText(element);
//        return select;
//        
//        Select objSelect =new Select(driver.findElement(By.id("search-box")));
//        objSelect.selectByVisibleText("Automation");
//	
//	}
}

