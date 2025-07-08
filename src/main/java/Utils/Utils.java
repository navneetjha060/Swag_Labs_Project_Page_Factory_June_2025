package Utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import BaseClass.BaseClass;

public class Utils extends BaseClass {

	WebDriver driver;
	public Utils() throws IOException {
		super();

	}

	public void handleAlerts(WebDriver driver) {

		driver.switchTo().alert().dismiss();

	}

}
