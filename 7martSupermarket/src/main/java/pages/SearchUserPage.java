package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class SearchUserPage {
	public WebDriver driver;

	public SearchUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='un']")
	WebElement username;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchUserButton;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody")
	WebElement table;

	@FindBys({ @FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[1]"), })
	List<WebElement> columnUsername;
	
	
	public SearchUserPage enterUsername(String un) {
		username.sendKeys(un);
		return this;
	}

	public SearchUserPage clickOnSearchUser() {
		searchUserButton.click();
		return this;
	}

	public SearchUserPage elementSearch(String uname) {

		for (WebElement element : columnUsername) {
			if (element.getText().equals(uname)) {
				System.out.println("Search Element Found:"+element.getText());
			}			
		}
		return this;
	}
	
	public boolean isTableDisplayed() {
		return table.isDisplayed();
	}
	

}
