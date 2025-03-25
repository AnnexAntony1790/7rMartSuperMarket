package testscript;

import java.io.IOException;
import java.lang.invoke.ConstantBootstraps;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class DeleteUserPageTest extends Base {
	HomePage homePage;
	AdminUserPage adminUserPage;

	@Test
	public void verifyIfUserCanBeDeleted() throws IOException {
		String userName = ExcelUtility.getStringData(3, 0, "LoginPage");
		String password = ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameAndPassword(userName, password);
		homePage = loginPage.clickOnSigninButton();
		adminUserPage = homePage.clickOnAdminUserMoreInfo().clickOnDelete();
		String expected = driver.getTitle();
		String actual = "Admin Users | 7rmart supermarket";
		System.out.println("Title:" + driver.getTitle());
		Assert.assertEquals(expected, actual, Constant.ERRORMESSAGEFORADMINUSERPAGE);

	}
}
