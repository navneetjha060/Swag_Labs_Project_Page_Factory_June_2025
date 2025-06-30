package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;

public class HomePage extends BaseClass {

	WebDriver driver;

	// Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElements
	@FindBy(xpath = "//div[text()=\"Swag Labs\"]")
	WebElement homePageLogo;
	
	@FindBy(xpath = "//span[text()=\"Products\"]")
	WebElement productsHeader;

	// Actions

	public String getLogoText() {
		return homePageLogo.getText();
	}
	
	public boolean productsTextPresence() {
		return productsHeader.isDisplayed();
	}

}
