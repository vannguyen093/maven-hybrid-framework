package com.nopcommerce.user;

import commons.BaseTest;
import data.UserDataMapper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_18_Manage_Data_Json extends BaseTest {
    private WebDriver driver;
    private String email;
    private UserHomePageObject homePage;
    private UserRegisterPageObject registerPage;
    private UserLoginPageObject loginPage;
    private UserCustomerInfoPageObject customerInfoPage;
    private UserDataMapper userData;


    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {

        driver = getBrowserDriver(browserName, appUrl);

        homePage = PageGeneratorManager.getUserHomePage(driver);
        userData = UserDataMapper.getUserData();

        email = userData.getEmail() + generateFakeNumber() + "@gmail.com";
    }

    @Test
    public void User_01_Register_Login() {
        log.info("Register - Step 01: Click to 'Register' link");
        registerPage = homePage.clickToRegisterLink();

        log.info("Register - Step 02: Click to 'Radio' button with value 'Male'");
        registerPage.clickToRadioButtonByLabelText(driver, "Male");

        log.info("Register - Step 03: Enter to First Name textbox with value is " + userData.getFirstName());
        registerPage.inputToTextboxByID(driver, "FirstName", userData.getFirstName());

        log.info("Register - Step 04: Enter to Last Name textbox with value is " + userData.getLastName());
        registerPage.inputToTextboxByID(driver, "LastName", userData.getLastName());

        log.info("Register - Step 05: Select date in Day dropdown with value is " + userData.getDate());
        registerPage.selectToDropdownByName(driver, "DateOfBirthDay", userData.getDate());

        log.info("Register - Step 06: Select month in Month dropdown with value is " + userData.getMonth());
        registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", userData.getMonth());

        log.info("Register - Step 07: Select year in Year dropdown with value is " + userData.getYear());
        registerPage.selectToDropdownByName(driver, "DateOfBirthYear", userData.getYear());

        log.info("Register - Step 08: Enter to Email textbox with value is " + email);
        registerPage.inputToTextboxByID(driver, "Email", email);

        log.info("Register - Step 09: Enter to Password textbox with value is " + userData.getPassword());
        registerPage.inputToTextboxByID(driver, "Password", userData.getPassword());

        log.info("Register - Step 10: Enter to Confirm Password textbox with value is " + userData.getPassword());
        registerPage.inputToTextboxByID(driver, "ConfirmPassword", userData.getPassword());

        log.info("Register - Step 11: Click to 'News letter' checkbox");
        registerPage.clickToCheckboxByLabelText(driver, "Newsletter");

        log.info("Register - Step 12: Click to 'Register' button");
        registerPage.clickToButtonByText(driver, "Register");

        log.info("Register - Step 13: Verify the 'Success Message' is displayed");
        verifyEquals(registerPage.getSuccessMessage(), "Your registration completed");

        log.info("Register - Step 14: Click to 'Log out' link");
        homePage = registerPage.clickToLogOutLink();
    }

    @Test
    public void User_02_Login() {
        log.info("Login - Step 01: Click to 'Login' link");
        loginPage = homePage.clickToLoginLink();

        log.info("Login - Step 02: Enter to Email textbox with value is " + email);
        loginPage.inputToTextboxByID(driver, "Email", email);

        log.info("Login - Step 03: Enter to Password textbox with value is " + userData.getPassword());
        loginPage.inputToTextboxByID(driver, "Password", userData.getPassword());

        log.info("Login - Step 04: Click to 'Login' button");
        registerPage.clickToButtonByText(driver, "Log in");
        homePage = PageGeneratorManager.getUserHomePage(driver);
    }

    @Test
    public void User_03_My_Account() {
        log.info("My Account - Step 01: Click to 'My Account' link");
        customerInfoPage = homePage.clickToMyAccountLink();

        log.info("My Account - Step 02: Verify 'Customer Info' page is displayed");
        verifyTrue(customerInfoPage.isMyAccountTitleDisplayed("My account - Customer info"));

        log.info("My Account - Step 03: Verify 'First Name' value is correctly");
        verifyEquals(customerInfoPage.getTextboxValueById(driver,"FirstName"), userData.getFirstName());

        log.info("My Account - Step 03: Verify 'Last Name' value is correctly");
        verifyEquals(customerInfoPage.getTextboxValueById(driver,"LastName"), userData.getLastName());

        log.info("My Account - Step 03: Verify 'Email' value is correctly");
        verifyEquals(customerInfoPage.getTextboxValueById(driver,"Email"), email);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver();
    }
}
