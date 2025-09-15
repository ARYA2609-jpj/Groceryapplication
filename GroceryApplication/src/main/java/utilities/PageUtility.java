package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void sendDataToElement(WebElement element,String text) {
		element.sendKeys(text);
	}
	public void clickonelement(WebElement element) {
		element.click();
	
	}
	public static String getElementText(WebElement element) {
        return element.getText();
    }
	public static void selectDataByVisibleText(WebElement element, String visibleText) {
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }
}
