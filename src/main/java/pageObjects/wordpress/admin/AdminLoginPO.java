package pageObjects.wordpress.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.wordpress.PageGenerateManager;
import pageUIs.wordpress.admin.AdminLoginPageUI;

public class AdminLoginPO extends BasePage {
    WebDriver driver;

    public AdminLoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToUsernameTextbox(String adminUserName) {
        waitForElementVisible(driver, AdminLoginPageUI.DYNAMIC_ADMIN_LOGIN_ELEMENT, "user_login");
        sendkeysToElement(driver, AdminLoginPageUI.DYNAMIC_ADMIN_LOGIN_ELEMENT, adminUserName, "user_login");
    }

    public void enterToPasswordTextbox(String adminPassword) {
        waitForElementVisible(driver, AdminLoginPageUI.DYNAMIC_ADMIN_LOGIN_ELEMENT, "user_pass");
        sendkeysToElement(driver, AdminLoginPageUI.DYNAMIC_ADMIN_LOGIN_ELEMENT, adminPassword, "user_pass");
    }

    public AdminDashboardPO clickToLoginButton() {
        waitForElementClickable(driver, AdminLoginPageUI.DYNAMIC_ADMIN_LOGIN_ELEMENT, "wp-submit");
        clickToElement(driver, AdminLoginPageUI.DYNAMIC_ADMIN_LOGIN_ELEMENT, "wp-submit");
        return PageGenerateManager.getAdminDashboardPage(driver);
    }
}
