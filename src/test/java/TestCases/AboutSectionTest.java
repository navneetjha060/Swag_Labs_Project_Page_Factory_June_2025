package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import Pages.AboutPage;
import Pages.HomePage;
import Pages.LoginPage;

public class AboutSectionTest extends BaseClass {

	// Create Page References
	LoginPage loginPage;
	HomePage homePage;
	AboutPage aboutPage;

	@BeforeMethod
	public void initialization() throws IOException {
		loginPage = new LoginPage(driver);

	}

	@Test
	public void aboutSectionTest() throws InterruptedException {
		homePage = loginPage.login("standard_user", "secret_sauce");
		Thread.sleep(2000);
		homePage.clickHamburgerMenu();
		aboutPage = homePage.clickAbout();
		Thread.sleep(2000);
		Assert.assertTrue(aboutPage.validateTitle());
	}

}
