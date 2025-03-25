package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUserPage {
	public WebDriver driver;

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()=' New']")
	WebElement newButton;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement searchButton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	WebElement resetButton;
	@FindBy(xpath = "(//a[@class='btn btn-sm btn btn-danger btncss'])[1]")
	WebElement deleteButton;

	public AddNewUserPage clickOnNew() {
		newButton.click();
		return new AddNewUserPage(driver);
	}

	public SearchUserPage clickOnSearch() {
		searchButton.click();
		return new SearchUserPage(driver);
	}

	public AdminUserPage clickOnReset() {
		resetButton.click();
		return this;
	}

	public AdminUserPage clickOnDelete() {
		deleteButton.click();
		driver.switchTo().alert().accept();
		return this;
	}

}
