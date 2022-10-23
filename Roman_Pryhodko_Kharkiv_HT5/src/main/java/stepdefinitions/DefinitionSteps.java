package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 90;
     
    WebDriver driver;
    
    HomePage homePage;
    LoginPage loginPage;
    SellerPage sellerPage;
    SearchResultPage searchResultPage;
    ProductPage productPage;
    CartPage cartPage;
    SavedPage savedPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
        homePage = pageFactoryManager.getHomePage();
        loginPage = pageFactoryManager.getLoginPage();
        savedPage = pageFactoryManager.getSavedPage();
        sellerPage = pageFactoryManager.getSellerPage();
        cartPage = pageFactoryManager.getCartPage();
        searchResultPage = pageFactoryManager.getSearchResultPage();
        productPage = pageFactoryManager.getProductPage();
    }

    @After
    public void tearDown() { driver.quit(); }

    @And("User logs in")
    public void userLoggedIntoAccount() {
        homePage.clickOnLoginButton();
        loginPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        loginPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        loginPage.enterEmail("pomahic@gmail.com");
        loginPage.clickOnContinueButton();
        loginPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, loginPage.getPasswordInput());
        loginPage.enterPassword("seleniumTestPass123");
        loginPage.clickOnSignInButton();
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage.openHomePage(url);
    }

    @And("User checks log in button visibility")
    public void userChecksLogInButtonVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.isLogInVisible();
    }

    @And("User clicks on log in button")
    public void userClicksOnLogInButton() {
        homePage.clickOnLoginButton();
        loginPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        loginPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
    }

    @And("User enters {string} and {string}")
    public void userEntersEmailAndPassword(final String email, final String password) {
        loginPage.enterEmail(email);
        loginPage.clickOnContinueButton();
        loginPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, loginPage.getPasswordInput());
        loginPage.enterPassword(password);
    }

    @And("User clicks on sign in button")
    public void userClicksOnSignInButton() {
        loginPage.clickOnSignInButton();
    }

    @And("User logs into his account")
    public void userLogsIntoHisAccount() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getSearchButton());

    }

    @And("User checks search field visibility")
    public void userChecksSearchFieldVisibility() {
        homePage.isSearchFieldVisible();
    }

    @And("User makes search by keyword {string}")
    public void userMakesSearchByKeywordKeyword(final String keyword) {
        homePage.enterTextToSearchField(keyword);
    }

    @And("User clicks search button")
    public void userClicksSearchButton() {
        homePage.clickOnSearchButton();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
    }

    @And("User clicks wish list on first product")
    public void userClicksWishListOnFirstProduct() {
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        searchResultPage.clickWishListOnFirstProduct();
        searchResultPage.waitASecond();
        homePage.refresh();
    }

    @And("User checks that amount of products in wish list are {string}")
    public void userChecksAmountOfProductsInWishList(final String amount) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.clickOnWishListButton();
        homePage.refresh();
        searchResultPage.clickWishListOnFirstProduct();
        searchResultPage.waitASecond();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.clickOnWishListButton();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.waitASecond();
        assertEquals(amount, String.valueOf(homePage.getAmountOfProductsInWishList()));
    }

    @And("User enters {string}")
    public void userEntersEmail(final String email) {
        loginPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        loginPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        loginPage.enterEmail(email);
    }

    @And("User clicks on continue button")
    public void userClicksOnContinueButton() {
        loginPage.clickOnContinueButton();
    }

    @And("User sees an error message")
    public void userSeesAnErrorMessage() {
        loginPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, loginPage.getErrorMessage());
        assertTrue(loginPage.isErrorMessageVisible());
    }

    @And("User clicks on first product")
    public void userClicksOnFirstProduct() {
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        searchResultPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultPage.getFirstProduct());
        searchResultPage.clickOnFirstProduct();
        searchResultPage.switchToOpenedTab();
    }

    @And("User clicks Add to cart button")
    public void userClicksAddToCartButton() {
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getAddToCartButton());
        productPage.clickOnAddToCartButton();
    }

    @And("User clicks on Cart button")
    public void userClicksOnCartButton() {
        homePage.clickOnCartButton();
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
    }

    @And("User checks that amount of products in cart are {string}")
    public void userChecksAmountOfProductsInCart(final String amount) {
        assertEquals(amount, String.valueOf(cartPage.amountOfProductsInCart()));
    }

    @And("User removes product from cart")
    public void userRemovesProductFromCart() {
        cartPage.clickOnRemoveButton();
    }

    @And("User clicks on Brand filter checkbox")
    public void userClicksOnFilterCheckbox() {
        searchResultPage.clickOnFilterCheckBox();
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
    }

    @And("User checks that this product matches the filter")
    public void userChecksProductMatchesTheFilter() {
        assertEquals("Clarks", productPage.getBrandOfProduct().getText());
    }

    @And("User clicks on Save this seller button")
    public void userClicksSaveThisSeller() {
        productPage.clickSaveThisSellerButton();
    }

    @And("User clicks on Saved button")
    public void userClicksOnSavedButton() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.clickOnSavedButton();
        savedPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        savedPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
    }

    @And("User checks that seller added")
    public void userChecksThatSellerAdded() {
        savedPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        savedPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        savedPage.isSellersButtonVisible();
    }

    @And("User selects a saved merchant they want to remove")
    public void userSelectsASavedMerchantTheyWantToRemove() {
        savedPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        savedPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        savedPage.clickOnSellersButton();
        savedPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, savedPage.getSeller());
        savedPage.clickOnSeller();
        savedPage.switchToOpenedTab();
        sellerPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        sellerPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
    }

    @And("User clicks on remove button")
    public void userClicksOnRemoveButton() {
        sellerPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        sellerPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        sellerPage.waitASecond();
        sellerPage.clickOnRemoveSellerButton();
    }

    @And("User checks that seller removed")
    public void userChecksThatSellerRemoved() {
        savedPage.isEmptySavedMessageFieldVisible();
    }

    @And("User clicks on customize button")
    public void userClicksOnCustomizeButton() {
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        searchResultPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultPage.getFilterSettings());
        searchResultPage.clickOnFilterSettings();
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        searchResultPage.clickOnCustomizeButton();
    }

    @And("User clicks on item number option")
    public void userClicksOnItemNumberOption() {
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        searchResultPage.waitASecond();
        searchResultPage.clickOnItemNumberButton();
    }

    @And("User apply settings")
    public void userApplySettings() {
        searchResultPage.clickOnApplySettingsButton();
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
    }

    @And("User checks that products have info about item number")
    public void userChecksProductsItemNumber() {
        searchResultPage.isItemNumberInfoVisible();
    }

    @And("User does not find anything")
    public void userDoesNotFindAnything() {
        assertTrue(searchResultPage.isNoMatchesMessageFieldVisible());
    }

    @And("User clicks auction button")
    public void userClicksAuctionButton() {
        searchResultPage.clickOnAuctionButton();
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
    }

    @And("User can enjoy auction")
    public void userCanEnjoyAuction() {
        assertTrue(productPage.isPlaceBidButtonVisible());
    }
}
