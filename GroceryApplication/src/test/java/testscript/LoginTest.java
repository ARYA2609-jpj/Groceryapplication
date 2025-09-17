package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestNgBase;
import constant.Constants;
import constant.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends TestNgBase {
	HomePage home;
	@Test(priority =1,description = "verify login with valid credentials",retryAnalyzer = retry.Retry.class,groups = {"smoke"})
	public void verifyloginwithvalidcredentials() throws IOException {
		String usernameValue=ExcelUtility.getStringData(1,0, Constants.LOGINSHEET );
		String passwordValue=ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);

		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterusername(usernameValue).enterpassword(passwordValue);
		home=loginpage.signin();
		
		String expected="https://groceryapp.uniqassosiates.com/admin";
		String actual=driver.getCurrentUrl();
		Assert.assertEquals(actual, expected,Messages.VALID_CREDENTIALS_ERROR);
	}



	@Test(priority = 2,description ="Verify login with valid username and invalid password")
	public void verifyloginwithvalidusernameandinvalidpassword() throws IOException {
		String username=ExcelUtility.getStringData(2, 0, Constants.LOGINSHEET);
		String password=ExcelUtility.getStringData(2, 1, Constants.LOGINSHEET);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterusername(username).enterpassword(password).signin(); 
		String expected="https://groceryapp.uniqassosiates.com/admin/login";
		String actual=driver.getCurrentUrl();
		Assert.assertEquals(actual, expected,Messages.INVALID_PASSWORD_ERROR);

	}
	@Test(priority = 3, description ="verify login with invalid username and valid password")
	public void verifyloginwithinvalidusernameandvalidpassword() throws IOException {
		String username=ExcelUtility.getStringData(3, 0, Constants.LOGINSHEET);
		String password=ExcelUtility.getStringData(3, 1, Constants.LOGINSHEET);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterusername(username).enterpassword(password).signin(); 
		
		String expected="https://groceryapp.uniqassosiates.com/admin/login";
		String actual=driver.getCurrentUrl();
		Assert.assertEquals(actual, expected,Messages.INVALID_USERNAME_ERROR);

	}
	@Test(priority = 4, description = "verify login with invalid crededentials",dataProvider = "loginProvider")
	public void verifyloginwithinvalidcredentials(String usernameValue,String passwordValue) throws IOException {
		//String username=ExcelUtility.getStringData(4, 0, Constants.LOGINSHEET);
		//String password=ExcelUtility.getStringData(4, 1, Constants.LOGINSHEET);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterusername(usernameValue).enterpassword(passwordValue).signin(); 
		String expected="https://groceryapp.uniqassosiates.com/admin/login";
		String actual=driver.getCurrentUrl();
		Assert.assertEquals(actual, expected,Messages.INVALID_CREDENTIALS_ERROR);


	}
	@DataProvider(name="loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException
	{
		return new Object[][] { new Object[] {"user","password"},
			new Object[] {"username","pass"}
			
		};
	}

}
