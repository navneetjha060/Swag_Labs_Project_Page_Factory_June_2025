package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;

public class LoginPage extends BaseClass {
	WebDriver driver;
	HomePage homePage;

	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElements
	@FindBy(id = "user-name")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "login-button")
	WebElement loginBtn;

	@FindBy(xpath = "//div[@class='login_logo']")
	WebElement logo;
	
	@FindBy(xpath = "//h3[@data-test=\"error\"]")
	WebElement loginError;

	// Actions

	public String logoCheck() {
		return logo.getText();
	}

	public HomePage login(String user, String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		loginBtn.click();
		return new HomePage(driver);

		// Page Chaining

	}
	
	public boolean invalidLogin(String user, String pass) throws InterruptedException {
		username.sendKeys(user);
		password.sendKeys(pass);
		loginBtn.click();
		Thread.sleep(2000);
		System.out.println(loginError.getText());
		return loginError.isDisplayed();
	}

}
