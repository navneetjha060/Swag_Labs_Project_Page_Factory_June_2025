package TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import Pages.HomePage;
import Pages.LoginPage;

public class LoginTest extends BaseClass {

	// Create Page References
	LoginPage loginPage;
	HomePage homePage;

	@BeforeMethod
	public void initialization() {
		loginPage = new LoginPage(driver);

	}

	@Test
	public void validateLogo() {

		String logoText = loginPage.logoCheck();
		String expectedLogoText = "Swag Labs";
		Assert.assertEquals(logoText, expectedLogoText);
	}

	@Test
	public void loginTest() {
		homePage = loginPage.login("standard_user", "secret_sauce");
		String homeLogoTest = homePage.getLogoText();
		String expectedHomeLogoText = "Swag Labs";
		Assert.assertEquals(homeLogoTest, expectedHomeLogoText);
		boolean res = homePage.productsTextPresence();
		Assert.assertTrue(res);

	}

	@Test(dependsOnMethods = "loginTest")
	public void logoutTest() {
		homePage = loginPage.login("standard_user", "secret_sauce");
		homePage.clickHamburgerMenu();
		loginPage = homePage.clickLogout();
		String logoText = loginPage.logoCheck();
		String expectedLogoText = "Swag Labs";
		Assert.assertEquals(logoText, expectedLogoText);
	}

	@Test(dataProviderClass = Utils.ReadExcelData.class, dataProvider = "loginUserNames")
	public void multipleLoginTest(String Uname, String Pwd) {

		if (Uname == "locked_out_user") {
			boolean res = loginPage.lockedUserLogin(Uname, Pwd);
			Assert.assertTrue(res);
		}

		else {
			homePage = loginPage.login(Uname, Pwd);
			boolean res = homePage.productsTextPresence();
			Assert.assertTrue(res);
		}
	}

}
