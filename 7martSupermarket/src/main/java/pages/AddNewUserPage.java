package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;
import utilities.WaitUtility;

public class AddNewUserPage {

	public WebDriver driver;
	PageUtility pageUtilities = new PageUtility();
	WaitUtility waitUtility = new WaitUtility();

	public AddNewUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement userName;
	@FindBy(xpath = "//input[@type='password']")
	WebElement password;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement userTypeDropdown;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;

	@FindBys({ @FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[1]") })
	List<WebElement> usernameData;

	public AddNewUserPage enterDetailsofNewUser(String uname, String pwd) {
		userName.sendKeys(uname);
		password.sendKeys(pwd);
		pageUtilities.selectByIndexValue(userTypeDropdown, 1);
		return new AddNewUserPage(driver);
	}

	public AddNewUserPage clickOnSave() {
		saveButton.click();
		return this;
	}

	public boolean isalertDisplayed() {
		return alert.isDisplayed();
	}

}
