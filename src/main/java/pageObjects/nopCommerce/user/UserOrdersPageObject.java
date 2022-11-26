package pageObjects.nopCommerce.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class UserOrdersPageObject extends BasePage {
    private WebDriver driver;

    public UserOrdersPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
