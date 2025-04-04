package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages.HomePage;

public class PageUtility {
	public WebDriver driver;
	JavascriptExecutor javaExecutor;

	public void selectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void selectByIndexValue(WebElement element, int value) {
		Select select = new Select(element);
		select.selectByIndex(value);
	}

	public void executeScript(WebElement element,WebDriver driver) {
		JavascriptExecutor javaExecutor = (JavascriptExecutor) driver;
		javaExecutor.executeScript("window.scrollBy(0,1000)");// scroll down
		javaExecutor.executeScript("arguments[0].click();", element);
	}

}
