package com.nopcommerce.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Level_03_Page_Object_01_Register extends BasePage {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String firstName, lastName, emailAddress, password;
    UserHomePageObject homePage;
    UserRegisterPageObject registerPage;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        driver = new FirefoxDriver();

        homePage = new UserHomePageObject(driver);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");

        firstName = "Automation";
        lastName = "FC";
        password = "123456";
        emailAddress = "vannguyen" + generateFakeNumber() + "@gmail.com";
    }

    @Test
    public void Register_01_Empty_Data() {
        System.out.println("Register 01 - Step 01: Click to register link");
        homePage.clickToRegisterLink();

        registerPage = new UserRegisterPageObject(driver);

        System.out.println("Register 01 - Step 02: Click to register button");
        registerPage.clickToRegisterButton();

        System.out.println("Register 01 - Step 03: Verify error messages");
        Assert.assertEquals(registerPage.getErrorAtFirstNameTextbox(), "First name is required.");
        Assert.assertEquals(registerPage.getErrorAtLastNameTextbox(), "Last name is required.");
        Assert.assertEquals(registerPage.getErrorAtEmailTextbox(), "Email is required.");
        Assert.assertEquals(registerPage.getErrorAtPasswordTextbox(), "Password is required.");
        Assert.assertEquals(registerPage.getErrorAtConfirmPasswordTextbox(), "Password is required.");
    }

    @Test
    public void Register_02_Invalid_Email() {
        System.out.println("Register 02 - Step 01: Click to register link");
        homePage.clickToRegisterLink();

        registerPage = new UserRegisterPageObject(driver);

        System.out.println("Register 02 - Step 02: Input invalid email address");
        registerPage.inputToFirstNameTextbox(firstName);
        registerPage.inputToLastNameTextbox(lastName);
        registerPage.inputToEmailTextbox("123@4645@456");
        registerPage.inputToPasswordTextbox(password);
        registerPage.inputToConfirmPasswordTextbox(password);

        System.out.println("Register 02 - Step 03: Click to register button");
        registerPage.clickToRegisterButton();

        System.out.println("Register 01 - Step 03: Verify error message");
        Assert.assertEquals(registerPage.getErrorAtEmailTextbox(), "Wrong email");
    }

    @Test
    public void Register_03_Register_Success() {
        System.out.println("Register 03 - Step 01: Click to register link");
        homePage.clickToRegisterLink();

        registerPage = new UserRegisterPageObject(driver);

        System.out.println("Register 03 - Step 02: Input valid data into required fields");
        registerPage.inputToFirstNameTextbox(firstName);
        registerPage.inputToLastNameTextbox(lastName);
        registerPage.inputToEmailTextbox(emailAddress);
        registerPage.inputToPasswordTextbox(password);
        registerPage.inputToConfirmPasswordTextbox(password);

        System.out.println("Register 03 - Step 03: Click to register button");
        registerPage.clickToRegisterButton();

        System.out.println("Register 03 - Step 03: Verify success message");
        Assert.assertEquals(registerPage.getSuccessMessage(), "Your registration completed");
        System.out.println("Register 03 - Step 04: Click to logout link");
        registerPage.clickToLogOutLink();
    }

    @Test
    public void Register_04_Existing_Email() {
        System.out.println("Register 04 - Step 01: Click to register link");
        homePage.clickToRegisterLink();

        registerPage = new UserRegisterPageObject(driver);

        System.out.println("Register 04 - Step 02: Input existing email address");
        registerPage.inputToFirstNameTextbox(firstName);
        registerPage.inputToLastNameTextbox(lastName);
        registerPage.inputToEmailTextbox(emailAddress);
        registerPage.inputToPasswordTextbox(password);
        registerPage.inputToConfirmPasswordTextbox(password);

        System.out.println("Register 04 - Step 03: Click to register button");
        registerPage.clickToRegisterButton();

        System.out.println("Register 04 - Step 04: Verify error message");
        Assert.assertEquals(registerPage.getErrorAtExistingEmail(), "The specified email already exists");
    }

    @Test
    public void Register_05_Password_Less_Than_6_Chars() {
        System.out.println("Register 05 - Step 01: Click to register link");
        homePage.clickToRegisterLink();

        registerPage = new UserRegisterPageObject(driver);

        System.out.println("Register 05 - Step 02: Input password with less than 6 chars");
        registerPage.inputToFirstNameTextbox(firstName);
        registerPage.inputToLastNameTextbox(lastName);
        registerPage.inputToEmailTextbox(emailAddress);
        registerPage.inputToPasswordTextbox("123");
        registerPage.inputToConfirmPasswordTextbox("123");

        System.out.println("Register 05 - Step 03: Click to register button");
        registerPage.clickToRegisterButton();

        System.out.println("Register 05 - Step 04: Verify error message");
        Assert.assertEquals(registerPage.getErrorAtPasswordTextbox(), "Password must meet the following rules:\nmust have at least 6 characters");
    }

    @Test
    public void Register_06_Invalid_Confirm_Password() {
        System.out.println("Register 06 - Step 01: Click to register link");
        homePage.clickToRegisterLink();

        registerPage = new UserRegisterPageObject(driver);

        System.out.println("Register 06 - Step 02: Input invalid confirm password");
        registerPage.inputToFirstNameTextbox(firstName);
        registerPage.inputToLastNameTextbox(lastName);
        registerPage.inputToEmailTextbox(emailAddress);
        registerPage.inputToPasswordTextbox(password);
        registerPage.inputToConfirmPasswordTextbox(firstName);

        System.out.println("Register 06 - Step 03: Click to register button");
        registerPage.clickToRegisterButton();

        System.out.println("Register 06 - Step 04: Verify error message");
        Assert.assertEquals(registerPage.getErrorAtConfirmPasswordTextbox(), "The password and confirmation password do not match.");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public int generateFakeNumber() {
        Random random = new Random();
        return random.nextInt(99999);
    }
}
