package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends Base {
	@Test
	public void verifyUsercanLogout() {
		LoginPage login = new LoginPage(driver);
		login.enterUsernameAndPassword("admin", "admin");
		login.clickOnSigninButton();
		HomePage home = new HomePage(driver);
		home.clickOnAdmin();
		home.clickOnLogout();

		String expected = driver.getTitle();
		String actual = "Login | 7rmart supermarket";
		System.out.println("Title:" + driver.getTitle());
		Assert.assertEquals(expected, actual, "Login Page is not Loaded");

	}
}
