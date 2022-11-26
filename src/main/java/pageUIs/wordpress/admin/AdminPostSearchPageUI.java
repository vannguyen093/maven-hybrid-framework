package pageUIs.wordpress.admin;

public class AdminPostSearchPageUI {
    public static final String ADD_NEW_BUTTON = "css=a.page-title-action";
    public static final String SEARCH_TEXTBOX = "css=input#post-search-input";
    public static final String SEARCH_BUTTON = "css=input#search-submit";
    public static final String TABLE_HEADER_INDEX_BY_HEADER_NAME = "xpath=//table[contains(@class, 'table-view-list posts')]/thead//th[@id='%s']/preceding-sibling::*";
    public static final String TABLE_ROW_VALUE_BY_HEADER_INDEX = "xpath=//table[contains(@class, 'table-view-list posts')]/tbody/tr/*[%s]//a[text()='%s']";
    public static final String POST_DETAIL_BY_TITLE_NAME = "xpath=//table[contains(@class, 'table-view-list posts')]/tbody/tr//a[@class='row-title' and text()='%s']";
    public static final String POST_CHECKBOX_BY_TITLE_NAME = "xpath=//table[contains(@class, 'table-view-list posts')]/tbody/tr//label[contains(text(), '%s')]/following-sibling::input";
    public static final String APPLY_BUTTON = "xpath=//div[@class='tablenav top']//input[@value='Apply']";
    public static final String POST_ACTION_DROPDOW = "css=select#bulk-action-selector-top";
    public static final String NO_POSTS_FOUND_MESSAGE = "xpath=//tbody//td[text()='No posts found.']";
    public static final String DELETED_SUCCESS_MESSAGE = "xpath=//div[@id='message']/p[contains(text(),'%s')]";
}
