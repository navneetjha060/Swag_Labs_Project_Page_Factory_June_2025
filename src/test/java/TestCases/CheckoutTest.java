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
		Thread.sleep(2000);
		homePage.clickAddToCart();
		Thread.sleep(2000);

		String ExpectedBackPackPrice = homePage.backPackPrice();

		cartPage = homePage.clickOnCartIcon();
		Thread.sleep(2000);

		String ExpectedInventoryName = cartPage.getInventoryName();

		checkOut = cartPage.clickCheckoutBtn();
		Assert.assertTrue(checkOut.validateCheckoutPage());

		checkOut.enterDetails("Navneet", "Jha", "411057");
		Thread.sleep(2000);
		checkOut.clickContinue();
		Thread.sleep(2000);
		Assert.assertTrue(checkOut.validateCheckoutOverviewLabel());
		Thread.sleep(2000);

		String ExpectedTax = "Tax: $2.40";

		System.out.println(checkOut.returnInventoryName());
		System.out.println(checkOut.returnInventoryPrice());
		System.out.println(checkOut.returnTax());
		System.out.println(checkOut.returnTotalPrice());

		Assert.assertEquals(ExpectedInventoryName, checkOut.returnInventoryName());
		Assert.assertEquals(ExpectedBackPackPrice, checkOut.returnInventoryPrice());
		Assert.assertEquals(ExpectedTax, checkOut.returnTax());

		// Need to incorporate price calculation logic
		String taxValueStr = ExpectedTax.replaceAll("[^\\d.]", ""); // removes all except digits and dot
		double expectedTaxValue = Double.parseDouble(taxValueStr);
		

		Thread.sleep(2000);
		checkOut.clickFinish();

	}

}
