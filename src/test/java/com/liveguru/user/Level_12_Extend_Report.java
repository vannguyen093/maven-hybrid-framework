package com.liveguru.user;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.liveGuru.user.*;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;


public class Level_12_Extend_Report extends BaseTest {
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
    public void User_01_Register_To_System(Method method) {
        ExtentTestManager.startTest(method.getName(), "User_01_Register_To_System");
        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Click to 'My Account Link'");
        loginPage = homePage.clickToMyAccountLink();

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Click to 'Create an Account' Button");
        registerPage = loginPage.clickToCreateAnAccountButton();

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Input '" + firstName + "', '" + lastName + "', '" + email + "', '" + password + "', '" + password + "' to the required fields");
        myAccountDashboardPage = registerPage.inputToRequiredRegisterField(firstName, lastName, email, password, password);

        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Verify Register Success Message is Displayed");
        Assert.assertEquals(myAccountDashboardPage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store..");
    }

    @Test
    public void User_02_Verify_Info_After_Register_Successful(Method method) {
        ExtentTestManager.startTest(method.getName(), "User_02_Verify_Info_After_Register_Successful");
        ExtentTestManager.getTest().log(Status.INFO, "Verify Info After Register - Step 01: Navigate to Dashboard Page");
        myAccountDashboardPage.openPagesAtDashboardByPageName(driver, "Account Information");
        accountInforPage = PageGeneratorManager.getAccountInforPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Verify Info After Register - Step 02: Verify Info At First Name Textbox " + "'" + firstName + "'");
        Assert.assertEquals(accountInforPage.getValueAtFirstNameTextbox(), firstName);

        ExtentTestManager.getTest().log(Status.INFO, "Verify Info After Register - Step 03: Verify Info At Last Name Textbox " + "'" + lastName + "'");
        Assert.assertEquals(accountInforPage.getValueAtLastNameTextbox(), lastName);

        ExtentTestManager.getTest().log(Status.INFO, "Verify Info After Register - Step 04: Verify Info At Email Textbox " + "'" + email + "'");
        Assert.assertEquals(accountInforPage.getValueAtEmailTextbox(), email);

        ExtentTestManager.getTest().log(Status.INFO, "Verify Info After Register - Step 05: Click to 'Log out' Link");
        accountInforPage.clickToLogOutLinkAtUserLiveGuru(driver);
    }

    @Test
    public void User_03_Login_To_System(Method method) {
        ExtentTestManager.startTest(method.getName(), "User_03_Login_To_System");
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Click to 'My Account' Link");
        loginPage = homePage.clickToMyAccountLink();

        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Input '" + email + "', '" + password + "' to Email and Password textbox");
        myAccountDashboardPage = loginPage.loginAsUser(email, password);

        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Verify the title of Dashboard Page");
        Assert.assertEquals(myAccountDashboardPage.getHelloUserText(), "Hello, Van Nguyen!");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}