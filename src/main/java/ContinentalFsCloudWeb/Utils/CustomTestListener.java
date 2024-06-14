package ContinentalFsCloudWeb.Utils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;

public class CustomTestListener implements ITestListener {

	@Override
	public void onFinish(ITestContext context) {
	    int totalTests = context.getAllTestMethods().length;
	    System.out.println(totalTests);
	    int passedTests = context.getPassedTests().size();
	    int failedTests = context.getFailedTests().size();
	    try {
			TestUtilsWeb.CreateHtmlTable(totalTests, passedTests, failedTests);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    // Implement other methods of the ITestListener interface as needed
}