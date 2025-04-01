package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.AddNewSubCategoryPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AddNewSubCategoryPageTest extends Base {
	ExcelUtility excelUtility = new ExcelUtility();
	AddNewSubCategoryPage addNewSubCategoryPage;

	@Test
	public void checkWhetherUserCanAddNewSubCategory() throws IOException {
		LoginPage loginPage = new LoginPage(driver);
		String userName = excelUtility.getStringData(3, 0, "LoginPage");
		String password = excelUtility.getStringData(3, 1, "LoginPage");
		String categoryName = excelUtility.getStringData(1, 0, "CategoryPage");
		String subCategoryName = excelUtility.getStringData(1, 1, "CategoryPage");
		addNewSubCategoryPage = loginPage.enterUsernameAndPassword(userName, password).clickOnSigninButton()
				.clickonSubCategoryMoreInfo().clickOnAddNewSubCategory()
				.enterDetailsofSubCategory(categoryName, subCategoryName).chooseFile().saveNewSubCategory();
		boolean isAlertDisplayed = addNewSubCategoryPage.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed, Constant.ERRORMESSAGEFORALERT);

	}
}
