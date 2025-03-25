package testscript;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.AddNewUserPage;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchUserPage;
import utilities.ExcelUtility;

public class SearchUserPageTest extends Base {
	HomePage homePage;
	AdminUserPage adminUserPage;
	AddNewUserPage newUserPage;
	SearchUserPage searchUserPage;

	@Test
	public void verifyWhetherSearchResultsAreDisplayed() throws IOException {
		String userName = ExcelUtility.getStringData(3, 0, "LoginPage");
		String password = ExcelUtility.getStringData(3, 1, "LoginPage");
		String searchName = ExcelUtility.getStringData(1, 0, "AdminUserPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameAndPassword(userName, password);
		homePage = loginPage.clickOnSigninButton();
		adminUserPage = homePage.clickOnAdminUserMoreInfo();
		searchUserPage = adminUserPage.clickOnSearch().enterUsername(searchName).clickOnSearchUser();
		boolean tableDisplayed = searchUserPage.isTableDisplayed();
		Assert.assertTrue(tableDisplayed, Constant.ERRORMESSAGEFORSEARCHUSERPAGE);

	}
}
