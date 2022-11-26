package pageObjects.nopCommerce.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.admin.AdminDashboardPageUI;

public class AdminDashboardPageObject extends BasePage {
    private WebDriver driver;

    public AdminDashboardPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDashboardHeaderDisplayed() {
        waitForElementVisible(driver, AdminDashboardPageUI.DASHBOARD_PAGE_HEADER);
        return isElementDisplayed(driver, AdminDashboardPageUI.DASHBOARD_PAGE_HEADER);
    }
}
