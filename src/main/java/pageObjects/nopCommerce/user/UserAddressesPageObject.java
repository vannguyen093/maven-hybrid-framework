package pageObjects.nopCommerce.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class UserAddressesPageObject extends BasePage {
    private WebDriver driver;

    public UserAddressesPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
