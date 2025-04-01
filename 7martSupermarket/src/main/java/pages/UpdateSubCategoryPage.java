package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtility;

public class UpdateSubCategoryPage {
	PageUtility pageUtility=new PageUtility();
	FileUploadUtility fileUpload=new FileUploadUtility();
	public WebDriver driver;

	public UpdateSubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@id='cat_id']")
	WebElement subCategoryDropDown;
	@FindBy(xpath = "//input[@id='subcategory']")
	WebElement subCategoryTextField;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement chooseFile;
	@FindBy(xpath="//button[@name='update']")
	WebElement update;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	
	public UpdateSubCategoryPage updateDetails()
	{
		pageUtility.selectByVisibleText(subCategoryDropDown, "Electronics");
		subCategoryTextField.clear();
		subCategoryTextField.sendKeys("Mobile Phones");
		fileUpload.fileUploadforSendKey(chooseFile, Constant.PATH);
		return this;
	}
	public UpdateSubCategoryPage updateSubCategory()
	{
		update.click();
		return this;
	}
	
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();		
	}
	

}
