package pageObjects.liveGuru.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.liveGuru.user.PageGeneratorManager;
import pageUIs.liveGuru.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
    private WebDriver driver;

    public AdminLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToLoginTextbox(String adminUserName, String textboxName) {
        waitForElementVisible(driver, AdminLoginPageUI.LOGIN_TEXTBOX, textboxName);
        sendkeysToElement(driver, AdminLoginPageUI.LOGIN_TEXTBOX, adminUserName, textboxName);
    }

    public void clickToLoginButton(){
        waitForElementVisible(driver, AdminLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
    }

    public AdminHomePageObject loginAsAdmin(String adminUserName, String adminPassword) {
        inputToLoginTextbox(adminUserName,"username");
        inputToLoginTextbox(adminPassword,"login");
        clickToLoginButton();
        return PageGeneratorManager.getAdminHomePage(driver);
    }
}
