package ContinentalFsCloudWeb.BaseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ContinentalFsCloudWeb.Utils.TestUtilsWeb;
//import LinkCxOWeb.utils.TestUtilsWeb;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBaseClassWeb {

	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;

	public void TestBaseClassWeb() throws IOException {
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/ContinentalFsCloudWeb/config/configure.propertief");
		prop = new Properties();
		prop.load(fs);
	}

	public static void InitializeBrowser() throws IOException {
		System.out.println("before cons");
		TestBaseClassWeb web = new TestBaseClassWeb();
		web.TestBaseClassWeb();
		System.out.println("after cons");
		TestUtilsWeb testutilsweb = new TestUtilsWeb(driver);
//		String browserName=prop.getProperty("BROWSER");
//		String browserName1=prop.getProperty("BROWSER1");
		String browserName = prop.getProperty("BROWSER");
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
//			option.setExperimentalOption("excludeSwithces", new String[] {"enable-automation"});
			driver = new ChromeDriver(option);
			System.out.println("Chrome browser initialized successfully");
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions option = new FirefoxOptions();
//			option.addArguments("--remote-allow-origins=*");
			driver = new FirefoxDriver(option);
			System.out.println("Firefox browser initialized successfully");
		} else if (browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			EdgeOptions option = new EdgeOptions();
//			option.addArguments("--remote-allow-origins=*");
			driver = new EdgeDriver(option);
			System.out.println("Edge browser initialized successfully");
		}
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(testutilsweb.pageloadtime, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(testutilsweb.implicitywait, TimeUnit.SECONDS);
	}
}
//	public static void initializeBrowserEdge() throws IOException {
//	    System.out.println("Before constructing web");
//	    TestBaseClassWeb web = new TestBaseClassWeb();
//	    web = new TestBaseClassWeb(); // Assuming this is necessary
//	    System.out.println("After constructing web");
//	    TestUtilsWeb testutilsweb=new TestUtilsWeb(driver);
//	    String browserName1 = prop.getProperty("BROWSER1");
//
//	    if (browserName1.equalsIgnoreCase("Edge")) {
//	        WebDriverManager.edgedriver().setup();
//	        EdgeOptions options = new EdgeOptions();
//	        // Set any options if needed
//	        // options.setCapability("key", "value");
//
//	        try {
//	            driver = new EdgeDriver(options);
//	            System.out.println("Edge browser initialized successfully");
//	        } catch (Exception e) {
//	            System.err.println("Error initializing Edge browser: " + e.getMessage());
//	        }
//	    }
//		driver.get(prop.getProperty("URL"));
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().pageLoadTimeout(testutilsweb.pageloadtime,TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(testutilsweb.implicitywait,TimeUnit.SECONDS);	
//	}

//WebDriverWait wait=new WebDriverWait(driver, 10);
//String windowSize = prop.getProperty("WindowSize");
//String[] dimensions = windowSize.split("x");
//int width = Integer.parseInt(dimensions[0]);
//int height = Integer.parseInt(dimensions[1]);
//Dimension dimension = new Dimension(width,height);
//driver.manage().window().setSize(dimension);
