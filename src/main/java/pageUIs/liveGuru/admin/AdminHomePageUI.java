package pageUIs.liveGuru.admin;

public class AdminHomePageUI {
    public static final String CLOSE_POPUP_BUTTON = "xpath=//div[@id='message-popup-window']//a[@title='close']";
    public static final String HOMEPAGE_TITLE = "xpath=//div[@id='page:main-container']//h3[@class='icon-head head-customer']";

    public static final String PAGING_NAVIGATION_BY_NAME = "xpath=//a[@title='%s']";
    public static final String LOADING_MASK = "xpath=//div[@id='loading-mask']";
    public static final String PAGING_TEXT_PAGE = "xpath=//input[@class='input-text page']";
    public static final String SELECT_UNSELECT_BY_NAME = "xpath=//div[@id='customerGrid_massaction']//tbody/tr/td/a[text()='%s']";
    public static final String DROPDOWN_BY_NAME = "xpath=//select[@id='customerGrid_massaction-select']";
    public static final String SUBMIT_BUTTON = "xpath=//button[@title='Submit']";
    public static final String FILTER_TEXTBOX = "xpath=//input[@name='%s']";
    public static final String CUSTOMER_CHECKBOX = "xpath=//td[contains(text(),'%s')]/preceding-sibling::td/input";
    public static final String CUSTOMER_TEXT_AT_ROW = "xpath=//tbody/tr/td[contains(text(),'%s')]/following-sibling::td[contains(text(),'%s')]";
    public static final String NUMBER_ITEMS_SELECTED = "xpath=//div[@id='customerGrid_massaction']//strong";
    public static final String DELETE_SUCCESS_MESSAGE = "xpath=//div[@id='messages']//span";
}
