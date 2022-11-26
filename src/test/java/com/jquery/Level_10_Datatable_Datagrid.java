package com.jquery;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.dataTable.HomePageObject;
import pageObjects.jquery.dataTable.PageGeneratorManager;

public class Level_10_Datatable_Datagrid extends BaseTest {
    private WebDriver driver;
    HomePageObject homePage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {

        driver = getBrowserDriver(browserName, appUrl);

        homePage = PageGeneratorManager.getHomePage(driver);
    }

//    @Test
//    public void Table_01_Paging() {
//        homePage.openPagingByPageNumber("5");
//        homePage.sleepInSecond(1);
//        Assert.assertTrue(homePage.isPageNumberActived("5"));
//
//        homePage.openPagingByPageNumber("10");
//        homePage.sleepInSecond(1);
//        Assert.assertTrue(homePage.isPageNumberActived("10"));
//
//        homePage.openPagingByPageNumber("15");
//        homePage.sleepInSecond(1);
//        Assert.assertTrue(homePage.isPageNumberActived("15"));
//    }
//
//    @Test
//    public void Table_02_Filter() {
//        homePage.refreshCurrentPage(driver);
//
//        homePage.inputToFilterTextboxByLabel("Country","Argentina");
//        homePage.sleepInSecond(3);
//
//        homePage.inputToFilterTextboxByLabel("Country","Arab Rep of Egypt");
//        homePage.sleepInSecond(3);
//
//        homePage.inputToFilterTextboxByLabel("Total","1580");
//        homePage.sleepInSecond(3);
//    }
//
//    @Test
//    public void Table_03() {
//        homePage.getValueEachRowAtAllPage();
//    }

    @Test
    public void Table_04_Enter_To_Textbox_At_Any_Row() {
        homePage.clickToLoadDemoButton();

        homePage.enterToTextboxAtRowNumberByColumnName("Album","1","Michael 97");
        homePage.enterToTextboxAtRowNumberByColumnName("Artist","2","Michael Jacksop");
        homePage.enterToTextboxAtRowNumberByColumnName("Year","3","1997");
        homePage.enterToTextboxAtRowNumberByColumnName("Price","4","15");
        homePage.selectDropdownByColumnNameAtRowNumber("Origin","5","Japan");
        homePage.checkToCheckBoxByColumnNameAtRowNumber("With Poster?", "3");
        homePage.checkToCheckBoxByColumnNameAtRowNumber("With Poster?", "5");

        homePage.uncheckToCheckBoxByColumnNameAtRowNumber("With Poster?", "1");
        homePage.uncheckToCheckBoxByColumnNameAtRowNumber("With Poster?", "2");
        homePage.uncheckToCheckBoxByColumnNameAtRowNumber("With Poster?", "4");

        homePage.clickToButtonByRowNumber("1","Remove Current Row");
        homePage.sleepInSecond(2);
        homePage.clickToButtonByRowNumber("1","Insert Row Above");
        homePage.sleepInSecond(2);
        homePage.clickToButtonByRowNumber("3","Move Up");
        homePage.sleepInSecond(2);
        homePage.clickToButtonByRowNumber("2","Move Down");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
