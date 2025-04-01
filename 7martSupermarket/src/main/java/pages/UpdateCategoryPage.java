package pages;

import java.awt.AWTException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;
import utilities.FileUploadUtility;
import utilities.WaitUtility;

public class UpdateCategoryPage {
	WaitUtility waitUtility = new WaitUtility();
	FileUploadUtility fileUpload = new FileUploadUtility();

	public WebDriver driver;

	public UpdateCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='category']")
	WebElement categoryTextField;
	@FindBy(xpath = "//li[@id='134-selection']")
	WebElement selectgroup;
	@FindBy(id = "main_img")
	WebElement image;
	@FindBy(xpath = "//span[@class='fas fa-trash-alt']")
	WebElement deleteImage;
	@FindBy(xpath = "//input[@type='file']")
	WebElement chooseFile;
	@FindBy(xpath = "//button[@name='update']")
	WebElement updateCategory;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;

	public UpdateCategoryPage editCategoryField() {
		waitUtility.waitForElementToBeClicked(driver, categoryTextField);
		categoryTextField.clear();
		categoryTextField.sendKeys("Juice Maker");
		return this;
	}

	public UpdateCategoryPage selectGroup() {
		selectgroup.click();
		return this;
	}

	public UpdateCategoryPage deleteImage() {
		waitUtility.waitForElementToBeClicked(driver, deleteImage);
		deleteImage.click();
		driver.switchTo().alert().accept();
		return this;
	}

	public UpdateCategoryPage chooseFile() {
		fileUpload.fileUploadforSendKey(chooseFile, Constant.IMAGEPATH);
		return this;
	}

	public UpdateCategoryPage update() {
		JavascriptExecutor javaExecutor = (JavascriptExecutor) driver;
		javaExecutor.executeScript("window.scrollBy(0,1000)");// scroll down
		javaExecutor.executeScript("arguments[0].click();", updateCategory);
		return this;
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}

}
