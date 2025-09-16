package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void sendDataToElement(WebElement element,String text) {
		element.sendKeys(text);
	}
	public void clickonelement(WebElement element) {
		element.click();
	
	}
	public  String getElementText(WebElement element) {
        return element.getText();
    }
	public  void selectByVisibleText(WebElement dropdownElement, String visibleText) {
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(visibleText);
    }
	public void scrollToElement(WebDriver driver, WebElement element) {
	    Actions actions=new Actions(driver);
	    actions.moveToElement(element).perform();
	}

	public void javaScriptClick(WebDriver driver, By locator) {
	    WebElement element = driver.findElement(locator);
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", element);
	}
	
	public void clearElementData(WebElement element) {
		element.clear();
	}
}
