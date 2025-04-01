package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.LoginPage;
import pages.AddNewsPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;
import utilities.PageUtility;

public class AddNewsPageTest extends Base {
	ExcelUtility excelUtility = new ExcelUtility();
	FakerUtility fakerUtility = new FakerUtility();
	PageUtility pageUtility = new PageUtility();
	AddNewsPage addNewsPage;

	@Test
	public void checkWhetherUserCanAddNews() throws IOException {
		String userName = excelUtility.getStringData(3, 0, "LoginPage");
		String password = excelUtility.getStringData(3, 1, "LoginPage");
		String news = fakerUtility.getFakeBookName();
		LoginPage loginPage = new LoginPage(driver);
		addNewsPage = loginPage.enterUsernameAndPassword(userName, password).clickOnSigninButton().clickOnNewsMoreInfo()
				.clickOnAddNews().addNewsDetails(news).saveNews();
		boolean isAlertDisplayed = addNewsPage.isalertDisplayed();
		System.out.println("isAlertDisplayed:" + isAlertDisplayed);
		Assert.assertTrue(isAlertDisplayed, Constant.ERRORMESSAGEFORALERT);

	}
}
