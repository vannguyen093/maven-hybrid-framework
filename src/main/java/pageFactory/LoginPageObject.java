package pageFactory;

import commons.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject extends BasePageFactory {
    private WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='Email']")
    private WebElement emailTextbox;

    @FindBy(xpath = "//input[@id='Password']")
    private WebElement passwordTextbox;

    @FindBy(xpath = "//button[contains(@class,'login-button')]")
    private WebElement loginButton;

    @FindBy(xpath = "//span[@id='Email-error']")
    private WebElement emailErrorMessage;

    @FindBy(xpath = "//div[contains(@class,'validation-summary-errors')]")
    private WebElement unsuccessfulMessage;

    @FindBy(xpath = "//a[@class='ico-account']")
    private WebElement myAccountLink;

    public void clickToLoginButton() {
        waitForElementClickable(driver, loginButton);
        clickToElement(driver, loginButton);
    }

    public String getErrorMessageAtEmailTextbox() {
        waitForElementVisible(driver, emailErrorMessage);
        return getElementText(driver, emailErrorMessage);
    }

    public void inputToEmailTextbox(String existingEmail) {
        waitForElementVisible(driver, emailTextbox);
        sendkeysToElement(driver, emailTextbox, existingEmail);
    }

    public void inputToPasswordTextbox(String password) {
        waitForElementVisible(driver, passwordTextbox);
        sendkeysToElement(driver, passwordTextbox, password);
    }

    public boolean isMyAccountLinkDisplayed() {
        waitForElementVisible(driver, myAccountLink);
        return true;
    }

    public String getErrorMessageUnsuccessful() {
        waitForElementVisible(driver, unsuccessfulMessage);
        return getElementText(driver, unsuccessfulMessage);
    }
}
