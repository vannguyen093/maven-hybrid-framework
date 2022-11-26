package pageObjects.liveGuru.user;

import org.openqa.selenium.WebDriver;
import pageObjects.liveGuru.admin.AdminHomePageObject;
import pageObjects.liveGuru.admin.AdminLoginPageObject;

public class PageGeneratorManager {
    public static UserHomePageObject getHomePage(WebDriver driver){
        return new UserHomePageObject(driver);
    }
    public static UserLoginPageObject getLoginPage(WebDriver driver){
        return new UserLoginPageObject(driver);
    }
    public static RegisterPageObject getRegisterPage(WebDriver driver){
        return new RegisterPageObject(driver);
    }
    public static UserMyDashboardPageObject getMyAccountDashboardPage(WebDriver driver){
        return new UserMyDashboardPageObject(driver);
    }
    public static UserAccountInforPageObject getAccountInforPage(WebDriver driver){
        return new UserAccountInforPageObject(driver);
    }
    public static UserAddressBookPageObject getAddressBookPage(WebDriver driver){
        return new UserAddressBookPageObject(driver);
    }
    public static UserMyOrderPageObject getMyOrdersPage(WebDriver driver){
        return new UserMyOrderPageObject(driver);
    }
    public static UserBillingAgreementsPageObject getBillingAgreementsPage(WebDriver driver){
        return new UserBillingAgreementsPageObject(driver);
    }
    public static AdminLoginPageObject getAdminLoginPage(WebDriver driver){
        return new AdminLoginPageObject(driver);
    }
    public static AdminHomePageObject getAdminHomePage(WebDriver driver){
        return new AdminHomePageObject(driver);
    }
}
