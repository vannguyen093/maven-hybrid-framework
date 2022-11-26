package com.wordpress.admin;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.wordpress.PageGenerateManager;
import pageObjects.wordpress.admin.*;
import pageObjects.wordpress.user.UserHomePO;
import pageObjects.wordpress.user.UserPostDetailPO;
import pageObjects.wordpress.user.UserPostSearchPO;

public class Post_01_Create_Read_Update_Delete_Search extends BaseTest {

    @Parameters({"browser", "urlAdmin", "urlUser"})
    @BeforeClass
    public void beforeClass(String browserName, String adminUrl, String userUrl) {
        this.adminUrl = adminUrl;
        this.userUrl = userUrl;
        adminUserName = "vannguyen093";
        adminPassword = "vannguyen093";
        int randomNumber = generateFakeNumber();
        postTitle = "Live Coding Title " + randomNumber;
        postBody = "Live Coding Body " + randomNumber;
        editPostTitle = "Edit Title " + randomNumber;
        editPostBody = "Edit Body " + randomNumber;
        authorName = "vannguyen093";
        currentDay = getToday();

        log.info("Pre-Condition - Step 01: Open browser and admin url");
        driver = getBrowserDriver(browserName, this.adminUrl);
        adminLoginPageObject = PageGenerateManager.getAdminLoginPage(driver);

        log.info("Pre-Condition - Step 02: Enter to Username textbox with value is " + adminUserName);
        adminLoginPageObject.enterToUsernameTextbox(adminUserName);

        log.info("Pre-Condition - Step 03: Enter to Password textbox with value is " + adminPassword);
        adminLoginPageObject.enterToPasswordTextbox(adminPassword);

        log.info("Pre-Condition - Step 04: Click to 'Login' button");
        adminDashboardPage = adminLoginPageObject.clickToLoginButton();

    }

    @Test
    public void Post_01_Create_New_Post() {
        log.info("Create_Post - Step 01: Click to 'Post' menu link");
        adminPostSearchPage = adminDashboardPage.clickToPostMenuLink();

        log.info("Create_Post - Step 02: Get 'Search post' url");
        searchPostUrl = adminPostSearchPage.getPageUrl(driver);

        log.info("Create_Post - Step 03: Click to 'Add New' button");
        adminPostAddNewOrUpdatePage = adminPostSearchPage.clickToAddNewButton();

        log.info("Create_Post - Step 04: Enter to post title");
        adminPostAddNewOrUpdatePage.enterToPostTitle(postTitle);

        log.info("Create_Post - Step 05: Enter to post body");
        adminPostAddNewOrUpdatePage.enterToPostBody(postBody);

        log.info("Create_Post - Step 06: Click to 'Pulish' primary button");
        adminPostAddNewOrUpdatePage.clickToPulishOrUpdatePrimaryButton();

        log.info("Create_Post - Step 06: Click to 'Pulish' secondary button");
        adminPostAddNewOrUpdatePage.clickToPulishOrUpdateSecondaryButton();

        log.info("Create_Post - Step 07: Verify 'Post published.' message is displayed");
        verifyTrue(adminPostAddNewOrUpdatePage.isPostPublishedMessageDisplayed("Post published."));
    }

    @Test
    public void Post_02_Search_And_View_Post() {
        log.info("Search_Post - Step 01: Open 'Search post' page");
        adminPostSearchPage = adminPostAddNewOrUpdatePage.openSearchPostPageUrl(searchPostUrl);

        log.info("Search_Post - Step 02: Enter to 'Search' textbox");
        adminPostSearchPage.enterToSearchTextbox(postTitle);

        log.info("Search_Post - Step 03: Click to 'Search Posts' button");
        adminPostSearchPage.clickToSearchPostsButton();

        log.info("Search_Post - Step 04: Verify Search table contains '" + postTitle +"'");
        verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("title", postTitle));

