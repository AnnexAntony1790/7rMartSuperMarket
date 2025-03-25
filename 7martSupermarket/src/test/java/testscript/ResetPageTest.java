package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchUserPage;
import utilities.ExcelUtility;

public class ResetPageTest extends Base{
	HomePage home;
	AdminUserPage adminUserPage;
	SearchUserPage searchUserPage;
	@Test
	public void verifyWhetherClickOnResetButtonisResettingfields() throws IOException {
		String userName = ExcelUtility.getStringData(3, 0, "LoginPage");
		String password = ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameAndPassword(userName, password);
		home = login.clickOnSigninButton();
		adminUserPage = home.clickOnAdminUserMoreInfo();
		searchUserPage = adminUserPage.clickOnSearch().enterUsername("Anu");
		adminUserPage.clickOnReset();
		String expected = driver.getTitle();
		String actual = "Admin Users | 7rmart supermarket";
		System.out.println("Title:" + driver.getTitle());
		Assert.assertEquals(expected, actual, Constant.ERRORMESSAGEFORADMINUSERPAGE);
	}
}
