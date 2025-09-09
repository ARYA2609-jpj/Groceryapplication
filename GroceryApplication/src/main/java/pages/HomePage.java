package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
		public WebDriver driver;
		public HomePage (WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);

}
		@FindBy(xpath="//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']")WebElement logouticon;
		public void clicklogouticon() {
		logouticon.click();
		}
		@FindBy(xpath="//i[@class='ace-icon fa fa-power-off' ]")WebElement logout;
		public void clicklogout() {
		logout.click();
		}
	}

