package testscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNgBase;
import constant.Constants;
import constant.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends TestNgBase {
	@Test(description ="Verify user logout")
	public void verifylogout() throws IOException {
		String usernameValue=ExcelUtility.getStringData(1, 0,Constants.LOGINSHEET );
		String passwordValue=ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);
		LoginPage loginpage=new LoginPage(driver);

		loginpage.enterusername(usernameValue);
		loginpage.enterpassword(passwordValue);
		loginpage.signin(); 
		HomePage homePage=new HomePage(driver);
		homePage.clicklogouticon();
		homePage.clicklogout();
		String expected="https://groceryapp.uniqassosiates.com/admin/login";
		String actual=driver.getCurrentUrl();
		Assert.assertEquals(actual, expected,Messages.LOGOUT_ERROR);

	}

}
