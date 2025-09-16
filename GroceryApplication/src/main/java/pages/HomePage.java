package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class HomePage {
    public WebDriver driver;
    PageUtility pageUtility = new PageUtility();
    WaitUtility waitutility= new WaitUtility();
    

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']")WebElement logouticon;

    public HomePage clicklogouticon() {
        pageUtility.clickonelement(logouticon);
        return this;
    }

    @FindBy(xpath = "//i[@class='ace-icon fa fa-power-off' ]")WebElement logout;

    public LoginPage clicklogout() {
    	waitutility.waitUntilClickable(driver, logout);
        pageUtility.clickonelement(logout);
        return new LoginPage(driver);
    }
}
