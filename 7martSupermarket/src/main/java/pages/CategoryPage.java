package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage {
	public WebDriver driver;

	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newCategory;
	@FindBy(xpath = "(//i[@class='fas fa-edit'])[2]")
	WebElement editCategory;
	@FindBy(xpath = "(//i[@class='fas fa-edit'])[2]")
	WebElement editSubCategory;

	public AddCategoryPage clickOnNewCategory() {
		newCategory.click();
		return new AddCategoryPage(driver);
	}

	public UpdateCategoryPage clickOnEditCategory() {
		editCategory.click();
		return new UpdateCategoryPage(driver);
	}

	public UpdateSubCategoryPage clickonEditSubCategory() {
		editSubCategory.click();
		return new UpdateSubCategoryPage(driver);
	}

}
