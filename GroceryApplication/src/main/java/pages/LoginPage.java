package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//input[@name='username']")WebElement usernamefield;
	public void enterusername(String usernameValue) {
		
		//usernamefield.sendKeys(usernameValue);
		
		
	}
	@FindBy(xpath="//input[@name='password']")WebElement passwords;
	public void enterpassword(String passwordValue) {
	passwords.sendKeys(passwordValue);
	}
	@FindBy(xpath="//button[@type='submit']")WebElement signin;
	public void signin() {
	signin.click();
		
	}
}