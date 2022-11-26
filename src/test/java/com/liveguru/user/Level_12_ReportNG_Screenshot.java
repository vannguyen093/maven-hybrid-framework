package com.liveguru.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.liveGuru.user.*;


public class Level_12_ReportNG_Screenshot extends BaseTest {
    WebDriver driver;
    UserHomePageObject homePage;
    UserLoginPageObject loginPage;
    RegisterPageObject registerPage;
    UserMyDashboardPageObject myAccountDashboardPage;
    UserAccountInforPageObject accountInforPage;
    String firstName, lastName, email, password;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {

        driver = getBrowserDriver(browserName,appUrl);

        homePage = PageGeneratorManager.getHomePage(driver);

        firstName = "Van";
        lastName = "Nguyen";
        email = "vannguyen" + generateFakeNumber() + "@gmail.com";
        password = "123123";
    }

    @Test
    public void User_01_Register_To_System() {
        log.info("Register - Step 01: Click to 'My Account Link'");
        loginPage = homePage.clickToMyAccountLink();

        log.info("Register - Step 02: Click to 'Create an Account' Button");
        registerPage = loginPage.clickToCreateAnAccountButton();

        log.info("Register - Step 03: Input '" + firstName + "', '" + lastName + "', '" + email + "', '" + password + "', '" + password + "' to the required fields");
        myAccountDashboardPage = registerPage.inputToRequiredRegisterField(firstName, lastName, email, password, password);

        log.info("Register - Step 04: Verify Register Success Message is Displayed");
        verifyEquals(myAccountDashboardPage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store..");
    }

    @Test
    public void User_02_Verify_Info_After_Register_Successful() {
        log.info("Verify Info After Register - Step 01: Navigate to Dashboard Page");
        myAccountDashboardPage.openPagesAtDashboardByPageName(driver, "Account Information");
        accountInforPage = PageGeneratorManager.getAccountInforPage(driver);

        log.info("Verify Info After Register - Step 02: Verify Info At First Name Textbox " + "'" + firstName + "'");
        verifyEquals(accountInforPage.getValueAtFirstNameTextbox(), firstName);

        log.info("Verify Info After Register - Step 03: Verify Info At Last Name Textbox " + "'" + lastName + "'");
        verifyEquals(accountInforPage.getValueAtLastNameTextbox(), lastName);

        log.info("Verify Info After Register - Step 04: Verify Info At Email Textbox " + "'" + email + "'");
        verifyEquals(accountInforPage.getValueAtEmailTextbox(), email);

        log.info("Verify Info After Register - Step 05: Click to 'Log out' Link");
        accountInforPage.clickToLogOutLinkAtUserLiveGuru(driver);
    }

    @Test
    public void User_03_Login_To_System() {
        log.info("Login - Step 01: Click to 'My Account' Link");
        loginPage = homePage.clickToMyAccountLink();

        log.info("Login - Step 02: Input '" + email + "', '" + password + "' to Email and Password textbox");
        myAccountDashboardPage = loginPage.loginAsUser(email, password);

        log.info("Login - Step 03: Verify the title of Dashboard Page");
        verifyEquals(myAccountDashboardPage.getHelloUserText(), "Hello, Van Nguyen!");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}