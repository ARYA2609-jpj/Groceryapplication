package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNgBase;
import constant.Constants;
import constant.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.NewsPage;
import utilities.ExcelUtility;

public class NewsTest extends TestNgBase {
	HomePage homepage;
	NewsPage newspage;
	@Test(description = "Verify add news")
	public void verifyaddnews()throws IOException {
		String usernameValue=ExcelUtility.getStringData(6, 0,Constants.LOGINSHEET );
		String passwordValue=ExcelUtility.getStringData(6, 1, Constants.LOGINSHEET);
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterusername(usernameValue).enterpassword(passwordValue);
		homepage=loginpage.signin();
		
		
		
		newspage=homepage.clicknewstile();
		newspage.clickaddnewsbutton().enternews("This is a sample news").clicksavebutton();
		
		boolean isAlertDisplayed = newspage.isnewsadded();
		Assert.assertTrue(isAlertDisplayed, Messages.NEWS_CREATION_ERROR);


	}





	@Test(description = "Verify reset news")
	public void verifyresetnews ()throws IOException{
		String usernameValue=ExcelUtility.getStringData(6, 0,Constants.LOGINSHEET );
		String passwordValue=ExcelUtility.getStringData(6, 1, Constants.LOGINSHEET);	
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterusername(usernameValue).enterpassword(passwordValue);
		homepage=loginpage.signin();
		
		newspage=homepage.clicknewstile();

		
		newspage.clickresetbutton();
		String expectedUrl = "https://groceryapp.uniqassosiates.com/admin/list-news";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, Messages.NEWS_RESET_ERROR);


	}

}
