package testscript;

import java.io.IOException;

import org.apache.commons.compress.harmony.unpack200.bytecode.ConstantPoolEntry;
import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.AddNewUserPage;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AddNewUserPageTest extends Base {

	HomePage homePage;
	AdminUserPage adminUserPage;
	AddNewUserPage newUserPage;
	FakerUtility fakerUtility=new FakerUtility();	

	@Test
	public void verifyIfNewUserCanBeAdded() throws IOException {
		String userName = ExcelUtility.getStringData(3, 0, "LoginPage");
		String password = ExcelUtility.getStringData(3, 1, "LoginPage");
		String newUser = fakerUtility.getFakeFirstName();
		String newPassword= fakerUtility.getPassword();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameAndPassword(userName, password);
		homePage = loginPage.clickOnSigninButton();
		adminUserPage = homePage.clickOnAdminUserMoreInfo();
		newUserPage = adminUserPage.clickOnNew().enterDetailsofNewUser(newUser, newPassword).clickOnSave();
		boolean isAlertDisplayed = newUserPage.isalertDisplayed();
		Assert.assertTrue(isAlertDisplayed, Constant.ERRORMESSAGEFORALERT);

	}
}
