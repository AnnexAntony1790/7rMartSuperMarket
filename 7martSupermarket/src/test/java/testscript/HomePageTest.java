package testscript;

import java.io.IOException;
import java.lang.invoke.ConstantBootstraps;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomePageTest extends Base {
	@Test
	public void verifyWhetherUsercanLogout() throws IOException {
		
		String userName = ExcelUtility.getStringData(3, 0, "LoginPage");
		String password = ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameAndPassword(userName, password);
		login.clickOnSigninButton();
		HomePage home = new HomePage(driver);
		home.clickOnAdmin();
		home.clickOnLogout();
		String expected = driver.getTitle();
		String actual = "Login | 7rmart supermarket";
		System.out.println("Title:" + driver.getTitle());
		Assert.assertEquals(expected, actual, Constant.ERRORMESSAGEFORLOGOUT);

	}
}
