package pageObjects.liveGuru.user;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.liveGuru.user.AccountInfoPageUI;

public class UserAccountInforPageObject extends BasePage {
    private WebDriver driver;

    public UserAccountInforPageObject(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Verify Info At First Name Textbox is {3}")
    public String getValueAtFirstNameTextbox() {
        waitForElementVisible(driver, AccountInfoPageUI.DYNAMIC_LOCATOR_AT_ACCOUNT_INFO_PAGE,"firstname");
        return getElementAttribute(driver, AccountInfoPageUI.DYNAMIC_LOCATOR_AT_ACCOUNT_INFO_PAGE,"value","firstname");
    }

    @Step("Verify Info At Last Name Textbox is {3}")
    public String getValueAtLastNameTextbox() {
        waitForElementVisible(driver, AccountInfoPageUI.DYNAMIC_LOCATOR_AT_ACCOUNT_INFO_PAGE,"lastname");
        return getElementAttribute(driver, AccountInfoPageUI.DYNAMIC_LOCATOR_AT_ACCOUNT_INFO_PAGE,"value","lastname");
    }

    @Step("Verify Info At Email Textbox is {3}")
    public String getValueAtEmailTextbox() {
        waitForElementVisible(driver, AccountInfoPageUI.DYNAMIC_LOCATOR_AT_ACCOUNT_INFO_PAGE,"email");
        return getElementAttribute(driver, AccountInfoPageUI.DYNAMIC_LOCATOR_AT_ACCOUNT_INFO_PAGE,"value","email");
    }
}
