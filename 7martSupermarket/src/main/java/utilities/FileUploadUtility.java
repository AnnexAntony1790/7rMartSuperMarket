package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;

public class FileUploadUtility {
	public void fileUploadforSendKey(WebElement element,String path)
	{
		element.sendKeys(path);
	}
	public void fileUploadforRobotClass(WebElement element,String path) throws AWTException
	{
		StringSelection stringSelection = new StringSelection("C:\\Annex\\Java\\Assignments\\pdf\\Aggregation.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);// copy path to clipboard
		Robot robot = new Robot();
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(2000);
	}

}
