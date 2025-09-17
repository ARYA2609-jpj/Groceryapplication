package testscript;

import java.io.IOException;
import java.time.Duration;

import org.apache.commons.math3.analysis.function.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
		loginpage.enterusername(usernameValue).enteroassword(passwordValue);
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
		loginpage.enterusername(usernameValue).enteroassword(passwordValue);
		homepage=loginpage.signin();
		
		newspage=homepage.clicknewstile();

		//WebElement newsclick=driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-danger' and @href='https://groceryapp.uniqassosiates.com/admin/news/add']"));
		//newsclick.click();
		//WebElement enternews=driver.findElement(By.xpath("//textarea[@placeholder='Enter the news']"));
		//enternews.sendKeys("This is a sample news");
		//WebElement savenews=driver.findElement(By.xpath("//button[@name='create']"));
		//savenews.click();
		//WebElement searchButton = driver.findElement(By.xpath("//button[@class='btn btn-danger btn-fix']"));
		//searchButton.click();
		newspage.clickresetbutton();
		String expectedUrl = "https://groceryapp.uniqassosiates.com/admin/list-news";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, Messages.NEWS_RESET_ERROR);


	}

}
