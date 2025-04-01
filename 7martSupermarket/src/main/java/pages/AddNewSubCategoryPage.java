package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtility;

public class AddNewSubCategoryPage {
	PageUtility pageUtility = new PageUtility();
	FileUploadUtility fileUpload = new FileUploadUtility();
	public WebDriver driver;

	public AddNewSubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@id='cat_id']")
	WebElement categoryDropdown;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement addSubCategory;
	@FindBy(xpath = "//input[@id='subcategory']")
	WebElement subCategoryTextField;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement chooseFile;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveSubCategory;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	@FindBy(xpath = "(//i[@class='fas fa-edit'])[2]")
	WebElement editSubCategory;

	public AddNewSubCategoryPage enterDetailsofSubCategory(String category,String subCategory) {
		pageUtility.selectByVisibleText(categoryDropdown, category);
		subCategoryTextField.sendKeys(subCategory);
		return this;
	}

	public AddNewSubCategoryPage chooseFile()
	{
		fileUpload.fileUploadforSendKey(chooseFile, Constant.CATEGORYIMAGEPATH);
		return this;
	}
	public AddNewSubCategoryPage clickOnAddNewSubCategory() {
		addSubCategory.click();
		return this;
	}

	public AddNewSubCategoryPage saveNewSubCategory() {
		saveSubCategory.click();
		return this;
	}

	public UpdateSubCategoryPage editSubCategory() {
		editSubCategory.click();
		return new UpdateSubCategoryPage(driver);
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}
}
