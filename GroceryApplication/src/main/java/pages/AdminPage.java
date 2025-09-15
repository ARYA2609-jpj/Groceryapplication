package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminPage {
    public WebDriver driver;
    PageUtility pageUtility = new PageUtility();  

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")WebElement admintile;

    public void clickadmintile() {
        pageUtility.clickonelement(admintile);  
    }

    @FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")WebElement newfield;

    public void clicknewbutton() {
        pageUtility.clickonelement(newfield); 
    }

    @FindBy(xpath = "//input[@name='username']")WebElement username;

    public void enterusername(String name) {
        pageUtility.sendDataToElement(username, name);  
    }

    @FindBy(xpath = "//input[@name='password']")WebElement passwordvalue;

    public void enterpassword(String password) {
        pageUtility.sendDataToElement(passwordvalue, password);  
    }

    @FindBy(xpath = "//select[@id='user_type']")WebElement usertype;

    public void selectusertype(String userTypevalue) {
        Select select = new Select(usertype);
        select.selectByVisibleText(userTypevalue);
    }

    @FindBy(xpath = "//button[@name='Create']")WebElement savefield;

    public void clicksavebutton() {
        pageUtility.clickonelement(savefield);  
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
        pageUtility.clickonelement(searchbutton);  
    }

    @FindBy(xpath = "//input[@name='un']")WebElement searchusername;

    public void entersearchusername(String uname) {
        pageUtility.sendDataToElement(searchusername, uname); 
    }

    @FindBy(xpath = "//select[@name='ut']") WebElement searchusertype;

    public void selectsearchusertype(String userTypevalue) {
        Select select = new Select(searchusertype);
        select.selectByVisibleText(userTypevalue);
    }

    @FindBy(xpath = "//button[@name='Search']")WebElement searchfield;

    public void clicksearchfield() {
        pageUtility.clickonelement(searchfield);  
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

    public void clickhome() {
        pageUtility.clickonelement(home);  
    }
}