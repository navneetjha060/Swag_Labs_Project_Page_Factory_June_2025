package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.HomePage;
import Pages.LoginPage;

public class CheckoutTest extends BaseClass {

	// Create Page References
	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	CheckoutPage checkOut;

	@BeforeMethod
	public void initialization() throws IOException {
		loginPage = new LoginPage(driver);

	}

	@Test
	public void cartTest() throws InterruptedException {
		homePage = loginPage.login("standard_user", "secret_sauce");
		Thread.sleep(2000);
		homePage.chooseBackPack();
		homePage.clickAddToCart();
		Thread.sleep(2000);
		cartPage = homePage.clickOnCartIcon();
		checkOut = cartPage.clickCheckoutBtn();
		Assert.assertTrue(checkOut.validateCheckoutPage());

		checkOut.enterDetails("Navneet", "Jha", "411057");
		Thread.sleep(2000);
		checkOut.clickContinue();
		Thread.sleep(2000);
	}

}