        log.info("Search_Post - Step 05: Verify Search table contains '" + authorName +"'");
        verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("author", authorName));

        log.info("Search_Post - Step 06: Open User Site");
        userHomePage = adminPostSearchPage.openUserSite(driver, this.userUrl);

        log.info("Search_Post - Step 07: Verify post info displayed at Home Page");
        verifyTrue(userHomePage.isPostInfoDisplayedWithPostTitle(postTitle));
        verifyTrue(userHomePage.isPostInfoDisplayedWithPostBody(postTitle,postBody));
        verifyTrue(userHomePage.isPostInfoDisplayedWithPostAuthor(postTitle,authorName));
        verifyTrue(userHomePage.isPostInfoDisplayedWithPostCurrentDate(postTitle,currentDay));

        log.info("Search_Post - Step 08: Click to post title");
        userPostDetailPage = userHomePage.clickToPostTitle(postTitle);

        log.info("Search_Post - Step 09: Verify post info displayed at Post Detail Page");
        verifyTrue(userPostDetailPage.isPostInfoDisplayedWithPostTitle(postTitle));
        verifyTrue(userPostDetailPage.isPostInfoDisplayedWithPostBody(postTitle,postBody));
        verifyTrue(userPostDetailPage.isPostInfoDisplayedWithPostAuthor(postTitle,authorName));
        verifyTrue(userPostDetailPage.isPostInfoDisplayedWithPostCurrentDate(postTitle,currentDay));
    }

    @Test
    public void Post_03_Edit_Post() {
        log.info("Edit_Post - Step 01: Open 'Admin' site");
        adminDashboardPage = userPostDetailPage.openAdminSite(driver, this.adminUrl);

        log.info("Edit_Post - Step 02: Click to 'Post' menu link");
        adminPostSearchPage = adminDashboardPage.clickToPostMenuLink();

        log.info("Edit_Post - Step 03: Enter to 'Search' textbox");
        adminPostSearchPage.enterToSearchTextbox(postTitle);

        log.info("Edit_Post - Step 04: Click to 'Search Posts' button");
        adminPostSearchPage.clickToSearchPostsButton();

        log.info("Edit_Post - Step 05: Click to Post title and navigate to edit post page");
        adminPostAddNewOrUpdatePage = adminPostSearchPage.clickToPostTitleLink(postTitle);

        log.info("Edit_Post - Step 06: Enter to edit title");
        adminPostAddNewOrUpdatePage.enterToPostTitle(editPostTitle);

        log.info("Edit_Post - Step 07: Enter to edit body");
        adminPostAddNewOrUpdatePage.enterToEditPostBody(editPostBody);

        log.info("Edit_Post - Step 08: Click to 'Update' button");
        adminPostAddNewOrUpdatePage.clickToPulishOrUpdateSecondaryButton();

        log.info("Edit_Post - Step 09: Open 'Search post' page");
        adminPostSearchPage = adminPostAddNewOrUpdatePage.openSearchPostPageUrl(searchPostUrl);

        log.info("Edit_Post - Step 10: Enter to 'Search' textbox");
        adminPostSearchPage.enterToSearchTextbox(editPostTitle);

        log.info("Edit_Post - Step 11: Click to 'Search Posts' button");
        adminPostSearchPage.clickToSearchPostsButton();

        log.info("Edit_Post - Step 12: Verify Search table contains '" + editPostTitle +"'");
        verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("title", editPostTitle));

        log.info("Edit_Post - Step 13: Verify Search table contains '" + authorName +"'");
        verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("author", authorName));

        log.info("Edit_Post - Step 14: Open User Site");
        userHomePage = adminPostSearchPage.openUserSite(driver, this.userUrl);

        log.info("Edit_Post - Step 15: Verify edit post info displayed at Home Page");
        verifyTrue(userHomePage.isPostInfoDisplayedWithPostTitle(editPostTitle));
        verifyTrue(userHomePage.isPostInfoDisplayedWithPostBody(editPostTitle, editPostBody));
        verifyTrue(userHomePage.isPostInfoDisplayedWithPostAuthor(editPostTitle,authorName));
        verifyTrue(userHomePage.isPostInfoDisplayedWithPostCurrentDate(editPostTitle,currentDay));

        log.info("Edit_Post - Step 16: Click to edit post title");
        userPostDetailPage = userHomePage.clickToPostTitle(editPostTitle);

        log.info("Edit_Post - Step 17: Verify edit post info displayed at Post Detail Page");
        verifyTrue(userPostDetailPage.isPostInfoDisplayedWithPostTitle(editPostTitle));
        verifyTrue(userPostDetailPage.isPostInfoDisplayedWithPostBody(editPostTitle, editPostBody));
        verifyTrue(userPostDetailPage.isPostInfoDisplayedWithPostAuthor(editPostTitle,authorName));
        verifyTrue(userPostDetailPage.isPostInfoDisplayedWithPostCurrentDate(editPostTitle,currentDay));

    }

    @Test
    public void Post_04_Delete_Post() {
        log.info("Delete_Post - Step 01: Open 'Admin' site");
        adminDashboardPage = userPostDetailPage.openAdminSite(driver, this.adminUrl);

        log.info("Delete_Post - Step 02: Click to 'Post' menu link");
        adminPostSearchPage = adminDashboardPage.clickToPostMenuLink();

        log.info("Delete_Post - Step 03: Enter to 'Search' textbox");
        adminPostSearchPage.enterToSearchTextbox(editPostTitle);

        log.info("Delete_Post - Step 04: Click to 'Search Posts' button");
        adminPostSearchPage.clickToSearchPostsButton();

        log.info("Delete_Post - Step 05: Select 'Post' checkbox");
        adminPostSearchPage.selectPostCheckboxByPostTitle(editPostTitle);

        log.info("Delete_Post - Step 06: Select 'Move to trash' item in dropdown list");
        adminPostSearchPage.selectItemInActionDropdown("Move to Trash");

        log.info("Delete_Post - Step 06: Click to 'Apply' button");
        adminPostSearchPage.clickToApplyButton();

        log.info("Delete_Post - Step 06: Verify '1 post moved to the Trash.' message is displayed");
        verifyTrue(adminPostSearchPage.isDeletedSuccessMessageDisplayed("1 post moved to the Trash."));

        log.info("Delete_Post - Step 10: Enter to 'Search' textbox");
        adminPostSearchPage.enterToSearchTextbox(editPostTitle);

        log.info("Delete_Post - Step 11: Click to 'Search Posts' button");
        adminPostSearchPage.clickToSearchPostsButton();

        log.info("Delete_Post - Step 06: Verify 'No posts found.' message is displayed");
        verifyTrue(adminPostSearchPage.isNoPostFoundMessageDisplayed("No posts found."));

        log.info("Delete_Post - Step 14: Open User Site");
        userHomePage = adminPostSearchPage.openUserSite(driver, this.userUrl);

        log.info("Delete_Post - Step 15: Verify edit post title undisplayed at Home Page");
        verifyTrue(userHomePage.isPostInfoUndisplayedWithPostTitle(editPostTitle));

        log.info("Delete_Post - Step 10: Enter to 'Search' textbox");
        userHomePage.enterToSearchTextbox(editPostTitle);

        log.info("Delete_Post - Step 11: Click to 'Search' button");
        userPostSearchPage = userHomePage.clickToSearchButton();

        log.info("Delete_Post - Step 06: Verify 'Nothing Found' message is displayed");
        verifyTrue(userPostSearchPage.isNothingFoundMessageDisplayed("Nothing Found"));

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver();
    }
    private WebDriver driver;
    private String adminUserName, adminPassword, postTitle, postBody, editPostTitle, editPostBody;
    private String searchPostUrl, authorName;
    String adminUrl, userUrl, currentDay;
    AdminLoginPO adminLoginPageObject;
    AdminDashboardPO adminDashboardPage;
    AdminPostSearchPO adminPostSearchPage;
    AdminPostAddNewOrUpdatePO adminPostAddNewOrUpdatePage;
    UserHomePO userHomePage;
    UserPostDetailPO userPostDetailPage;
    UserPostSearchPO userPostSearchPage;

}
