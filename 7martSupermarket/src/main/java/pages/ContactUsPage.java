package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
	public WebDriver driver;

	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='fas fa-edit']")
	WebElement editContact;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phoneNo;
	@FindBy(xpath = "//input[@id='email']")
	WebElement email;
	@FindBy(xpath = "(//textarea[@id='content'])[1]")
	WebElement address;
	@FindBy(xpath = "(//textarea[@id='content'])[2]")
	WebElement deliveryTime;
	@FindBy(xpath = "//input[@id='del_limit']")
	WebElement deliveryChargeLimit;
	@FindBy(xpath = "//button[@name='Update']")
	WebElement updateContact;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;

	public ContactUsPage clickOnEditContact() {
		editContact.click();
		return this;
	}

	public ContactUsPage updateDetails() {
		phoneNo.clear();
		phoneNo.sendKeys("987654321");
		email.clear();
		email.sendKeys("7rmart@gmail.com");
		address.clear();
		address.sendKeys("733 Mountain Ave, Springfield,SanFrancisco");
		deliveryChargeLimit.clear();
		deliveryChargeLimit.sendKeys("50");
		deliveryTime.clear();
		deliveryTime.sendKeys("7:00 am to 7:00 pm");
		return this;
	}

	public ContactUsPage updateContact() {
		updateContact.click();
		return this;
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}

}
