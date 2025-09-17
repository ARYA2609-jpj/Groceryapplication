package pages;

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
    @FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")WebElement admintile;

    public AdminPage clickadmintile() {
        pageUtility.clickonelement(admintile);
        return new AdminPage(driver);
    }
    @FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")WebElement newstile;

    public NewsPage clicknewstile() {
    	waitutility.waitUntilClickable(driver, newstile);
        pageUtility.clickonelement(newstile);
        return new NewsPage(driver);
    }
}
