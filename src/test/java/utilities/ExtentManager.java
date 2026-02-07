package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	private static ExtentReports extent;
	 
    public static ExtentReports getInstance() {
 
        if (extent == null) {
 
            String reportPath = System.getProperty("user.dir") + "/ExtentReports/TestReport.html";
 
            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            spark.config().setReportName("Automation Test Report");
            spark.config().setDocumentTitle("Extent Report");
 
            extent = new ExtentReports();
            extent.attachReporter(spark);
 
            extent.setSystemInfo("Tester", "Ravindra Kumar");
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Browser", "Chrome");
        }
        return extent;
    }
}

