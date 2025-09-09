package testscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNgBase;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends TestNgBase {
	@Test(priority =1,description = "verify login with valid credentials")
	public void verifyloginwithvalidcredentials() throws IOException {
		String usernameValue=ExcelUtility.getStringData(1, 0,"LoginPage" );
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterusername(usernameValue);
		loginpage.enterpassword(passwordValue);
		loginpage.signin(); 
	String expected="https://groceryapp.uniqassosiates.com/admin";
	String actual=driver.getCurrentUrl();
	Assert.assertEquals(actual, expected,"Login is not successfull");
	}
	


	@Test(priority = 2)
	public void verifyloginwithvalidusernameandinvalidpassword() throws IOException {
		String username=ExcelUtility.getStringData(2, 0, "LoginPage");
		String password=ExcelUtility.getStringData(2, 1, "LoginPage");
		WebElement user=driver.findElement(By.xpath("//input[@name='username']"));
		user.sendKeys(username);
		WebElement passwords=driver.findElement(By.xpath("//input[@name='password']"));
		passwords.sendKeys(password);
		WebElement sigining=driver.findElement(By.xpath("//button[@type='submit']"));
		sigining.click();
	
}
	@Test(priority = 3)
	public void verifyloginwithinvalidusernameandvalidpassword() throws IOException {
		String username=ExcelUtility.getStringData(3, 0, "LoginPage");
		String password=ExcelUtility.getStringData(3, 1, "LoginPage");
		WebElement user=driver.findElement(By.xpath("//input[@name='username']"));
		user.sendKeys(username);
		WebElement passwords=driver.findElement(By.xpath("//input[@name='password']"));
		passwords.sendKeys(password);
		WebElement sigining=driver.findElement(By.xpath("//button[@type='submit']"));
		sigining.click();
	
}
	@Test(priority = 4)
	public void verifyloginwithinvalidcredentials() throws IOException {
		String username=ExcelUtility.getStringData(4, 0, "LoginPage");
		String password=ExcelUtility.getStringData(4, 1, "LoginPage");
		WebElement user=driver.findElement(By.xpath("//input[@name='username']"));
		user.sendKeys(username);
		WebElement passwords=driver.findElement(By.xpath("//input[@name='password']"));
		passwords.sendKeys(password);
		WebElement sigining=driver.findElement(By.xpath("//button[@type='submit']"));
		sigining.click();
	
	
}
}
