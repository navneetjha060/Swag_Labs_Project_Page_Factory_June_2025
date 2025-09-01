package Listeners;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Utils.captureScreenShot;
import Utils.ExtentReportUtil;

public class Listeners implements ITestListener {

	WebDriver driver;
	
	//Extent Reports
	ExtentReports extent=ExtentReportUtil.extentReportUtil();
	ExtentTest test;
	
	//Log instance
	static Logger Log = LogManager.getLogger(Listeners.class);
	

	public void onTestStart(ITestResult result) {
		System.out.println("------------Test Started------------" + result.getName());
		
		//Extent Reports
		test=extent.createTest(result.getName());
		
		//Logging
		Log.info("Logs-----Test Started------------" + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("--------Test Passed Successfully---------" + result.getName());
		
		test.pass(result.getName()+"=======Passed Successfully=======");
		
		Log.info("Logs-----Test Passed Successfully------------" + result.getName());
	}

	public void onTestFailure(ITestResult result) {

		System.out.println("--------!!!!! Test Failed !!!!!!--------" + result.getName());
		
		captureScreenShot ss = new captureScreenShot();
		try {
			ss.captureSS(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.fail(result.getName()+"=======!!! Test Failed !!!=======");
		
		Log.error("Log-------Test failed!"+ result.getName());

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("------Test Skipped-------" + result.getName());
		
		test.skip(result.getName()+"=======!!! Test Skipped !!!=======");
		
		Log.info("Logs-----Test Skipped ------------" + result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
		System.out.println("------Test Failed due to timeout issue-------" + result.getName());
		
		test.fail(result.getName()+"=======!!! Test Failed due to Timeout Issues !!!=======");
		
		Log.error("Log-------Test failed!"+ result.getName());
	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

		extent.flush();
	}

}
