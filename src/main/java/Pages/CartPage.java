package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;

public class CartPage extends BaseClass {

	WebDriver driver;

	// Constructor
	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElements
	@FindBy(xpath = "//div[@class='inventory_item_name']")
	WebElement inventoryName;

	@FindBy(xpath = "//div[@class='inventory_item_price']")
	WebElement inventoryPrice;

	@FindBy(id = "checkout")
	WebElement checkoutBtn;

	// Actions

	public String getInventoryName() {
		return inventoryName.getText();
	}

	public String getInventoryPrice() {
		return inventoryPrice.getText();
	}
	
	public void clickCheckoutBtn() {
		checkoutBtn.click();
	}

}
