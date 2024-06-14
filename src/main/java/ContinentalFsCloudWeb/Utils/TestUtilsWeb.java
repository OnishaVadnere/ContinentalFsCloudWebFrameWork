package ContinentalFsCloudWeb.Utils;

import java.io.File;
import java.io.FileWriter;

import org.apache.log4j.Logger;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import ContinentalFsCloudWeb.BaseClass.TestBaseClassWeb;
import io.appium.java_client.android.AndroidDriver;

public class TestUtilsWeb extends TestBaseClassWeb {

	public ExtentHtmlReporter htmlReport;
	public static ExtentReports extent;
	public static ExtentTest test;
	static String year;
	static String time;
	protected String parentHandle;
	public static WebDriver driver;

	static Logger log = Logger.getLogger(TestUtilsWeb.class);

	public TestUtilsWeb(WebDriver driver) throws IOException {
		super();
		this.driver = TestBaseClassWeb.driver;
		System.out.println("AV");
	}

	public static long pageloadtime = 20;
	public static long implicitywait = 20;

	public String takeScreenShot() throws IOException {
		Date date = new Date();
		SimpleDateFormat tm = new SimpleDateFormat("yyyy-MM-dd");
		year = tm.format(date);
		SimpleDateFormat tm1 = new SimpleDateFormat("HH_mm_ss");
		time = tm1.format(date);

		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destFile = System.getProperty("user.dir") + File.separator + "Screenshot" + File.separator + year
				+ File.separator + time + ".jpeg";
		FileUtils.copyFile(srcFile, new File(destFile));
		System.out.println(destFile);

		return destFile;
	}

	public void ScreenshotPathFormat() {
		Date date = new Date();
		SimpleDateFormat tm = new SimpleDateFormat("yyyy-MM-dd");
		year = tm.format(date);
		SimpleDateFormat tm1 = new SimpleDateFormat("HH_mm_ss");
		time = tm1.format(date);
	}
	
	public static String Extent_ReportFinal = null;
	public void CreateExtentReportFile() {
		ScreenshotPathFormat();
		String path = System.getProperty("user.dir") + File.separator +"REPORT_WEB";
		String finalPath = path + File.separator + year + File.separator;
		new File(finalPath).mkdirs();
		Extent_ReportFinal = finalPath + time + ".html";
		System.out.println(Extent_ReportFinal);
	}

	public void extentReport() throws IOException {
//		ScreenshotPathFormat();
//		String path = System.getProperty("user.dir") + "/REPORT_WEB";
//		String finalPath = path + "/" + year + "/";
//		new File(finalPath).mkdirs();
		CreateExtentReportFile();
		htmlReport = new ExtentHtmlReporter(Extent_ReportFinal );
		htmlReport.config().setDocumentTitle("Automation Report");// Title of the report
		htmlReport.config().setReportName("Functional Report");// Name of the report
		htmlReport.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		htmlReport.config().setTheme(Theme.STANDARD);
		extent.setSystemInfo("Project Name", "Continental FS Cloud ");
		extent.setSystemInfo("Test Lead", "Gopika");
		extent.attachReporter(htmlReport);
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", "Onisha Vadnere");
		extent.setSystemInfo("Browser", "Chrome");

	}

	public void testCaseCreate(String tc) {
		test = extent.createTest("<font color=\"BlueViolet\"><b>" + tc + "</b></font> ").assignCategory("Onisha");
	}

