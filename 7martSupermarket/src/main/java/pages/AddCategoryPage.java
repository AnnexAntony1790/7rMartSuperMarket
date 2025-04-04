package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.lang.invoke.ConstantBootstraps;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class AddCategoryPage {
	public WebDriver driver;
	PageUtility pageUtilities = new PageUtility();
	FileUploadUtility fileUpload = new FileUploadUtility();
	WaitUtility waitUtility = new WaitUtility();

	public AddCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='category']")
	WebElement categoryTextField;
	@FindBy(xpath = "//li[@id='134-selectable']")
	WebElement categorySelect;
	@FindBy(xpath = "//input[@type='file']")
	WebElement chooseFile;
	@FindBy(xpath = "(//input[@type='radio'])[1]")
	WebElement radioButton1;
	@FindBy(xpath = "(//input[@type='radio'])[2]")
	WebElement radioButton2;
	@FindBy(xpath = "(//input[@type='radio'])[3]")
	WebElement radioButton3;
	@FindBy(xpath = "(//input[@type='radio'])[4]")
	WebElement radioButton4;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveCategory;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;

	public AddCategoryPage categoryDetails(String category) {
		categoryTextField.sendKeys(category);
		return this;
	}

	public AddCategoryPage clickGroup() {
		waitUtility.waitForElementToBeClicked(driver, categorySelect);
		categorySelect.click();
		return this;
	}

	public AddCategoryPage clickOnRadio() {
		radioButton2.click();
		radioButton4.click();
		return this;
	}

	public AddCategoryPage fileUpload() throws AWTException {

		waitUtility.waitForElementToBeClicked(driver, chooseFile);
		fileUpload.fileUploadforSendKey(chooseFile, Constant.CATEGORYIMAGEPATH);
		return this;
	}

	public AddCategoryPage saveCategory() {
		pageUtilities.executeScript(saveCategory, driver);
		return this;
	}

	public boolean isalertDisplayed() {
		return alert.isDisplayed();
	}

}
