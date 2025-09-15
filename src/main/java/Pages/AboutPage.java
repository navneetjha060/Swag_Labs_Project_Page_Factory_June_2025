package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;

public class AboutPage extends BaseClass {

	WebDriver driver;

	// Constructor
	public AboutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElements
	@FindBy(xpath = "//h1[text()=\"Build apps users love with AI-driven quality\"]")
	WebElement aboutPageText;

	// Actions

	public boolean validateTitle() {

		System.out.println(aboutPageText.getText());
		return aboutPageText.isDisplayed();
	}

}
