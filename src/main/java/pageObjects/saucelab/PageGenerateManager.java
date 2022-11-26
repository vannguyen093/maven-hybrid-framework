package pageObjects.saucelab;

import org.openqa.selenium.WebDriver;

public class PageGenerateManager {
    public static HomePageObject getHomePage(WebDriver driver){
        return new HomePageObject(driver);
    }
    public static LoginPageObject getLoginPage(WebDriver driver){
        return new LoginPageObject(driver);
    }
}
