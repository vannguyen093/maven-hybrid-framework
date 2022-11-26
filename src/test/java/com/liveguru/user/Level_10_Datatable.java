package com.liveguru.user;

import commons.BaseTest;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.liveGuru.admin.AdminHomePageObject;
import pageObjects.liveGuru.admin.AdminLoginPageObject;
import pageObjects.liveGuru.user.*;

public class Level_10_Datatable extends BaseTest {
    WebDriver driver;
    UserHomePageObject homePage;
    UserLoginPageObject loginPage;
    RegisterPageObject registerPage;
    UserMyDashboardPageObject myAccountDashboardPage;
    UserAccountInforPageObject accountInforPage;
    AdminLoginPageObject adminLoginPage;
    AdminHomePageObject adminHomePage;
    String firstName, lastName, fullName, email, password, adminUserName, adminPassword;


    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {

        driver = getBrowserDriver(browserName, appUrl);

        homePage = PageGeneratorManager.getHomePage(driver);

        firstName = "Van";
        lastName = "Nguyen";
        email = "vannguyen" + generateFakeNumber() + "@gmail.com";
        password = "123123";
        adminUserName = "user01";
        adminPassword = "guru99com";
        fullName = firstName + " " + lastName;
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

    }

    @Test
    public void User_03_Switch_To_Admin_Role() {
        accountInforPage.openPageUrl(driver, GlobalConstants.ADMIN_LIVE_GURU_URL);
        adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

        adminHomePage = adminLoginPage.loginAsAdmin(adminUserName, adminPassword);
        adminHomePage.closeAdminPopup();
        Assert.assertTrue(adminHomePage.isHomePageTitleDisplayed());
    }

    @Test
    public void User_04_Homepage_Paging() {
        adminHomePage.clicktoPagingButtonByButtonName("Next page");
        Assert.assertEquals(adminHomePage.getValuePagingTextbox(), "2");
        adminHomePage.clicktoPagingButtonByButtonName("Previous page");
        Assert.assertEquals(adminHomePage.getValuePagingTextbox(), "1");
    }

    @Test
    public void User_04_Verify_Account_Registerd_Displayed_At_Admin_Table_Data() {
        adminHomePage.enterToFilterTextboxByColumnName("email", email);
        Assert.assertTrue(adminHomePage.isAccountRegisteredDisplayed(fullName, email));
    }

    @Test
    public void User_05_Select_Customer_By_Checkbox() {
        adminHomePage.checkToCheckboxByCustomerEmail(email);
        Assert.assertEquals(adminHomePage.getNumberItemsSelected(), "1");
        adminHomePage.uncheckToCheckBoxByCustomerName(email);
        Assert.assertEquals(adminHomePage.getNumberItemsSelected(), "0");
        adminHomePage.checkToCheckboxByCustomerEmail(email);
        adminHomePage.selectActionsAtActionDropdownByActionName("Delete");
        Assert.assertTrue(adminHomePage.isDeleteSuccessDisplayed());

        adminHomePage.selectOrUnselectByLinkName("Select All");
        //        Assert.assertEquals(adminHomePage.getNumberItemsSelected(),"14014");
        adminHomePage.selectOrUnselectByLinkName("Unselect All");
        //        Assert.assertEquals(adminHomePage.getNumberItemsSelected(),"0");

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
