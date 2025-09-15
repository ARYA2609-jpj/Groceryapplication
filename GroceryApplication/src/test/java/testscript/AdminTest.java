package testscript;
import java.io.IOException;

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
	public void verifyadduser() throws IOException {
        String usernameValue = ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);
        String passwordValue = ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);
        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterusername(usernameValue);
        loginpage.enterpassword(passwordValue);
        loginpage.signin();

        FakerUtility fakerUtility = new FakerUtility();
        String newUser = fakerUtility.createRandomUserName();
        String newPassword = fakerUtility.createRandomPassword();
        String userTypevalue = ExcelUtility.getStringData(1, 2, Constants.ADMINSHEET);

        AdminPage adminpage = new AdminPage(driver);
        adminpage.clickadmintile();
        adminpage.clicknewbutton();
        adminpage.enterusername(newUser);
        adminpage.enterpassword(newPassword);
        adminpage.selectusertype(userTypevalue);
        adminpage.clicksavebutton();

        Assert.assertTrue(adminpage.isAlertDisplayed(),Messages.USER_CREATION_ERROR);
    }

    @Test(description = "Verify search user")
    public void verifysearch() throws IOException {
        String usernameValue = ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);
        String passwordValue = ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);
        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterusername(usernameValue);
        loginpage.enterpassword(passwordValue);
        loginpage.signin();

        FakerUtility fakerUtility = new FakerUtility();
        String newUser = fakerUtility.createRandomUserName();
        String newPassword = fakerUtility.createRandomPassword();
        String userTypevalue = ExcelUtility.getStringData(1, 2, Constants.ADMINSHEET);

        AdminPage adminpage = new AdminPage(driver);
        adminpage.clickadmintile();

        
        adminpage.clicknewbutton();
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
            loginpage.enterusername(usernameValue);
            loginpage.enterpassword(passwordValue);
            loginpage.signin();

            AdminPage adminpage = new AdminPage(driver);
            adminpage.clicknewstile();
            adminpage.clickhome();

            Assert.assertTrue(
                driver.getCurrentUrl().contains("home"),Messages.HOMEPAGE_VERIFICATION_ERROR);
        }
    }