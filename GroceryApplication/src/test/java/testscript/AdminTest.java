package testscript;

import static org.testng.Assert.assertThrows;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNgBase;
import constant.Constants;
import constant.Messages;
import pages.AdminPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminTest extends TestNgBase {
	@Test(description = "Verify add user")
	public void verifyadduser() throws IOException{
		String usernameValue=ExcelUtility.getStringData(1, 0,Constants.LOGINSHEET );
		String passwordValue=ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterusername(usernameValue);
		loginpage.enterpassword(passwordValue);
		loginpage.signin();
		String expected="https://groceryapp.uniqassosiates.com/admin";
		String actual=driver.getCurrentUrl();
		Assert.assertEquals(actual, Messages.VALID_CREDENTIALS_ERROR);

		FakerUtility fakerUtility = new FakerUtility();
		String name=fakerUtility.createRandomUserName();
		String password=fakerUtility.createRandomPassword();
		String userTypevalue=ExcelUtility.getStringData(1, 2, Constants.ADMINSHEET);
		AdminPage adminpage=new AdminPage(driver);
		adminpage.clickadmintile();
		adminpage.clicknewbutton();
		adminpage.enterusername(usernameValue);
		adminpage.enterpassword(passwordValue);
		adminpage.selectusertype(userTypevalue);
		adminpage.clicksavebutton();
		Assert.assertEquals(actual,Messages.USER_CREATION_ERROR);




	}
	@Test(description = "Verify search user")
	public void verifysearch() throws IOException{
		String usernameValue=ExcelUtility.getStringData(1, 0,Constants.LOGINSHEET );
		String passwordValue=ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterusername(usernameValue);
		loginpage.enterpassword(passwordValue);
		loginpage.signin();
		String expected="https://groceryapp.uniqassosiates.com/admin";
		String actual=driver.getCurrentUrl();
		Assert.assertEquals(actual,Messages.VALID_CREDENTIALS_ERROR);

		FakerUtility fakerUtility = new FakerUtility();
		String name=fakerUtility.createRandomUserName();
		String password=fakerUtility.createRandomPassword();
		String userTypevalue=ExcelUtility.getStringData(1, 2, Constants.ADMINSHEET);
		AdminPage adminpage=new AdminPage(driver);
		adminpage.clickadmintile();
		adminpage.clicksearchbutton();
		adminpage.entersearchusername(name);
		adminpage.selectsearchusertype(userTypevalue);
		adminpage.clicksearchfield();
		Assert.assertEquals(actual,Messages.USER_SEARCH_ERROR);

	}
	@Test(description = "Verify home page")
	public void verifyhomepage() throws IOException{
		String usernameValue=ExcelUtility.getStringData(1, 0,Constants.LOGINSHEET );
		String passwordValue=ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);	
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterusername(usernameValue);
		loginpage.enterpassword(passwordValue);
		loginpage.signin();
		String expected="https://groceryapp.uniqassosiates.com/admin";
		String actual=driver.getCurrentUrl();
		Assert.assertEquals(actual, Messages.VALID_CREDENTIALS_ERROR);

		AdminPage adminpage = new AdminPage(driver);
		adminpage.clicknewstile();
		adminpage.clickhome();
		Assert.assertEquals(actual, Messages.HOMEPAGE_VERIFICATION_ERROR);
	}



}
