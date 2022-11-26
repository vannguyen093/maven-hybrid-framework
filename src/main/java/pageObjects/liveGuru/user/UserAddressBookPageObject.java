package pageObjects.liveGuru.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class UserAddressBookPageObject extends BasePage {
    private WebDriver driver;

    public UserAddressBookPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
