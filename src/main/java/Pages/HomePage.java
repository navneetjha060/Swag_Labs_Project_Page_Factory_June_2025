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

	@FindBy(xpath = "//button[text()=\"Open Menu\"]")
	WebElement hamburgerMenu;

	@FindBy(id = "logout_sidebar_link")
	WebElement logoutLink;

	@FindBy(xpath = "//div[text()='Sauce Labs Backpack']")
	WebElement backPack;

	@FindBy(xpath = "//button[text()=\"Add to cart\"]")
	WebElement addToCartBtn;

	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	WebElement cartIcon;

	@FindBy(xpath = "//div[@class='inventory_details_price']")
	WebElement inventoryPrice;

	// Actions

	public String getLogoText() {
		return homePageLogo.getText();
	}

	public boolean productsTextPresence() {
		return productsHeader.isDisplayed();
		// Login Success check
	}


	public void clickHamburgerMenu() {
		hamburgerMenu.click();
	}

	public LoginPage clickLogout() {
		logoutLink.click();
		return new LoginPage(driver);
	}

	public void chooseBackPack() {
		backPack.click();
	}

	public String backPackPrice() {
		return inventoryPrice.getText();
	}

	public void clickAddToCart() {
		addToCartBtn.click();
	}

	public CartPage clickOnCartIcon() {
		cartIcon.click();
		return new CartPage(driver);
	}

}
