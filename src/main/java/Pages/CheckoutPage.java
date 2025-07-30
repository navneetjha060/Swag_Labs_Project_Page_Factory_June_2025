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

	@FindBy(id = "first-name")
	WebElement fName;

	@FindBy(id = "last-name")
	WebElement lName;

	@FindBy(id = "postal-code")
	WebElement zip;

	@FindBy(id = "continue")
	WebElement continueBtn;

	@FindBy(xpath = "//span[text()='Checkout: Overview']")
	WebElement checkoutOverviewLabel;

	@FindBy(xpath = "//div[@class=\"inventory_item_name\"]")
	WebElement inventoryName;

	@FindBy(xpath = "//div[@class=\"inventory_item_price\"]")
	WebElement inventoryPrice;

	@FindBy(xpath = "//div[@class=\"summary_tax_label\"]")
	WebElement tax;

	@FindBy(xpath = "//div[@class=\"summary_total_label\"]")
	WebElement totalPrice;

	@FindBy(id = "finish")
	WebElement finishBtn;
	
	@FindBy(xpath = "//span[text()='Checkout: Complete!']")
	WebElement checkoutCompleteLabel;
	
	@FindBy(xpath = "//h2")
	WebElement thanksForOrder;
	
	@FindBy(id="back-to-products")
	WebElement backHomeBtn;

	// Actions

	public boolean validateCheckoutPage() {
		return checkoutBaner.isDisplayed();
	}

	public void enterDetails(String Fname, String Lname, String Zip) {
		fName.sendKeys(Fname);
		lName.sendKeys(Lname);
		zip.sendKeys(Zip);
	}

	public void clickContinue() {
		continueBtn.click();
	}

	public boolean validateCheckoutOverviewLabel() {
		return checkoutOverviewLabel.isDisplayed();
	}

	public String returnInventoryName() {
		return inventoryName.getText();
	}

	public String returnInventoryPrice() {
		return inventoryPrice.getText();
	}

	public String returnTax() {
		return tax.getText();
	}

	public String returnTotalPrice() {
		return totalPrice.getText();
	}

	public void clickFinish() {
		finishBtn.click();
	}
	
	public boolean validateCheckoutComplete() {
		return checkoutCompleteLabel.isDisplayed();
	}
	
	public String validateThanksMessage() {
		return thanksForOrder.getText();
	}
	
	public HomePage clickBackHomeBtn() {
		backHomeBtn.click();
		return new HomePage(driver);
	}

}
