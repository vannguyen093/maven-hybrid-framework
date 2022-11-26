package com.liveguru.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.liveGuru.user.*;

public class Live_Guru_User extends BaseTest {
    WebDriver driver;
    UserHomePageObject homePage;
    UserLoginPageObject loginPage;
    RegisterPageObject registerPage;
    UserMyDashboardPageObject myAccountDashboardPage;
    UserAccountInforPageObject accountInforPage;
    UserAddressBookPageObject addressBookPage;
    UserMyOrderPageObject myOrderPage;
    UserBillingAgreementsPageObject billingAgreementsPage;
    String firstName, lastName, email, password;


    @Parameters("browser")
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
        loginPage = homePage.clickToMyAccountLink();

        registerPage = loginPage.clickToCreateAnAccountButton();

        myAccountDashboardPage = registerPage.inputToRequiredRegisterField(firstName, lastName, email, password, password);
        Assert.assertEquals(myAccountDashboardPage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store.");
    }

    @Test
    public void User_02_Verify_Info_After_Register_Successful() {
        myAccountDashboardPage.openPagesAtDashboardByPageName(driver, "Account Information");
        accountInforPage = PageGeneratorManager.getAccountInforPage(driver);

        Assert.assertEquals(accountInforPage.getValueAtFirstNameTextbox(), firstName);
        Assert.assertEquals(accountInforPage.getValueAtLastNameTextbox(), lastName);
        Assert.assertEquals(accountInforPage.getValueAtEmailTextbox(), email);

        accountInforPage.clickToLogOutLinkAtUserLiveGuru(driver);
    }

    @Test
    public void User_03_Login_To_System() {
        loginPage = homePage.clickToMyAccountLink();

        myAccountDashboardPage = loginPage.loginAsUser(email, password);
        Assert.assertEquals(myAccountDashboardPage.getHelloUserText(), "Hello, Van Nguyen!");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}