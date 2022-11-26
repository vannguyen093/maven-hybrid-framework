package com.jquery;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.uploadFile.HomePageObject;
import pageObjects.jquery.uploadFile.PageGeneratorManager;

public class Level_11_Upload_FIle extends BaseTest {
    private WebDriver driver;
    HomePageObject homePage;
    String img1 = "img1.jpg";
    String img2 = "img2.jpg";
    String img3 = "img3.jpg";

    String[] multipleFiles = {img1, img2, img3};

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {

        driver = getBrowserDriver(browserName, appUrl);

        homePage = PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void Upload_01_One_File_Per_Time() {
        homePage.uploadMultipleFiles(driver, img1);

        Assert.assertTrue(homePage.isFileLoadedByName(img1));
        homePage.clickToStartButton();

        Assert.assertTrue(homePage.isFileUploadedByName(img1));

        Assert.assertTrue(homePage.isFileImageUploadedByName(img1));
    }

    @Test
    public void Upload_02_Multiple_File_Per_Time() {
        homePage.refreshCurrentPage(driver);

        homePage.uploadMultipleFiles(driver, multipleFiles);

        Assert.assertTrue(homePage.isFileLoadedByName(img1));
        Assert.assertTrue(homePage.isFileLoadedByName(img2));
        Assert.assertTrue(homePage.isFileLoadedByName(img3));
        homePage.clickToStartButton();

        Assert.assertTrue(homePage.isFileUploadedByName(img1));
        Assert.assertTrue(homePage.isFileUploadedByName(img2));
        Assert.assertTrue(homePage.isFileUploadedByName(img3));

        Assert.assertTrue(homePage.isFileImageUploadedByName(img1));
        Assert.assertTrue(homePage.isFileImageUploadedByName(img2));
        Assert.assertTrue(homePage.isFileImageUploadedByName(img3));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
