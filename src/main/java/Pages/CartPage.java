package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;

public class CartPage extends BaseClass{
	
	WebDriver driver;

	// Constructor
	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
