package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

	WebDriver driver;

	// Constructor
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElements
	@FindBy(xpath = "//span[text()='Checkout: Your Information']")
	WebElement checkoutBaner;
	
	@FindBy(id="first-name")
	WebElement fName;
	
	@FindBy(id="last-name")
	WebElement lName;
	
	@FindBy(id="postal-code")
	WebElement zip;
	
	@FindBy(id="continue")
	WebElement continueBtn;

	// Actions

	public boolean validateCheckoutPage() {
		return checkoutBaner.isDisplayed();
	}
	
	public void enterDetails(String Fname , String Lname , String Zip) {
		fName.sendKeys(Fname);
		lName.sendKeys(Lname);
		zip.sendKeys(Zip);
	}
	
	public void clickContinue() {
		continueBtn.click();
	}

}
