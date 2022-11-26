package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

import java.util.Random;

public class Level_04_Multiple_Browser extends BaseTest{
  private WebDriver driver;
  private String firstName, lastName,notFoundEmail, existingEmail, password;
  private UserHomePageObject homePage;
  private UserRegisterPageObject registerPage;
  private UserLoginPageObject loginPage;


    @Parameters("browser")
  @BeforeClass
  public void beforeClass(String browserName, String appUrl) {

    driver = getBrowserDriver(browserName,appUrl);

    homePage = new UserHomePageObject(driver);

    firstName = "Automation";
    lastName = "FC";
    password = "123456";
    existingEmail = "vannguyen" + generateFakeNumber() + "@gmail.com";
    notFoundEmail = "vannguyen" + generateFakeNumber() + "@gmail.vn";

    System.out.println("Pre-Condition - Step 01: Click to register link");
    homePage.clickToRegisterLink();

    registerPage = new UserRegisterPageObject(driver);

    System.out.println("Pre-Condition - Step 02: Input valid data into required fields");
    registerPage.inputToFirstNameTextbox(firstName);
    registerPage.inputToLastNameTextbox(lastName);
    registerPage.inputToEmailTextbox(existingEmail);
    registerPage.inputToPasswordTextbox(password);
    registerPage.inputToConfirmPasswordTextbox(password);

    System.out.println("Pre-Condition - Step 03: Click to register button");
    registerPage.clickToRegisterButton();

    System.out.println("Pre-Condition - Step 03: Verify success message");
    Assert.assertEquals(registerPage.getSuccessMessage(), "Your registration completed");
    System.out.println("Pre-Condition - Step 04: Click to logout link");
    registerPage.clickToLogOutLink();

    homePage = new UserHomePageObject(driver);
  }
  
  @Test
  public void Login_01_Empty_Data() {
    System.out.println("Login 01 - Step 01: Click to login link");
    homePage.clickToLoginLink();

    loginPage = new UserLoginPageObject(driver);

    System.out.println("Login 01 - Step 02: Click to login button");
    loginPage.clickToLoginButton();

    System.out.println("Login 01 - Step 03: Verify error message");
    Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
  }

//  @Test
//  public void Login_02_Invalid_Email() {
//    System.out.println("Login 02 - Step 01: Click to login link");
//    homePage.clickToLoginLink();
//
//    loginPage = new LoginPageObject(driver);
//
//    System.out.println("Login 02 - Step 02: Input invalid email");
//    loginPage.inputToEmailTextbox("23423@465#456");
//
//    System.out.println("Login 02 - Step 03: Click to login button");
//    loginPage.clickToLoginButton();
//
//    System.out.println("Login 02 - Step 04: Verify error message");
//    Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
//  }
//
//  @Test
//  public void Login_03_Email_Not_Found() {
//    System.out.println("Login 03 - Step 01: Click to login link");
//    homePage.clickToLoginLink();
//
//    loginPage = new LoginPageObject(driver);
//
//    System.out.println("Login 03 - Step 02: Input not found email");
//    loginPage.inputToEmailTextbox(notFoundEmail);
//    loginPage.inputToPasswordTextbox(password);
//
//    System.out.println("Login 03 - Step 03: Click to login button");
//    loginPage.clickToLoginButton();
//
//    System.out.println("Login 03 - Step 04: Verify error message");
//    Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
//  }
//
//  @Test
//  public void Login_04_Existing_EmaiL_Empty_Password() {
//    System.out.println("Login 04 - Step 01: Click to login link");
//    homePage.clickToLoginLink();
//
//    loginPage = new LoginPageObject(driver);
//
//    System.out.println("Login 04 - Step 02: Input existing email without password");
//    loginPage.inputToEmailTextbox(existingEmail);
//
//    System.out.println("Login 04 - Step 03: Click to login button");
//    loginPage.clickToLoginButton();
//
//    System.out.println("Login 04 - Step 04: Verify error message");
//    Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
//  }
//
//  @Test
//  public void Login_05_Existing_EmaiL_Incorrect_Password() {
//    System.out.println("Login 05 - Step 01: Click to login link");
//    homePage.clickToLoginLink();
//
//    loginPage = new LoginPageObject(driver);
//
//    System.out.println("Login 05 - Step 02: Input existing email and incorrect password");
//    loginPage.inputToEmailTextbox(existingEmail);
//    loginPage.inputToPasswordTextbox("654321");
//
//    System.out.println("Login 05 - Step 03: Click to login button");
//    loginPage.clickToLoginButton();
//
//    System.out.println("Login 05 - Step 04: Verify error message");
//    Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
//  }
//
//  @Test
//  public void Login_06_Successful() {
//    System.out.println("Login 06 - Step 01: Click to login link");
//    homePage.clickToLoginLink();
//
//    loginPage = new LoginPageObject(driver);
//
//    System.out.println("Login 06 - Step 02: Input existing email and incorrect password");
//    loginPage.inputToEmailTextbox(existingEmail);
//    loginPage.inputToPasswordTextbox(password);
//
//    System.out.println("Login 06 - Step 03: Click to login button");
//    loginPage.clickToLoginButton();
//
//    System.out.println("Login 06 - Step 04: Verify My Account link display");
//    Assert.assertTrue(loginPage.isMyAccountLinkDisplayed());
//
//    homePage = new HomePageObject(driver);
//  }

  @AfterClass
  public void afterClass() {
    driver.quit();
  }

  public int generateFakeNumber() {
    Random random = new Random();
    return random.nextInt(99999);
  }
}
