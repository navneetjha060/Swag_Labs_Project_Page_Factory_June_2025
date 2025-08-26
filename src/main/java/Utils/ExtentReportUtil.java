package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtil {

	public static ExtentReports extentReportUtil() {

		String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";

		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
		sparkReporter.config().setReportName("SwagLabs Test Report");
		sparkReporter.config().setDocumentTitle("SwagLabs Test Results");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

		return extent;

	}

}
