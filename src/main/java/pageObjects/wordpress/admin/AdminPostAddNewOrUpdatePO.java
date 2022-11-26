package pageObjects.wordpress.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.wordpress.PageGenerateManager;
import pageUIs.wordpress.admin.AdminPostAddNewOrUpdatePageUI;

public class AdminPostAddNewOrUpdatePO extends BasePage {
    WebDriver driver;

    public AdminPostAddNewOrUpdatePO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToPostTitle(String postTitle) {
        waitForElementVisible(driver, AdminPostAddNewOrUpdatePageUI.TITLE_TEXTBOX, postTitle);
        sendkeysToElement(driver, AdminPostAddNewOrUpdatePageUI.TITLE_TEXTBOX, postTitle);
    }

    public void enterToPostBody(String postBody) {
        waitForElementClickable(driver, AdminPostAddNewOrUpdatePageUI.BODY_BUTTON);
        clickToElement(driver, AdminPostAddNewOrUpdatePageUI.BODY_BUTTON);

        waitForElementVisible(driver, AdminPostAddNewOrUpdatePageUI.BODY_TEXTAREA);
        sendkeysToElement(driver, AdminPostAddNewOrUpdatePageUI.BODY_TEXTAREA, postBody);
    }

    public void clickToPulishOrUpdatePrimaryButton() {
        waitForElementClickable(driver, AdminPostAddNewOrUpdatePageUI.PUBLISH_OR_UPDATE_PRIMARY_BUTTON);
        clickToElement(driver, AdminPostAddNewOrUpdatePageUI.PUBLISH_OR_UPDATE_PRIMARY_BUTTON);
    }

    public void clickToPulishOrUpdateSecondaryButton() {
        waitForElementClickable(driver, AdminPostAddNewOrUpdatePageUI.PUBLISH_OR_UPDATE_SECONDARY_BUTTON);
        clickToElement(driver, AdminPostAddNewOrUpdatePageUI.PUBLISH_OR_UPDATE_SECONDARY_BUTTON);
    }

    public boolean isPostPublishedMessageDisplayed(String postPublishMessage) {
        waitForElementVisible(driver, AdminPostAddNewOrUpdatePageUI.PUBLISHED_UPDATED_MESSAGE, postPublishMessage);
        return isElementDisplayed(driver, AdminPostAddNewOrUpdatePageUI.PUBLISHED_UPDATED_MESSAGE, postPublishMessage);
    }

    public AdminPostSearchPO openSearchPostPageUrl(String searchPostUrl) {
        openPageUrl(driver, searchPostUrl);
        return PageGenerateManager.getAdminPostSearchPage(driver);
    }

    public void enterToEditPostBody(String editBody) {
        waitForElementClickable(driver, AdminPostAddNewOrUpdatePageUI.BODY_TEXTAREA);
        clickToElement(driver, AdminPostAddNewOrUpdatePageUI.BODY_TEXTAREA);

        waitForElementVisible(driver, AdminPostAddNewOrUpdatePageUI.BODY_TEXTAREA);
        clearValueByDeleteKey(driver, AdminPostAddNewOrUpdatePageUI.BODY_TEXTAREA);
        sendkeysToElement(driver, AdminPostAddNewOrUpdatePageUI.BODY_TEXTAREA, editBody);
    }
}
