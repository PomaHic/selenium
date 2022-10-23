package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//span[text()='Hi! ']/a[contains(@href,'signin')]")
    private WebElement loginButton;

    @FindBy(xpath = "//input[contains(@aria-label,'Search for')]")
    private WebElement searchInput;

    @FindBy(xpath = "//input[@value = 'Search']")
    private WebElement searchButton;

    @FindBy(xpath = "//a[text()='Saved']")
    private WebElement savedButton;

    @FindBy(xpath = "//a[contains(@aria-label,'cart')]")
    private WebElement cartButton;

    @FindBy(xpath = "//a[contains(@title,'Watchlist')]")
    private WebElement watchListButton;

    @FindBy(xpath = "//ul[@class='carousel__list']/li[contains(@class,'rvi__item')]")
    private List<WebElement> productsInWatchList;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) { driver.get(url); }

    public void enterTextToSearchField(String request) { searchInput.sendKeys(request); }

    public void clickOnSearchButton() { searchButton.click(); }

    public WebElement getSearchButton() { return searchButton; }

    public boolean isLogInVisible() { return loginButton.isDisplayed(); }

    public void clickOnLoginButton() { loginButton.click(); }

    public void clickOnSavedButton() { savedButton.click(); }

    public void clickOnCartButton() { cartButton.click(); }

    public boolean isSearchFieldVisible() { return searchInput.isDisplayed(); }

    public void clickOnWishListButton() { watchListButton.click(); }

    public int getAmountOfProductsInWishList() { return productsInWatchList.size(); }
}
