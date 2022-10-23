package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public SavedPage getSavedPage() { return new SavedPage(driver); }

    public SellerPage getSellerPage() { return  new SellerPage(driver); }

    public HomePage getHomePage() { return new HomePage(driver); }

    public CartPage getCartPage() { return  new CartPage(driver); }

    public ProfilePage getProfilePage() { return new ProfilePage(driver); }

    public LoginPage getLoginPage() { return new LoginPage(driver); }

    public ProductPage getProductPage() { return new ProductPage(driver); }

    public SearchResultPage getSearchResultPage() { return new SearchResultPage(driver); }

}
