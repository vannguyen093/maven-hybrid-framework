package pageObjects.wordpress.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.wordpress.PageGenerateManager;
import pageUIs.wordpress.user.UserHomePageUI;

public class UserHomePO extends BasePage {
    WebDriver driver;

    public UserHomePO(WebDriver driver) {
        this.driver = driver;
    }

    public UserPostDetailPO clickToPostTitle(String postTitle) {
        waitForElementClickable(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
        clickToElement(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
        return PageGenerateManager.getUserPostDetailPage(driver);
    }

    public boolean isPostInfoDisplayedWithPostTitle(String postTitle) {
        waitForElementVisible(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
        return isElementDisplayed(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
    }

    public boolean isPostInfoDisplayedWithPostBody(String postTitle, String postBody) {
        waitForElementVisible(driver, UserHomePageUI.POST_BODY_TEXT_BY_POST_TITLE, postTitle, postBody);
        return isElementDisplayed(driver, UserHomePageUI.POST_BODY_TEXT_BY_POST_TITLE, postTitle, postBody);
    }

    public boolean isPostInfoDisplayedWithPostAuthor(String postTitle, String authorName) {
        waitForElementVisible(driver, UserHomePageUI.POST_AUTHOR_TEXT_BY_POST_TITLE, postTitle, authorName);
        return isElementDisplayed(driver, UserHomePageUI.POST_AUTHOR_TEXT_BY_POST_TITLE, postTitle, authorName);
    }

    public boolean isPostInfoDisplayedWithPostCurrentDate(String postTitle, String currentDay) {
        waitForElementVisible(driver, UserHomePageUI.POST_CURRENT_DATE_TEXT_BY_POST_TITLE, postTitle, currentDay);
        return isElementDisplayed(driver, UserHomePageUI.POST_CURRENT_DATE_TEXT_BY_POST_TITLE, postTitle, currentDay);
    }

    public boolean isPostInfoUndisplayedWithPostTitle(String editPostTitle) {
        return isElementUndisplayed(driver, UserHomePageUI.POST_TITLE_TEXT, editPostTitle);
    }

    public void enterToSearchTextbox(String editPostTitle) {
        waitForElementVisible(driver, UserHomePageUI.SEARCH_TEXTBOX);
        sendkeysToElement(driver, UserHomePageUI.SEARCH_TEXTBOX, editPostTitle);
    }

    public UserPostSearchPO clickToSearchButton() {
        waitForElementClickable(driver, UserHomePageUI.SEARCH_BUTTON);
        clickToElement(driver, UserHomePageUI.SEARCH_BUTTON);
        return PageGenerateManager.getUserPostSearchPage(driver);
    }
}
