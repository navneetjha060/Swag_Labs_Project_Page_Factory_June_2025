package BaseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;

	@BeforeMethod
	public void setup() throws IOException {

		// Properties Setup

		prop = new Properties();
		String path = System.getProperty("user.dir") + "\\src\\main\\java\\Properties\\config.propperties";
		FileInputStream input = new FileInputStream(path);
		prop.load(input);

		// Get URL Details
		String testURL = prop.getProperty("url");

		// Get Browser Details
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}

		else if (browserName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get(testURL);
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
