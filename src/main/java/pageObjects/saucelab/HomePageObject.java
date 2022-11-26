package pageObjects.saucelab;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.saucelab.HomePageUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomePageObject extends BasePage {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void selectItemInProductSortDropdown(String itemValue) {
        waitForElementClickable(driver, HomePageUI.PRODUCT_DROPDOWN);
        selectItemInDefaultDropdown(driver, HomePageUI.PRODUCT_DROPDOWN, itemValue);
    }

    public boolean isProductNameSortByAsc() {
        List<String> productUIList = new ArrayList<String>();

        List<WebElement> productNameText = getListWebElements(driver, HomePageUI.PRODUCT_NAME_TEXT);

        for (WebElement productName : productNameText) {
            productUIList.add(productName.getText());
        }

        ArrayList<String> productSortList = new ArrayList<String>();
        for (String product : productUIList) {
            productSortList.add(product);
        }

        Collections.sort(productSortList);

        return productSortList.equals(productUIList);
    }

    public boolean isProductNameSortByDecs() {
        List<String> productUIList = new ArrayList<String>();

        List<WebElement> productNameText = getListWebElements(driver, HomePageUI.PRODUCT_NAME_TEXT);

        for (WebElement productName : productNameText) {
            productUIList.add(productName.getText());
        }

        ArrayList<String> productSortList = new ArrayList<String>();
        for (String product : productUIList) {
            productSortList.add(product);
        }

        Collections.sort(productSortList);
        Collections.reverse(productSortList);

        return productSortList.equals(productUIList);
    }

    public boolean isProductPriceSortByAsc() {
        List<Float> productUIList = new ArrayList<Float>();

        List<WebElement> productPriceText = getListWebElements(driver, HomePageUI.PRODUCT_PRICE_TEXT);

        for (WebElement productPrice : productPriceText) {
            productUIList.add(Float.parseFloat(productPrice.getText().replace("$", "")));
        }

        ArrayList<Float> productSortList = new ArrayList<Float>();
        for (Float product : productUIList) {
            productSortList.add(product);
        }

        Collections.sort(productSortList);

        return productSortList.equals(productUIList);
    }

    public boolean isProductPriceSortByDesc() {
        List<Float> productUIList = new ArrayList<Float>();

        List<WebElement> productPriceText = getListWebElements(driver, HomePageUI.PRODUCT_PRICE_TEXT);

        for (WebElement productPrice : productPriceText) {
            productUIList.add(Float.parseFloat(productPrice.getText().replace("$", "")));
        }

        ArrayList<Float> productSortList = new ArrayList<Float>();
        for (Float product : productUIList) {
            productSortList.add(product);
        }

        Collections.sort(productSortList);
        Collections.reverse(productSortList);

        return productSortList.equals(productUIList);
    }
}
