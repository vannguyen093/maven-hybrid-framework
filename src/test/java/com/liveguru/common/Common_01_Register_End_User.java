package com.liveguru.common;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.liveGuru.user.*;
public class Common_01_Register_End_User extends BaseTest {
    WebDriver driver;
    UserHomePageObject homePage;
    UserLoginPageObject loginPage;
    RegisterPageObject registerPage;
    UserMyDashboardPageObject myAccountDashboardPage;
    private String firstName, lastName;
    public static String email, password;


    @Parameters({"browser", "url"})
    @BeforeTest(description = "Create new common User for all Classes Test")
    public void Register(String browserName, String appUrl) {
        driver = getBrowserDriver(browserName,appUrl);
        homePage = PageGeneratorManager.getHomePage(driver);

        firstName = "Van";
        lastName = "Nguyen";
        email = "vannguyen" + generateFakeNumber() + "@gmail.com";
        password = "123123";

        log.info("Pre-Condition - Step 01: Click to 'My Account Link'");
        loginPage = homePage.clickToMyAccountLink();

        log.info("Pre-Condition - Step 02: Click to 'Create an Account' Button");
        registerPage = loginPage.clickToCreateAnAccountButton();

        log.info("Pre-Condition - Step 03: Input '" + firstName + "', '" + lastName + "', '" + email + "', '" + password + "', '" + password + "' to the required fields");
        myAccountDashboardPage = registerPage.inputToRequiredRegisterField(firstName, lastName, email, password, password);

        log.info("Pre-Condition - Step 04: Verify Register Success Message is Displayed");
        verifyEquals(myAccountDashboardPage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store.");
    }


    @AfterTest
    public void afterClass() {
        driver.quit();
    }
}
