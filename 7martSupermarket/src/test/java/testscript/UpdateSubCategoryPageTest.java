package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.AddNewSubCategoryPage;
import pages.CategoryPage;
import pages.HomePage;
import pages.LoginPage;
import pages.UpdateSubCategoryPage;
import utilities.ExcelUtility;

public class UpdateSubCategoryPageTest extends Base {
	ExcelUtility excelUtility = new ExcelUtility();
	HomePage homePage;
	CategoryPage categoryPage;
	UpdateSubCategoryPage updateSubCategoryPage;

	@Test
	public void verifyIfUserCanUpdateSubCategory() throws IOException {
		LoginPage loginPage = new LoginPage(driver);
		String userName = excelUtility.getStringData(3, 0, "LoginPage");
		String password = excelUtility.getStringData(3, 1, "LoginPage");
		homePage = loginPage.enterUsernameAndPassword(userName, password).clickOnSigninButton();
		updateSubCategoryPage = homePage.clickonSubCategoryMoreInfo().editSubCategory().updateDetails()
				.updateSubCategory();
		boolean isAlertDisplayed = updateSubCategoryPage.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed, Constant.ERRORMESSAGEFORALERT);

	}
}
