package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminPage {
    public WebDriver driver;
    PageUtility pageUtility = new PageUtility();
    WaitUtility waitutility= new WaitUtility();

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    

    @FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")WebElement newfield;

    public AdminPage clicknewbutton() {
        pageUtility.clickonelement(newfield); 
        return this;
    }

    @FindBy(xpath = "//input[@name='username']")WebElement username;

    public AdminPage enterusername(String name) {
        pageUtility.sendDataToElement(username, name);
        return this;
    }

    @FindBy(xpath = "//input[@name='password']")WebElement passwordvalue;

    public AdminPage enterpassword(String password) {
        pageUtility.sendDataToElement(passwordvalue, password);
        return this;
    }

    @FindBy(xpath = "//select[@id='user_type']")WebElement usertype;

    public AdminPage selectusertype(String userTypevalue) {
        pageUtility.selectByVisibleText(usertype, userTypevalue);
        return this;
    }

    @FindBy(xpath = "//button[@name='Create']")WebElement savefield;

    public AdminPage clicksavebutton() {
        pageUtility.clickonelement(savefield);
        return this;
    }

    @FindBy(xpath = "//div[contains(@class,'alert alert-success')]") WebElement addUserAlert;

    public boolean isAlertDisplayed() {
        try {
            return addUserAlert.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getAlertMessage() {
        return addUserAlert.getText().trim();  
    }

    @FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")WebElement searchbutton;

    public void clicksearchbutton() {
    	waitutility.waitUntilClickable(driver, searchbutton);
        pageUtility.clickonelement(searchbutton);  
    }

    @FindBy(xpath = "//input[@name='un']")WebElement searchusername;

    public AdminPage entersearchusername(String uname) {
        pageUtility.sendDataToElement(searchusername, uname); 
        return this;
    }

    @FindBy(xpath = "//select[@name='ut']") WebElement searchusertype;

    public AdminPage selectsearchusertype(String userTypevalue) {
        pageUtility.selectByVisibleText(searchusertype, userTypevalue);
        return this;
    }

    @FindBy(xpath = "//button[@name='Search']")WebElement searchfield;

    public AdminPage adminclicksearchfield() {
        pageUtility.clickonelement(searchfield);
        return this;
    }

    public boolean isUserPresentInSearchResults(String expectedUser) {
        try {
            WebElement result = driver.findElement(By.xpath("//table//td[contains(text(),'" + expectedUser + "')]"));
            return result.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")WebElement newstile;

    public void clicknewstile() {
        pageUtility.clickonelement(newstile);  
    }

    @FindBy(xpath = "//li[@class='breadcrumb-item']/a[text()='Home']")WebElement home;

    public HomePage clickhome() {
        pageUtility.clickonelement(home);
        return new HomePage(driver);
    }
}