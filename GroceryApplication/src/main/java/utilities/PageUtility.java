package utilities;

import org.openqa.selenium.WebElement;

public class PageUtility {
	public void sendDataToElement(WebElement element,String text) {
		element.sendKeys(text);
	}
	public void clickonelement(WebElement element) {
		element.click();
	
	}

}
