package pageObjects.jquery.uploadFile;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.jquery.uploadFile.HomePageUI;

import java.util.List;

public class HomePageObject extends BasePage {
    private WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }


    public boolean isFileLoadedByName(String fileName) {
        waitForElementVisible(driver, HomePageUI.FILE_NAME_LOADED, fileName);
        return isElementDisplayed(driver, HomePageUI.FILE_NAME_LOADED, fileName);
    }

    public void clickToStartButton() {
        waitForElementClickable(driver, HomePageUI.START_BUTTON);
        List<WebElement> startButtons = getListWebElements(driver, HomePageUI.START_BUTTON);
        for (WebElement startButton : startButtons) {
            startButton.click();
            sleepInSecond(2);
        }
    }

    public boolean isFileUploadedByName(String fileName) {
        waitForElementVisible(driver, HomePageUI.FILE_LINK_UPLOADED, fileName);
        return isElementDisplayed(driver, HomePageUI.FILE_LINK_UPLOADED, fileName);
    }

    public boolean isFileImageUploadedByName(String fileName) {
        waitForElementVisible(driver, HomePageUI.IMG_LINK_UPLOADED, fileName);
        return isImageLoaded(driver, HomePageUI.IMG_LINK_UPLOADED, fileName);
    }
}
