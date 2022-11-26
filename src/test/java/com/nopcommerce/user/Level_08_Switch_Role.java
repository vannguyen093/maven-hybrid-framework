package com.nopcommerce.user;

import commons.BaseTest;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.*;

public class Level_08_Switch_Role extends BaseTest {
    private WebDriver driver;
    private String userEmail, userPassword, adminEmail, adminPassword;
    private UserHomePageObject userHomePage;
    private UserLoginPageObject userLoginPage;
    private UserCustomerInfoPageObject userCustomerInfoPage;
    private AdminLoginPageObject adminLoginPage;
    private AdminDashboardPageObject adminDashboardPage;


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {

        driver = getBrowserDriver(browserName,appUrl);

        userHomePage = PageGeneratorManager.getUserHomePage(driver);

        userEmail = "vannguyen321@gmail.com";
        userPassword = "123123";
        adminEmail = "admin@yourstore.com";
        adminPassword = "admin";
    }

    @Test
    public void Role_01_User_To_Admin() {
        userLoginPage = userHomePage.clickToLoginLink();

        userHomePage = userLoginPage.loginAsUser(userEmail, userPassword);
        Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());

        userCustomerInfoPage = userHomePage.clickToMyAccountLink();
        userHomePage = userCustomerInfoPage.clickToLogoutLinkAtUser(driver);

        userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);
        adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

    }

    @Test
    public void Role_02_Admin_To_User() {
        adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmail, adminPassword);
        Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplayed());
        adminLoginPage = adminDashboardPage.clickToLogoutLinkAtAdmin(driver);

        adminLoginPage.openPageUrl(driver, GlobalConstants.USER_PAGE_URL);
        userHomePage = PageGeneratorManager.getUserHomePage(driver);
        userLoginPage = userHomePage.clickToLoginLink();
        userLoginPage.loginAsUser(userEmail, userPassword);
        Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
