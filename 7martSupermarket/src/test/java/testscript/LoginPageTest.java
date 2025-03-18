package testscript;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class LoginPageTest extends Base {
	HomePage home;
	@Test
	public void verifyUsercanLoginwithValidCredentials() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameAndPassword("admin", "admin");
		
		home=loginPage.clickOnSigninButton();
		String expected = driver.getTitle();
		String actual = "Dashboard | 7rmart supermarket";
		System.out.println("Title:" + driver.getTitle());
		Assert.assertEquals(expected, actual, "DashBoard is not Loaded");
	}

	@Test
	public void verifyUsercanLoginwithInvalidUsernameAndValidPwd() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameAndPassword("invaliduname", "admin");
		loginpage.clickOnSigninButton();
		boolean isDashBoardDisplayed = loginpage.isDashBoardDisplayed();
		Assert.assertTrue(isDashBoardDisplayed, "DashBoard is not loaded");
	}

	@Test
	@Parameters({ "username", "password" })
	public void verifyUserCanLoginwithValidUsernameAndInvalidPwd(String uname, String pwd) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameAndPassword(uname, pwd);
		loginPage.clickOnSigninButton();
		String expected = driver.getTitle();
		String actual = "Dashboard | 7rmart supermarket";

		System.out.println("Title:" + driver.getTitle());
		System.out.println("Actual Title:" + actual);
		Assert.assertEquals(expected, actual, "Dashboard is not loaded");

	}

	@Test(dataProvider = "credentials")
	public void verifyUsercanLoginwithInvalidUsernameAndPassword(String uname, String pwd) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameAndPassword(uname, pwd);
		loginPage.clickOnSigninButton();
		boolean isAlertDisplayed = loginPage.isAlertDisplayed();
		System.out.println("Alert Displayed:" + isAlertDisplayed);
		Assert.assertTrue(isAlertDisplayed, "Alert Message is not Displayed");
	}

	@DataProvider(name = "credentials")
	public Object dataCredentials() {
		Object data[][] = { { "admin", "admin" }, { "123", "admin" }, { "admin", "123" }, { "123", "123" } };
		return data;
	}

}
