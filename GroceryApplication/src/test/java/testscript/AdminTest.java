package testscript;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestNgBase;
import constant.Constants;
import constant.Messages;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminTest extends TestNgBase {
	HomePage homepage;
	AdminPage adminpage;
	@Test(description = "Verify add user")
	public void verifyadduser() throws IOException {
        String usernameValue = ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);
        String passwordValue = ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);
        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterusername(usernameValue).enteroassword(passwordValue);
		homepage=loginpage.signin();
        

        FakerUtility fakerUtility = new FakerUtility();
        String newUser = fakerUtility.createRandomUserName();
        String newPassword = fakerUtility.createRandomPassword();
        String userTypevalue = ExcelUtility.getStringData(1, 2, Constants.ADMINSHEET);

        adminpage=homepage.clickadmintile();
        homepage.clickadmintile();
        adminpage.clicknewbutton().enterusername(usernameValue).enterpassword(newPassword).selectusertype(userTypevalue).clicksavebutton();
        

        Assert.assertTrue(adminpage.isAlertDisplayed(),Messages.USER_CREATION_ERROR);
    }

    @Test(description = "Verify search user")
    public void verifysearch() throws IOException {
        String usernameValue = ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);
        String passwordValue = ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);
        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterusername(usernameValue).enteroassword(passwordValue);
		homepage=loginpage.signin();

        FakerUtility fakerUtility = new FakerUtility();
        String newUser = fakerUtility.createRandomUserName();
        String newPassword = fakerUtility.createRandomPassword();
        String userTypevalue = ExcelUtility.getStringData(1, 2, Constants.ADMINSHEET);

        
        adminpage=homepage.clickadmintile();

        
        adminpage.adminclicksearchfield().entersearchusername(usernameValue).enterpassword(newPassword).selectusertype(userTypevalue).clicksavebutton();
        adminpage.enterusername(newUser);
        adminpage.enterpassword(newPassword);
        adminpage.selectusertype(userTypevalue);
        adminpage.clicksavebutton();
        Assert.assertTrue(adminpage.isAlertDisplayed(),Messages.USER_SEARCH_ERROR);

        
        
    }

    @Test(description = "Verify home page")     
        public void verifyhomepage() throws IOException {
            String usernameValue = ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);
            String passwordValue = ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);

            LoginPage loginpage = new LoginPage(driver);
            loginpage.enterusername(usernameValue).enteroassword(passwordValue);
    		homepage=loginpage.signin();

            
            adminpage=homepage.clickadmintile();
            adminpage.clickhome();

            Assert.assertTrue(
                driver.getCurrentUrl().contains("home"),Messages.HOMEPAGE_VERIFICATION_ERROR);
        }
    }