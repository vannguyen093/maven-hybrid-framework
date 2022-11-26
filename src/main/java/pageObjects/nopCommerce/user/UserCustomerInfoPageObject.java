package pageObjects.nopCommerce.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.user.UserCustomerInfoPageUI;

public class UserCustomerInfoPageObject extends BasePage {
    private WebDriver driver;

    public UserCustomerInfoPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isMyAccountTitleDisplayed(String myAccountTitleText) {
        waitForElementVisible(driver, UserCustomerInfoPageUI.DYNAMIC_MY_ACCOUNT_TITLE_BY_TEXT, myAccountTitleText);
        return isElementDisplayed(driver, UserCustomerInfoPageUI.DYNAMIC_MY_ACCOUNT_TITLE_BY_TEXT, myAccountTitleText);
    }
}
