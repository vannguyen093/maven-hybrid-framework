package pageObjects.liveGuru.user;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.liveGuru.user.MyDashboardtPageUI;

public class UserMyDashboardPageObject extends BasePage {
    private WebDriver driver;

    public UserMyDashboardPageObject(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Verify Register Success Message is Displayed")
    public String getRegisterSuccessMessage() {
        waitForElementVisible(driver, MyDashboardtPageUI.SUCCESS_MESSAGE);
        return getElementText(driver, MyDashboardtPageUI.SUCCESS_MESSAGE);
    }

    @Step("Verify the title of Dashboard Page is displayed")
    public String getHelloUserText() {
        waitForElementVisible(driver, MyDashboardtPageUI.HELLO_USER_MESSAGE);
        return getElementText(driver, MyDashboardtPageUI.HELLO_USER_MESSAGE);
    }
}
