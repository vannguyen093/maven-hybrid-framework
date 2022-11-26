package pageObjects.liveGuru.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.liveGuru.admin.AdminHomePageUI;

public class AdminHomePageObject extends BasePage {
    private WebDriver driver;

    public AdminHomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void closeAdminPopup() {
        waitForElementClickable(driver, AdminHomePageUI.CLOSE_POPUP_BUTTON);
        clickToElement(driver, AdminHomePageUI.CLOSE_POPUP_BUTTON);
    }

    public boolean isHomePageTitleDisplayed() {
        waitForElementVisible(driver, AdminHomePageUI.HOMEPAGE_TITLE);
        return isElementDisplayed(driver, AdminHomePageUI.HOMEPAGE_TITLE);
    }

    public void clicktoPagingButtonByButtonName(String pagingButtonName) {
        waitForElementClickable(driver, AdminHomePageUI.PAGING_NAVIGATION_BY_NAME, pagingButtonName);
        clickToElement(driver, AdminHomePageUI.PAGING_NAVIGATION_BY_NAME, pagingButtonName);
    }

    public String getValuePagingTextbox() {
        waitForElementInvisible(driver, AdminHomePageUI.LOADING_MASK);
        waitForElementVisible(driver, AdminHomePageUI.PAGING_TEXT_PAGE);
        return getElementAttribute(driver, AdminHomePageUI.PAGING_TEXT_PAGE, "value");
    }

    public void enterToFilterTextboxByColumnName(String filterTextboxName, String email) {
        waitForElementClickable(driver, AdminHomePageUI.FILTER_TEXTBOX, filterTextboxName);
        sendkeysToElement(driver, AdminHomePageUI.FILTER_TEXTBOX, email, filterTextboxName);
    }

    public boolean isAccountRegisteredDisplayed(String fullName, String email) {
        waitForElementVisible(driver, AdminHomePageUI.CUSTOMER_TEXT_AT_ROW, fullName, email);
        return isElementDisplayed(driver, AdminHomePageUI.CUSTOMER_TEXT_AT_ROW, fullName, email);
    }

    public void checkToCheckboxByCustomerEmail(String email) {
        waitForElementVisible(driver, AdminHomePageUI.CUSTOMER_CHECKBOX, email);
        checkToDefaultCheckboxRadio(driver, AdminHomePageUI.CUSTOMER_CHECKBOX, email);
    }

    public void uncheckToCheckBoxByCustomerName(String email) {
        waitForElementClickable(driver, AdminHomePageUI.CUSTOMER_CHECKBOX, email);
        clickToElement(driver, AdminHomePageUI.CUSTOMER_CHECKBOX, email);
    }

    public String getNumberItemsSelected() {
        waitForElementVisible(driver, AdminHomePageUI.NUMBER_ITEMS_SELECTED);
        return getElementText(driver, AdminHomePageUI.NUMBER_ITEMS_SELECTED);
    }

    public void selectActionsAtActionDropdownByActionName(String actionName) {
        waitForElementClickable(driver, AdminHomePageUI.DROPDOWN_BY_NAME, actionName);
        selectItemInDefaultDropdown(driver, AdminHomePageUI.DROPDOWN_BY_NAME, actionName);
        clickToElement(driver, AdminHomePageUI.SUBMIT_BUTTON);
    }

    public boolean isDeleteSuccessDisplayed() {
        acceptAlert(driver);
        waitForElementVisible(driver, AdminHomePageUI.DELETE_SUCCESS_MESSAGE);
        return isElementDisplayed(driver, AdminHomePageUI.DELETE_SUCCESS_MESSAGE);
    }

    public void selectOrUnselectByLinkName(String linkTextName) {
        waitForElementVisible(driver, AdminHomePageUI.SELECT_UNSELECT_BY_NAME, linkTextName);
        clickToElement(driver, AdminHomePageUI.SELECT_UNSELECT_BY_NAME, linkTextName);
    }
}
