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
	public void verifyIfNewSubCategoryCanBeAdded() throws IOException {
		LoginPage loginPage = new LoginPage(driver);
		String userName = excelUtility.getStringData(3, 0, "LoginPage");
		String password = excelUtility.getStringData(3, 1, "LoginPage");
		addNewSubCategoryPage = loginPage.enterUsernameAndPassword(userName, password).clickOnSigninButton()
				.clickonSubCategoryMoreInfo().clickOnAddNewSubCategory().enterSubCategoryDetails().save();
		boolean isAlertDisplayed=addNewSubCategoryPage.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed, Constant.ERRORMESSAGEFORALERT);

	}
}
