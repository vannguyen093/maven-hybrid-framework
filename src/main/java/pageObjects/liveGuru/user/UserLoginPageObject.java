package pageObjects.liveGuru.user;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.liveGuru.user.LoginPageUI;

public class UserLoginPageObject extends BasePage {
    private WebDriver driver;

    public UserLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click to 'Create an Account' Button")
    public RegisterPageObject clickToCreateAnAccountButton() {
        waitForElementClickable(driver, LoginPageUI.CREATE_AN_ACCOUNT_BUTTON);
        clickToElement(driver, LoginPageUI.CREATE_AN_ACCOUNT_BUTTON);
        return PageGeneratorManager.getRegisterPage(driver);
    }

    @Step("Input to Email textbox with value is {0}")
    public void inputToEmailTextbox(String email) {
        waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
        sendkeysToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
    }

    @Step("Input to Password textbox with value is {0}")
    public void inputPasswordTextbox(String password) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendkeysToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    @Step("Click to Login button")
    public void clickToLoginButton() {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
    }

    @Step("Input to Email and Password textbox with value is {0}, {1}")
    public UserMyDashboardPageObject loginAsUser(String email, String password) {
        inputToEmailTextbox(email);
        inputPasswordTextbox(password);
        clickToLoginButton();
        return PageGeneratorManager.getMyAccountDashboardPage(driver);
    }
}
