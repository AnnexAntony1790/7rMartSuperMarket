package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchUserPage;

public class AdminUserPageTest extends Base {
	HomePage home;
	AdminUserPage adminUserPage;

	@Test
	public void verifyClickOnMoreInfoLinkRedirectstoAdminUserPage() {
		LoginPage login = new LoginPage(driver);
		login.enterUsernameAndPassword("admin", "admin");
		home = login.clickOnSigninButton();
		adminUserPage = home.clickOnMoreInfo();
		String expected = driver.getTitle();
		String actual = "Admin Users | 7rmart supermarket";
		System.out.println("Title:" + driver.getTitle());
		Assert.assertEquals(expected, actual, "Admin User Page is not Loaded");

	}

	

}
