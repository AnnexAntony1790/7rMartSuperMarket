package testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.AddCategoryPage;
import pages.CategoryPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AddCategoryPageTest extends Base {
	HomePage homePage;
	CategoryPage categoryPage;
	AddCategoryPage addCategoryPage;
	FakerUtility fakerUtility = new FakerUtility();

	@Test
	public void verifyUsercanAddCategory() throws AWTException, IOException {
		String userName = ExcelUtility.getStringData(3, 0, "LoginPage");
		String password = ExcelUtility.getStringData(3, 1, "LoginPage");
		String category = fakerUtility.getFakeProductName();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameAndPassword(userName, password);
		homePage = loginPage.clickOnSigninButton();
		categoryPage = homePage.clickonCategoryMoreInfo();
		addCategoryPage = categoryPage.clickOnNewCategory().categoryDetails(category).clickGroup().clickOnRadio()
				.fileUpload().saveCategory();
		boolean isAlertDisplayed = addCategoryPage.isalertDisplayed();
		System.out.println(isAlertDisplayed);
		Assert.assertTrue(isAlertDisplayed, Constant.ERRORMESSAGEFORALERT);

	}
}
