package pageFactory;

import commons.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObject extends BasePageFactory {
    private WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@id='register-button']")
    private WebElement registerButton;

    @FindBy(xpath = "//span[@id='FirstName-error']")
    private WebElement firstNameErrorMessage;

    @FindBy(xpath = "//span[@id='LastName-error']")
    private WebElement lastNameErrorMessage;

    @FindBy(xpath = "//span[@id='Email-error']")
    private WebElement emailErrorMessage;

    @FindBy(xpath = "//span[@id='Password-error']")
    private WebElement passwordErrorMessage;

    @FindBy(xpath = "//span[@id='ConfirmPassword-error']")
    private WebElement confirmPasswordErrorMessage;

    @FindBy(xpath = "//div[@class='message-error validation-summary-errors']//li")
    private WebElement existingEmailErrorMessage;

    @FindBy(xpath = "//input[@id='FirstName']")
    private WebElement firstNameTextbox;

    @FindBy(xpath = "//input[@id='LastName']")
    private WebElement lastNameTextbox;

    @FindBy(xpath = "//input[@id='Email']")
    private WebElement emailTextbox;

    @FindBy(xpath = "//input[@id='Password']")
    private WebElement passwordTextbox;

    @FindBy(xpath = "//input[@id='ConfirmPassword']")
    private WebElement confirmPasswordTextbox;

    @FindBy(xpath = "//a[@class='ico-logout']")
    private WebElement logoutLink;

    @FindBy(xpath = "//div[@class='result']")
    private WebElement successMessage;


    public void clickToRegisterButton() {
        waitForElementClickable(driver, registerButton);
        clickToElement(driver, registerButton);
    }

    public String getErrorAtFirstNameTextbox() {
        waitForElementVisible(driver, firstNameErrorMessage);
        return getElementText(driver, firstNameErrorMessage);
    }

    public String getErrorAtLastNameTextbox() {
        waitForElementVisible(driver, lastNameErrorMessage);
        return getElementText(driver, lastNameErrorMessage);
    }

    public String getErrorAtEmailTextbox() {
        waitForElementVisible(driver, emailErrorMessage);
        return getElementText(driver, emailErrorMessage);
    }

    public String getErrorAtPasswordTextbox() {
        waitForElementVisible(driver, passwordErrorMessage);
        return getElementText(driver, passwordErrorMessage);
    }

    public String getErrorAtConfirmPasswordTextbox() {
        waitForElementVisible(driver, confirmPasswordErrorMessage);
        return getElementText(driver, confirmPasswordErrorMessage);
    }

    public void inputToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, firstNameTextbox);
        sendkeysToElement(driver, firstNameTextbox, firstName);
    }

    public void inputToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, lastNameTextbox);
        sendkeysToElement(driver, lastNameTextbox, lastName);
    }

    public void inputToEmailTextbox(String email) {
        waitForElementVisible(driver, emailTextbox);
        sendkeysToElement(driver, emailTextbox, email);
    }

    public void inputToPasswordTextbox(String password) {
        waitForElementVisible(driver, passwordTextbox);
        sendkeysToElement(driver, passwordTextbox, password);
    }

    public void inputToConfirmPasswordTextbox(String password) {
        waitForElementVisible(driver, confirmPasswordTextbox);
        sendkeysToElement(driver, confirmPasswordTextbox, password);
    }

    public String getSuccessMessage() {
        waitForElementVisible(driver, successMessage);
        return getElementText(driver, successMessage);
    }

    public void clickToLogOutLink() {
        waitForElementClickable(driver, logoutLink);
        clickToElement(driver, logoutLink);
    }

    public String getErrorAtExistingEmail() {
        waitForElementVisible(driver, existingEmailErrorMessage);
        return getElementText(driver, existingEmailErrorMessage);
    }
}
