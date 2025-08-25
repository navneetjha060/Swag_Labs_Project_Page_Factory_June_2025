package Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import BaseClass.BaseClass;

public class captureScreenShot extends BaseClass {
	
	//Constructor so as to avoid null exception
	public captureScreenShot() {
		super();
	}

	public void captureSS(String testName) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());

		TakesScreenshot SS = (TakesScreenshot) driver;

		File source = SS.getScreenshotAs(OutputType.FILE);

		File destination = new File("./Screenshots/Test_" +testName+ " "+timeStamp + ".png");

		FileUtils.copyFile(source, destination);
	}

}
