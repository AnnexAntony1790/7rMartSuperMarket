package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.ContactUsPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class UpdateContactUsPageTest extends Base {
	ExcelUtility excelUtility = new ExcelUtility();
	HomePage homePage;
	ContactUsPage contactUsPage;

	@Test
	public void verifyIfUserCanEditContactDetails() throws IOException {
		LoginPage loginPage = new LoginPage(driver);
		String userName = excelUtility.getStringData(3, 0, "LoginPage");
		String password = excelUtility.getStringData(3, 1, "LoginPage");
		contactUsPage = loginPage.enterUsernameAndPassword(userName, password).clickOnSigninButton()
				.clickonContactMoreInfo().clickOnEditContact().updateDetails().updateContact();
		boolean isAlertDisplayed = contactUsPage.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed, Constant.ERRORMESSAGEFORALERT);

	}
}
