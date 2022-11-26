package pageObjects.wordpress.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.wordpress.user.UserPostDetailPageUI;

public class UserPostDetailPO extends BasePage {
    WebDriver driver;

    public UserPostDetailPO(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPostInfoDisplayedWithPostTitle(String postTitle) {
        waitForElementVisible(driver, UserPostDetailPageUI.POST_TITLE_TEXT, postTitle);
        return isElementDisplayed(driver, UserPostDetailPageUI.POST_TITLE_TEXT, postTitle);
    }

    public boolean isPostInfoDisplayedWithPostBody(String postTitle, String postBody) {
        waitForElementVisible(driver, UserPostDetailPageUI.POST_BODY_TEXT_BY_POST_TITLE, postTitle, postBody);
        return isElementDisplayed(driver, UserPostDetailPageUI.POST_BODY_TEXT_BY_POST_TITLE, postTitle, postBody);
    }

    public boolean isPostInfoDisplayedWithPostAuthor(String postTitle, String authorName) {
        waitForElementVisible(driver, UserPostDetailPageUI.POST_AUTHOR_TEXT_BY_POST_TITLE, postTitle, authorName);
        return isElementDisplayed(driver, UserPostDetailPageUI.POST_AUTHOR_TEXT_BY_POST_TITLE, postTitle, authorName);
    }

    public boolean isPostInfoDisplayedWithPostCurrentDate(String postTitle, String currentDay) {
        waitForElementVisible(driver, UserPostDetailPageUI.POST_CURRENT_DATE_TEXT_BY_POST_TITLE, postTitle, currentDay);
        return isElementDisplayed(driver, UserPostDetailPageUI.POST_CURRENT_DATE_TEXT_BY_POST_TITLE, postTitle, currentDay);
    }
}
