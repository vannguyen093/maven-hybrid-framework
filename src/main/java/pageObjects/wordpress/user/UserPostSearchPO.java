package pageObjects.wordpress.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.wordpress.user.UserPostSearchPageUI;

public class UserPostSearchPO extends BasePage {
    WebDriver driver;

    public UserPostSearchPO(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isNothingFoundMessageDisplayed(String messageText) {
        waitForElementVisible(driver, UserPostSearchPageUI.NOTHING_FOUND_MESSAGE, messageText);
        return isElementDisplayed(driver, UserPostSearchPageUI.NOTHING_FOUND_MESSAGE, messageText);
    }
}
