package com.liveguru.user;

import com.liveguru.common.Common_01_Register_Cookie;
import com.liveguru.common.Common_01_Register_End_User;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.liveGuru.user.*;



public class Level_13_Share_Data extends BaseTest {
    WebDriver driver;
    UserHomePageObject homePage;
    UserLoginPageObject loginPage;
    UserMyDashboardPageObject myAccountDashboardPage;
    String email, password;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {

        driver = getBrowserDriver(browserName,appUrl);

        homePage = PageGeneratorManager.getHomePage(driver);
        email = Common_01_Register_End_User.email;
        password = Common_01_Register_End_User.password;
        log.info("Login - Step 01: Click to 'My Account' Link");
        loginPage = homePage.clickToMyAccountLink();

        log.info("Login - Step 02: Input '" + email + "', '" + password + "' to Email and Password textbox");
        loginPage.setCookies(driver, Common_01_Register_Cookie.loggedCookie);
        loginPage.refreshCurrentPage(driver);
        myAccountDashboardPage = PageGeneratorManager.getMyAccountDashboardPage(driver);

        log.info("Login - Step 03: Verify the title of Dashboard Page");
        verifyEquals(myAccountDashboardPage.getHelloUserText(), "Hello, Van Nguyen!");
    }


    @Test
    public void User_01_Login_To_System() {

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}