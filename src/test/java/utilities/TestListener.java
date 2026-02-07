package utilities;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
	public class TestListener extends BaseTest implements ITestListener {
		ExtentReports extent = ExtentManager.getInstance();
	    ExtentTest test;
	    @Override
	    public void onTestStart(ITestResult result) {
	        System.out.println("\n===== TEST STARTED : " + result.getName() + " =====");
	        test = extent.createTest(result.getName());
	    }
	    @Override
	    public void onTestSuccess(ITestResult result) {
	        System.out.println("===== PASSED : " + result.getName() + " =====");
	 
	        test.log(Status.PASS, "Test Passed: " + result.getName());
	        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
	        String path = Screenshots.takeScreenshot(driver, result.getName());
	        test.addScreenCaptureFromPath(path);
	    }
	    @Override
	    public void onTestFailure(ITestResult result) {
	        System.out.println("===== FAILED : " + result.getName() + " =====");
	 
	        test.log(Status.FAIL, "Test FAILED: " + result.getName());
	        test.log(Status.FAIL, result.getThrowable());
	 
	        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
	        String path = Screenshots.takeScreenshot(driver, result.getName());
	        test.addScreenCaptureFromPath(path);
	    }
	    @Override
	    public void onTestSkipped(ITestResult result) {
	        System.out.println("===== SKIPPED : " + result.getName() + " =====");
	 
	        test.log(Status.SKIP, "Test Skipped: " + result.getName());
	    }
	    @Override
	    public void onFinish(ITestContext context) {
	        System.out.println("\n===== FINISHED TEST SUITE =====\n");
	 
	        extent.flush();
	    }
	}