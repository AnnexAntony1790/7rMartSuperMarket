package testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.CategoryPage;
import pages.UpdateCategoryPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class UpdateCategoryPageTest extends Base {
	ExcelUtility excelUtility = new ExcelUtility();
	HomePage homePage;
	UpdateCategoryPage editCategory;

	@Test
	public void verifyIfUserCanEditCategoryPage() throws IOException, AWTException {
		LoginPage loginPage = new LoginPage(driver);
		String userName = excelUtility.getStringData(3, 0, "LoginPage");
		String password = excelUtility.getStringData(3, 1, "LoginPage");
		homePage = loginPage.enterUsernameAndPassword(userName, password).clickOnSigninButton();
		editCategory = homePage.clickonCategoryMoreInfo().clickOnEditCategory().deleteImage().chooseFile()
				.editCategoryField().update();
		boolean isAlertDisplayed = editCategory.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed, Constant.ERRORMESSAGEFORALERT);
	}
}