	public void passTestCase(String passDesc) throws IOException {
		test.log(Status.INFO, MarkupHelper.createLabel(passDesc, ExtentColor.GREEN));
		test.log(Status.PASS, "", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
	}

	public void failTestCase(String failDesc) throws IOException {
		test.log(Status.INFO, MarkupHelper.createLabel(failDesc, ExtentColor.RED));
		test.log(Status.FAIL, "", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
	}

	public void ExtentFlush() {
		extent.flush();
	}

	public void switchToChildWindow() {
		Set<String> newWindowHandles = driver.getWindowHandles();
		for (String handle : newWindowHandles) {
			System.out.println("inside switch");
			log.info("Window " + handle);
			if (!handle.equals(parentHandle)) {
				log.info("Switching to Window: " + handle);
				driver.switchTo().window(handle);
				log.info("Switch Done");
				break;
			}
		}
	}

	public void setParentHandle() {
		parentHandle = driver.getWindowHandle();
	}

	public void closeChildWindow() {
		System.out.println("Closing child window...");
		driver.close();
		System.out.println("Child window closed.");
		System.out.println("Switching back to parent window...");
		driver.switchTo().window(parentHandle);
		System.out.println("Switched back to parent window.");
	}

	//////////
	public static void CreateHtmlTable(int totalTests, int passedTests, int failedTests) throws IOException {

		try {
			String path = System.getProperty("user.dir") + "/REPORT_WEB" + "/HtmlTableReport";
			String finalPath = path + "/" + year + "/";
			new File(finalPath).mkdirs();

			String filename = finalPath + "HtmlTable_Report_" + time + ".html";

			FileWriter writer = new FileWriter(filename);

			writer.write("<!DOCTYPE html>\n<html>\n<head>\n");

			writer.write("<style> table { border-collapse: collapse; width: 50%; margin: auto; margin-top: 20px; }");
			writer.write(
					" th, td { border: 1px solid black; padding: 8px; text-align: center; background-color: #E4E5E5; }");
			writer.write("th {  background-color: #E4E5E5; } </style>");
			writer.write("</head>\n<body>\n");

			writer.write("<table border=\"1\">\n");
			writer.write("<tr>"
					+ "<th style=\"text-align:center; border: 1px solid black; background-color:#4CAF50; color: white;\">Project</th>"
					+ "<th style=\"text-align:center; border: 1px solid black; background-color:#1E90FF; color: white;\">Total TCs</th>"
					+ "<th style=\"text-align:center; border: 1px solid black; background-color:#4CAF50; color: white;\">Passed TCs</th>"
					+ "<th style=\"text-align:center; border: 1px solid black; background-color:#FF6347; color: white;\">Failed TCs</th>"
//					+ "<th style=\"text-align:center; border: 1px solid black; background-color:#4682B4; color: white;\">Total Validations in all the TCs</th>"
//					+ "<th style=\"text-align:center; border: 1px solid black; background-color:#32CD32; color: white;\">Passed Validations</th>"
//					+ "<th style=\"text-align:center; border: 1px solid black; background-color:#FF6347; color: white;\">Failed Validations</th>"
					+ "<th>Report</th>"
//					+ "<th>CSV_File</th>"
//					+ "<th style=\"text-align:center; border: 1px solid black; background-color:#4CAF50; color: white;\">ExecutionTime</th>"
					+ "</tr>");

			writer.write("<tr>" + "<td style=\"text-align:center; border: 1px solid black;\">" + "Continental FS Cloud_Web" + "</td>"
					+ "<td style=\"text-align:center; border: 1px solid black;\">" + totalTests + "</td>"
					+ "<td style=\"text-align:center; border: 1px solid black;\">" + passedTests + "</td>"
					+ "<td style=\"text-align:center; border: 1px solid black;\">" + failedTests + "</td>"
//					+ "<td style=\"text-align:center; border: 1px solid black;\">"
//					+ ConnectDataSheet.totalValidations + "</td>"
//					+ "<td style=\"text-align:center; border: 1px solid black;\">" + ConnectDataSheet.passValidations
//					+ "</td>" 
//					+ "<td style=\"text-align:center; border: 1px solid black;\">"
//					+ ConnectDataSheet.failedValidations + "</td>" 
					+ "<td><a href=" + Extent_ReportFinal.replaceAll(" ","%20" )+ " target=_blank>View Report</a></td>"
//					+ "<td><a href=" + CSV_ReportFile
//					+ " target=_blank>CSV</a></td>" 
//					+ "<td style=\"text-align:center; border: 1px solid black;\">"
//					+ UtilScreenshotAndReport.TotalExecutionTime 
					+ "</td></tr>");

			writer.write("</table>\n");
			writer.write("</body>\n</html>");
			writer.close();

		System.out.println("HTML table has been generated in " + filename);

		} catch (Exception e) {
			e.printStackTrace();
//			logger.info("Info Message :  " + e);
		}

	}

}
