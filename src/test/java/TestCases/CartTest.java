package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;


public class CartTest extends BaseClass {

	// Create Page References
	LoginPage loginPage;
	HomePage homePage;
	
	CartPage cartPage;

	@BeforeMethod
	public void initialization() throws IOException {
		loginPage = new LoginPage(driver);
		
	}

	@Test
	public void addProductToCart() throws InterruptedException {
		homePage = loginPage.login("standard_user", "secret_sauce");
		// utils.acceptAlert();
		Thread.sleep(2000);
		homePage.chooseBackPack();
		homePage.clickAddToCart();
		Thread.sleep(2000);
		String ExpectedPrice = "$29.99";
		String ActualPrice = homePage.backPackPrice();
		Assert.assertEquals(ActualPrice, ExpectedPrice);
		// homePage.clickAddToCart();
		Thread.sleep(2000);
		homePage.clickOnCartIcon();
		Thread.sleep(2000);
	}

	@Test
	public void cartProductVerification() throws InterruptedException {

		String expectedInventoryName = "Sauce Labs Backpack";
		String expectedInventoryPrice = "$29.99";

		homePage = loginPage.login("standard_user", "secret_sauce");
		// utils.acceptAlert();
		Thread.sleep(2000);
		homePage.chooseBackPack();
		homePage.clickAddToCart();
		Thread.sleep(2000);
		// homePage.clickAddToCart();
		Thread.sleep(2000);
		cartPage = homePage.clickOnCartIcon();

		String actualInventoryName = cartPage.getInventoryName();
		String actualInventoryPrice = cartPage.getInventoryPrice();
		
		Assert.assertEquals(expectedInventoryName, actualInventoryName);
		Assert.assertEquals(actualInventoryPrice, expectedInventoryPrice);
		
		cartPage.clickCheckoutBtn();
		Thread.sleep(2000);

	}

}
