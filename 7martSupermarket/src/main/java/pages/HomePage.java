package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.WaitUtility;

public class HomePage {
	public WebDriver driver;
	WaitUtility waitUtility = new WaitUtility();

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement admin;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']")
	WebElement logout;
	@FindBy(xpath = "(//a[text()='More info '])[1]")
	WebElement moreInfo;
	@FindBy(xpath = "(//a[text()='More info '])[3]")
	WebElement categoryMoreInfo;
	@FindBy(xpath = "(//a[text()='More info '])[4]")
	WebElement subCategoryMoreInfo;
	@FindBy(xpath = "(//a[text()='More info '])[5]")
	WebElement contactMoreInfo;
	@FindBy(xpath = "(//a[text()='More info '])[9]")
	WebElement newsMoreInfo;

	public HomePage clickOnAdmin() {
		waitUtility.waitForElementToBeClicked(driver, admin);
		admin.click();
		return this;
	}

	public HomePage clickOnLogout() {
		logout.click();
		return this;
	}

	public AdminUserPage clickOnAdminUserMoreInfo() {
		moreInfo.click();
		return new AdminUserPage(driver);
	}

	public CategoryPage clickonCategoryMoreInfo() {
		categoryMoreInfo.click();
		return new CategoryPage(driver);
	}

	public AddNewSubCategoryPage clickonSubCategoryMoreInfo() {
		subCategoryMoreInfo.click();
		return new AddNewSubCategoryPage(driver);
	}

	public ContactUsPage clickonContactMoreInfo() {
		contactMoreInfo.click();
		return new ContactUsPage(driver);
	}

	public AddNewsPage clickOnNewsMoreInfo() {
		newsMoreInfo.click();
		return new AddNewsPage(driver);
	}

}
