package Listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class Listeners implements ITestListener {

	
	WebDriver driver;

	public void onTestStart(ITestResult result) {
		System.out.println("------------Test Started------------" + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("--------Test Passed Successfully---------" + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("--------!!!!! Test Failed !!!!!!--------" + result.getName());
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("------Test Skipped-------" + result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("------Test Failed due to timeout issue-------" + result.getName());
	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

	}

}
