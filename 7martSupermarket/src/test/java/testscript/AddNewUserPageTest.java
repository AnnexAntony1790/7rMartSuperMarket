package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddNewUserPage;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;

public class AddNewUserPageTest extends Base {

	HomePage homePage;
	AdminUserPage adminUserPage;
	AddNewUserPage newUserPage;

	@Test
	public void verifyNewUserCanBeAdded() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameAndPassword("admin", "admin");
		homePage = loginPage.clickOnSigninButton();
		adminUserPage = homePage.clickOnMoreInfo();
		newUserPage = adminUserPage.clickOnNew().enterDetailsofNewUser("liyaden", "den").clickOnSave();
		boolean isAlertDisplayed = newUserPage.isalertDisplayed();
		Assert.assertTrue(isAlertDisplayed, "User is not saved");

	}
}
