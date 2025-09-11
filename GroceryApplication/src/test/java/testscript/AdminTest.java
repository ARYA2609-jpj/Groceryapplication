package testscript;

import static org.testng.Assert.assertThrows;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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
		



	}
	@Test(description = "Verify search user")
	public void verifysearch() throws IOException{
		String usernameValue=ExcelUtility.getStringData(1, 0,Constants.LOGINSHEET );
		String passwordValue=ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterusername(usernameValue);
		loginpage.enterpassword(passwordValue);
		loginpage.signin();
		

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
		
	}
	@Test(description = "Verify home page")
	public void verifyhomepage() throws IOException{
		String usernameValue=ExcelUtility.getStringData(1, 0,Constants.LOGINSHEET );
		String passwordValue=ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);	
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterusername(usernameValue);
		loginpage.enterpassword(passwordValue);
		loginpage.signin();
		

		AdminPage adminpage = new AdminPage(driver);
		adminpage.clicknewstile();
		adminpage.clickhome();
		

	}

}
