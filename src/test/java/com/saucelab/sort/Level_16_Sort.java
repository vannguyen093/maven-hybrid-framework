package com.saucelab.sort;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.saucelab.HomePageObject;
import pageObjects.saucelab.LoginPageObject;
import pageObjects.saucelab.PageGenerateManager;

public class Level_16_Sort extends BaseTest {

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        username = "standard_user";
        password = "secret_sauce";
        driver = getBrowserDriver(browserName, appUrl);
        loginPage = PageGenerateManager.getLoginPage(driver);

        loginPage.enterToUsernameTextbox(username);
        loginPage.enterToPasswordTextbox(password);
        homePage = loginPage.clickToLoginButton();
    }

    @Test
    public void Sort_01_Name() {
        homePage.selectItemInProductSortDropdown("Name (A to Z)");
        Assert.assertTrue(homePage.isProductNameSortByAsc());
        homePage.selectItemInProductSortDropdown("Name (Z to A)");
        Assert.assertTrue(homePage.isProductNameSortByDecs());
    }

    @Test
    public void Sort_02_Price() {
        homePage.selectItemInProductSortDropdown("Price (low to high)");
        Assert.assertTrue(homePage.isProductPriceSortByAsc());
        homePage.selectItemInProductSortDropdown("Price (high to low)");
        Assert.assertTrue(homePage.isProductPriceSortByDesc());
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver();
    }
    private WebDriver driver;
    LoginPageObject loginPage;
    HomePageObject homePage;
    private String username, password;
}
