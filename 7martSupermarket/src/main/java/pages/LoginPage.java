package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@type='text']")
	WebElement userName;
	@FindBy(xpath = "//input[@type='password']")
	WebElement password;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement signInButton;
	@FindBy(xpath = "//li[text()='Dashboard']")
	WebElement dashBoard;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")WebElement alert;

	public LoginPage enterUsernameAndPassword(String uname, String pwd) {
		userName.sendKeys(uname);
		password.sendKeys(pwd);
		return this;
	}

	public HomePage clickOnSigninButton() {
		signInButton.click();
		return new HomePage(driver);
	}

	public boolean isDashBoardDisplayed() {
		return dashBoard.isDisplayed();
	}
	
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
	}
	
}
