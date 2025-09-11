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
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'and@class='small-box-footer']")WebElement admintile;
	public void clickadmintile() {
		admintile.click();
	}
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement newfield;
	public void clicknewbutton() {

		newfield.click();
	}
	@FindBy(xpath="//input[@name='username']")WebElement username;
	public void enterusername(String name) {

		username.sendKeys(name);
	}
	@FindBy(xpath="//input[@name='password']")WebElement passwordvalue;
	public void enterpassword(String password) {

		passwordvalue.sendKeys(password);
	}
	@FindBy(xpath="//select[@id='user_type']")WebElement usertype;
	public void selectusertype(String userTypevalue ) {

		Select select=new Select(usertype);
		select.selectByVisibleText(userTypevalue);
	}
	@FindBy(xpath="//button[@name='Create']")WebElement savefield;
	public void clicksavebutton() {

		savefield.click();
	}
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")WebElement searchbutton;
	public void clicksearchbutton() {
	    searchbutton.click();
	}

	@FindBy(xpath="//input[@name='un']")WebElement searchusername;
	public void entersearchusername(String uname) {
	    searchusername.sendKeys(uname);
	}

	@FindBy(xpath="//select[@name='ut']")WebElement searchusertype;
	public void selectsearchusertype(String userTypevalue) {
	    Select select = new Select(searchusertype);
	    select.selectByVisibleText(userTypevalue);
	}

	@FindBy(xpath="//button[@name='Search']")WebElement searchfield;
	public void clicksearchfield() {
	    searchfield.click();
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")WebElement newstile;
	public void clicknewstile() {
	    newstile.click();
	}

	@FindBy(xpath="//li[@class='breadcrumb-item']")WebElement home;
	public void clickhome() {
	    home.click();
	}
	public String getAlertMessage() {
		// TODO Auto-generated method stub
		WebElement alert = driver.findElement(By.xpath("//div[contains(@class,'alert')]"));
        return alert.getText();
    }
}




