package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constants;
import utilities.ScreenshotUtility;

public class TestNgBase {
	Properties prop;
	FileInputStream f;
	public WebDriver driver;
	
	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void intialzeBrowser(String browser) throws Exception {
		prop = new Properties();
		f= new FileInputStream(Constants.CONFIGFILE);
		prop.load(f);
		//driver=new FirefoxDriver();
		//driver=new ChromeDriver();
		if(browser.equalsIgnoreCase("Chrome")) {
			//driver=new ChromeDriver();
			ChromeOptions options = new ChromeOptions();
			Map<String,Object> prefs=new HashMap<>();
			prefs.put("profile.password_manager_leak_detection", false);
			options.setExperimentalOption("prefs", prefs);
			driver=new ChromeDriver(options);
		}
		else if(browser.equalsIgnoreCase("Firefox")) {
			driver=new FirefoxDriver();
		}
else {
			throw new Exception("Invalid browser name");
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//driver.manage().window().minimize();
		
	}
	@AfterMethod
	public void closebrowser() {
		//driver.close();
		//driver.quit();
	}
	@AfterMethod(alwaysRun = true)
	public void driverQuit(ITestResult iTestResult) throws IOException{
		if(iTestResult.getStatus()==ITestResult.FAILURE) {
			ScreenshotUtility screenshort=new ScreenshotUtility();
			screenshort.getScreenshot(driver,iTestResult.getName());
		}
		driver.quit();
	}
	
	

}
 
    

