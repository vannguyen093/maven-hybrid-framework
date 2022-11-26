package pageObjects.wordpress.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.wordpress.PageGenerateManager;
import pageUIs.wordpress.admin.AdminPostSearchPageUI;

public class AdminPostSearchPO extends BasePage {
    WebDriver driver;

    public AdminPostSearchPO(WebDriver driver) {
        this.driver = driver;
    }

    public AdminPostAddNewOrUpdatePO clickToAddNewButton() {
        waitForElementClickable(driver, AdminPostSearchPageUI.ADD_NEW_BUTTON);
        clickToElement(driver, AdminPostSearchPageUI.ADD_NEW_BUTTON);
        return PageGenerateManager.getAdminPostAddNewPage(driver);
    }

    public void enterToSearchTextbox(String postTitle) {
        waitForElementVisible(driver, AdminPostSearchPageUI.SEARCH_TEXTBOX);
        sendkeysToElement(driver, AdminPostSearchPageUI.SEARCH_TEXTBOX, postTitle);
    }

    public void clickToSearchPostsButton() {
        waitForElementClickable(driver, AdminPostSearchPageUI.SEARCH_BUTTON);
        clickToElement(driver, AdminPostSearchPageUI.SEARCH_BUTTON);
    }

    public boolean isPostSearchTableDisplayed(String headerID, String cellValue) {
        int headerIndex = getElementSize(driver, AdminPostSearchPageUI.TABLE_HEADER_INDEX_BY_HEADER_NAME, headerID) + 1;
        waitForElementVisible(driver, AdminPostSearchPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(headerIndex), cellValue);
        return isElementDisplayed(driver, AdminPostSearchPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(headerIndex), cellValue);
    }

    public AdminPostAddNewOrUpdatePO clickToPostTitleLink(String postTitle) {
        waitForElementClickable(driver, AdminPostSearchPageUI.POST_DETAIL_BY_TITLE_NAME, postTitle);
        clickToElement(driver, AdminPostSearchPageUI.POST_DETAIL_BY_TITLE_NAME, postTitle);
        return PageGenerateManager.getAdminPostAddNewPage(driver);
    }

    public void selectPostCheckboxByPostTitle(String editPostTitle) {
        waitForElementClickable(driver, AdminPostSearchPageUI.POST_CHECKBOX_BY_TITLE_NAME, editPostTitle);
        checkToDefaultCheckboxRadio(driver, AdminPostSearchPageUI.POST_CHECKBOX_BY_TITLE_NAME, editPostTitle);
    }

    public void selectItemInActionDropdown(String itemValue) {
        waitForElementClickable(driver, AdminPostSearchPageUI.POST_ACTION_DROPDOW);
        selectItemInDefaultDropdown(driver, AdminPostSearchPageUI.POST_ACTION_DROPDOW, itemValue);
    }

    public void clickToApplyButton() {
        waitForElementClickable(driver, AdminPostSearchPageUI.APPLY_BUTTON);
        clickToElement(driver, AdminPostSearchPageUI.APPLY_BUTTON);
    }

    public boolean isDeletedSuccessMessageDisplayed(String messageText) {
        waitForElementVisible(driver, AdminPostSearchPageUI.DELETED_SUCCESS_MESSAGE, messageText);
        return isElementDisplayed(driver, AdminPostSearchPageUI.DELETED_SUCCESS_MESSAGE, messageText);
}

    public boolean isNoPostFoundMessageDisplayed(String messageText) {
        waitForElementVisible(driver, AdminPostSearchPageUI.NO_POSTS_FOUND_MESSAGE);
        return isElementDisplayed(driver, AdminPostSearchPageUI.NO_POSTS_FOUND_MESSAGE, messageText);
    }
}
