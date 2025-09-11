package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminPage {
	public WebDriver driver;
	public AdminPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']") WebElement admintile;

    public void clickadmintile() {
        admintile.click();
    }

    
    @FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']") WebElement newfield;

    public void clicknewbutton() {
        newfield.click();
    }

    
    @FindBy(xpath = "//input[@name='username']")WebElement username;

    public void enterusername(String name) {
        username.sendKeys(name);
    }

    // Password
    @FindBy(xpath = "//input[@name='password']")WebElement passwordvalue;

    public void enterpassword(String password) {
        passwordvalue.sendKeys(password);
    }

    
    @FindBy(xpath = "//select[@id='user_type']")WebElement usertype;

    public void selectusertype(String userTypevalue) {
        Select select = new Select(usertype);
        select.selectByVisibleText(userTypevalue);
    }

    
    @FindBy(xpath = "//button[@name='Create']")WebElement savefield;

    public void clicksavebutton() {
        savefield.click();
    }

    
    @FindBy(xpath = "//div[contains(@class,'alert alert-success')]")WebElement addUserAlert;

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

    // Search section
    @FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")WebElement searchbutton;

    public void clicksearchbutton() {
        searchbutton.click();
    }

    @FindBy(xpath = "//input[@name='un']")WebElement searchusername;

    public void entersearchusername(String uname) {
        searchusername.sendKeys(uname);
    }

    @FindBy(xpath = "//select[@name='ut']")WebElement searchusertype;

    public void selectsearchusertype(String userTypevalue) {
        Select select = new Select(searchusertype);
        select.selectByVisibleText(userTypevalue);
    }

    @FindBy(xpath = "//button[@name='Search']")WebElement searchfield;

    public void clicksearchfield() {
        searchfield.click();
    }

    public boolean isUserPresentInSearchResults(String expectedUser) {
        try {
            WebElement result = driver.findElement(By.xpath("//table//td[contains(text(),'" + expectedUser + "')]"));
            return result.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // News tile
    @FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")WebElement newstile;

    public void clicknewstile() {
        newstile.click();
    }

    // Home
    @FindBy(xpath = "//li[@class='breadcrumb-item']/a[text()='Home']")WebElement home;

    public void clickhome() {
        home.click();
    }
}



