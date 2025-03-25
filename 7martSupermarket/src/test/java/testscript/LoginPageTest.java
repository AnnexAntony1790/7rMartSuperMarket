package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginPageTest extends Base {
	HomePage home;

	@Test
	public void verifyUsercanLoginwithValidCredentials() throws IOException {
		String userName = ExcelUtility.getStringData(3, 0, "LoginPage");
		String password = ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameAndPassword(userName, password);
		home = loginPage.clickOnSigninButton();
		String expected = driver.getTitle();
		String actual = "Dashboard | 7rmart supermarket";
		System.out.println("Title:" + driver.getTitle());
		Assert.assertEquals(expected, actual, Constant.ERRORMESSAGEFORLOGIN);
	}

	@Test
	public void verifyUsercanLoginwithInvalidUsernameAndValidPwd() throws IOException {
		// Excel Read Program
		String userName = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameAndPassword(userName, password);
		loginpage.clickOnSigninButton();
		String expected = driver.getTitle();
		String actual = "Dashboard | 7rmart supermarket";
		System.out.println("Title:" + driver.getTitle());
		Assert.assertEquals(expected, actual, Constant.ERRORMESSAGEFORLOGIN);
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
		Assert.assertEquals(expected, actual, Constant.ERRORMESSAGEFORLOGIN);

	}

	@Test(dataProvider = "credentials")
	public void verifyUsercanLoginwithDataProviders(String uname, String pwd) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameAndPassword(uname, pwd);
		loginPage.clickOnSigninButton();
		String expected = driver.getTitle();
		String actual = "Dashboard | 7rmart supermarket";
		System.out.println("Title:" + driver.getTitle());
		Assert.assertEquals(expected, actual, Constant.ERRORMESSAGEFORLOGIN);
	}

	@DataProvider(name = "credentials")
	public Object dataCredentials() {
		Object data[][] = { { "admin", "admin" }, { "123", "admin" }, { "admin", "123" }, { "123", "123" } };
		return data;
	}

}
