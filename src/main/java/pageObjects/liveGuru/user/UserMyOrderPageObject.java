package pageObjects.liveGuru.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class UserMyOrderPageObject extends BasePage {
    private WebDriver driver;

    public UserMyOrderPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
