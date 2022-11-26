package pageObjects.jquery.dataTable;

import commons.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.jquery.dataTable.HomePageUI;

import java.util.ArrayList;
import java.util.List;

public class HomePageObject extends BasePage {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void openPagingByPageNumber(String pageNumber) {
        waitForElementClickable(driver, HomePageUI.PAGING_PAGE_BY_NUMBER, pageNumber);
        clickToElement(driver, HomePageUI.PAGING_PAGE_BY_NUMBER, pageNumber);
    }

    public void inputToFilterTextboxByLabel(String filterLabel, String value) {
        waitForElementVisible(driver, HomePageUI.FILTER_TEXTBOX, filterLabel);
        sendkeysToElement(driver, HomePageUI.FILTER_TEXTBOX, value, filterLabel);
        pressKeyToElement(driver, HomePageUI.FILTER_TEXTBOX, Keys.ENTER, filterLabel);
    }

    public boolean isPageNumberActived(String pageNumber) {
        waitForElementVisible(driver, HomePageUI.FILTER_TEXTBOX, pageNumber);
        return isElementDisplayed(driver, HomePageUI.FILTER_TEXTBOX, pageNumber);
    }

    public List<String> getValueEachRowAtAllPage() {
        int totalPages = getElementSize(driver, HomePageUI.TOTAL_PAGING);

        List<String> allRowValuesAllPage = new ArrayList<String>();
        for (int index = 1; index <= totalPages; index++) {
            clickToElement(driver, HomePageUI.TOTAL_PAGING_INDEX, String.valueOf(index));

            List<WebElement> allRowEachPage = getListWebElements(driver, HomePageUI.ALL_ROW_EACH_PAGE);
            for (WebElement eachrow : allRowEachPage) {
                allRowValuesAllPage.add(eachrow.getText());
            }
        }
        return allRowValuesAllPage;
    }

    public void enterToTextboxAtRowNumberByColumnName(String columnName, String rowNumber, String value) {
        int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;

        waitForElementVisible(driver, HomePageUI.ROW_TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
        sendkeysToElement(driver, HomePageUI.ROW_TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, value, rowNumber, String.valueOf(columnIndex));
    }

    public void selectDropdownByColumnNameAtRowNumber(String columnName, String rowNumber, String value) {
        int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;

        waitForElementClickable(driver, HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
        selectItemInDefaultDropdown(driver, HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, value, rowNumber, String.valueOf(columnIndex));
    }

    public void clickToLoadDemoButton() {
        waitForElementClickable(driver, HomePageUI.LOAD_DEMO_BUTTON);
        clickToElement(driver, HomePageUI.LOAD_DEMO_BUTTON);
    }

    public void checkToCheckBoxByColumnNameAtRowNumber(String columnName, String rowNumber) {
        int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;

        waitForElementClickable(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
        checkToDefaultCheckboxRadio(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
    }

    public void uncheckToCheckBoxByColumnNameAtRowNumber(String columnName, String rowNumber) {
        int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;

        waitForElementClickable(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
        uncheckToDefaultCheckboxRadio(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
    }

    public void clickToButtonByRowNumber(String rowNumber, String buttonName) {
        waitForElementClickable(driver, HomePageUI.BUTTON_BY_ROW_NUMBER, rowNumber, buttonName);
        clickToElement(driver, HomePageUI.BUTTON_BY_ROW_NUMBER, rowNumber, buttonName);
    }
}
