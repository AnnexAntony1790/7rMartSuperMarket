package testscript;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddNewUserPage;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchUserPage;

public class SearchUserPageTest extends Base {
	HomePage homePage;
	AdminUserPage adminUserPage;
	AddNewUserPage newUserPage;
	SearchUserPage searchUserPage;

	@Test
	public void verifySearchforaUser() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameAndPassword("admin", "admin");
		homePage = loginPage.clickOnSigninButton();
		adminUserPage = homePage.clickOnMoreInfo();
		searchUserPage = adminUserPage.clickOnSearch().enterUsername("Anu").clickOnSearchUser();
		searchUserPage.elementSearch("Anu");
		
		boolean tableDisplayed=searchUserPage.isTableDisplayed();
		Assert.assertTrue(tableDisplayed,"Result Not Found");
		
	}
}
