package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.user.*;

public class Level_09_Dynamic_Locator extends BaseTest {
    private WebDriver driver;
    private String firstName, lastName, email, password;
    private UserHomePageObject homePage;
    private UserRegisterPageObject registerPage;
    private UserLoginPageObject loginPage;
    private UserCustomerInfoPageObject customerInfoPage;
    private UserAddressesPageObject addressesPage;
    private UserOrdersPageObject ordersPage;


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {

        driver = getBrowserDriver(browserName,appUrl);

        homePage = PageGeneratorManager.getUserHomePage(driver);

        firstName = "Automation";
        lastName = "FC";
        password = "123456";
        email = "vannguyen" + generateFakeNumber() + "@gmail.com";
    }

    @Test
    public void User_01_Register_Login() {
        registerPage = homePage.clickToRegisterLink();

        registerPage.inputToFirstNameTextbox(firstName);
        registerPage.inputToLastNameTextbox(lastName);
        registerPage.inputToEmailTextbox(email);
        registerPage.inputToPasswordTextbox(password);
        registerPage.inputToConfirmPasswordTextbox(password);

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getSuccessMessage(), "Your registration completed");
        homePage = registerPage.clickToLogOutLink();

        loginPage = homePage.clickToLoginLink();

        loginPage.inputToEmailTextbox(email);
        loginPage.inputToPasswordTextbox(password);
        homePage = loginPage.clickToLoginButton();
        customerInfoPage = homePage.clickToMyAccountLink();
    }

    @Test
    public void User_02_Switch_Page() {
//        addressesPage = customerInfoPage.openAddressesPage(driver);
//        ordersPage = addressesPage.openOrdersPage(driver);
//        customerInfoPage = ordersPage.openCustomerInfoPage(driver);
    }

    @Test
    public void User_03_Dynamic_Page_01() {
        addressesPage = (UserAddressesPageObject) customerInfoPage.openPageAtMyAccountByName(driver, "Addresses");
        ordersPage = (UserOrdersPageObject) addressesPage.openPageAtMyAccountByName(driver, "Orders");
        customerInfoPage = (UserCustomerInfoPageObject) ordersPage.openPageAtMyAccountByName(driver, "Customer info");
    }

    @Test
    public void User_04_Dynamic_Page_02() {
        customerInfoPage.openPagesAtMyAccountByPageName(driver, "Addresses");
        addressesPage = PageGeneratorManager.getUserAddressesPage(driver);

        addressesPage.openPagesAtMyAccountByPageName(driver, "Orders");
        ordersPage = PageGeneratorManager.getUserOrdersPage(driver);

        ordersPage.openPagesAtMyAccountByPageName(driver, "Customer info");
        customerInfoPage = PageGeneratorManager.getUserCustomerInfoPage(driver);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
