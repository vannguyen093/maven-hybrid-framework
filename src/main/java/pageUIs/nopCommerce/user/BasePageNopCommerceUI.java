package pageUIs.nopCommerce.user;

public class BasePageNopCommerceUI {
    public static final String CUSTOMER_INFO_LINK = "xpath=//a[text()='Customer info']";
    public static final String ADDRESSES_LINK = "xpath=//a[text()='Addresses']";
    public static final String ORDERS_LINK = "xpath=//a[text()='Orders']";
    public static final String DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA = "xpath=//a[text()='%s']";
    public static final String LOGOUT_LINK = "xpath=//a[@class='ico-logout']";
    public static final String DYNAMIC_TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
    public static final String DYNAMIC_BUTTON_BY_TEXT = "xpath=//button[text()='%s']";
    public static final String DYNAMIC_DROPDOWN_BY_NAME = "xpath=//select[@name='%s']";
    public static final String DYNAMIC_RADIO_BUTTON_BY_LABEL_TEXT = "xpath=//label[text()='%s']/preceding-sibling::input";
    public static final String DYNAMIC_CHECKBOX_BY_LABEL_TEXT = "xpath=//label[contains(text(),'%s')]/following-sibling::input";
}
