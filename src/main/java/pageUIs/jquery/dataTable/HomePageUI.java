package pageUIs.jquery.dataTable;

public class HomePageUI {
    public static final String PAGING_PAGE_BY_NUMBER = "xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
    public static final String PAGE_NUMBER_ACTIVED = "xpath=//li[@class='qgrd-pagination-page']/a[@class='qgrd-pagination-page-link active' and text()='%s']";
    public static final String FILTER_TEXTBOX = "xpath=//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
    public static final String TOTAL_PAGING = "css=ul.qgrd-pagination-ul>li";
    public static final String TOTAL_PAGING_INDEX = "xpath=//ul[@class='qgrd-pagination-ul']/li[%s]/a";
    public static final String ALL_ROW_EACH_PAGE = "xpath=//tbody/tr";
    public static final String COLUMN_INDEX_BY_NAME = "xpath=//tr/td[text()='%s']/preceding-sibling::td";
    public static final String ROW_TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]/input";
    public static final String DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]/select";
    public static final String CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]/input[@type='checkbox']";
    public static final String BUTTON_BY_ROW_NUMBER = "xpath=//tbody/tr[%s]//button[@title='%s']";
    public static final String LOAD_DEMO_BUTTON = "css=button#btnLoad";
}
