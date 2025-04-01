package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class AddNewsPage {
	public WebDriver driver;
	
	WaitUtility wait=new WaitUtility();

	public AddNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement addNewsButton;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement newsTextArea;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveButton;
	@FindBy(xpath = "//a[text()='Cancel']")
	WebElement cancelButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;

	public AddNewsPage clickOnAddNews() {
		addNewsButton.click();
		return this;
	}

	public AddNewsPage addNewsDetails(String news) {
		newsTextArea.sendKeys(news);
		return this;
	}
	public AddNewsPage saveNews() {
		saveButton.click();
		return this;
	}

	public boolean isalertDisplayed() {
		return alert.isDisplayed();
	}

}
