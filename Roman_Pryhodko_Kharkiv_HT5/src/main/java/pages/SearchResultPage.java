package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage{

    @FindBy(xpath = "//span[@class='s-item__watchheart-icon']")
    private List<WebElement> wishListIcons;

    @FindBy(xpath = "//a[@class='s-item__link']")
    private List<WebElement> productsList;

    @FindBy(xpath = "//button[contains(@aria-label,\"Listing options selector\")]")
    private WebElement filterSettings;

    @FindBy(xpath = "//*[text()='Customize']/..")
    private WebElement customizeButton;

    @FindBy(xpath = "//input[@aria-label='Clarks']")
    private WebElement filterCheckBox;

    @FindBy(xpath = "//*[@id='cust_fcie-1']")
    private WebElement itemNumberButton;

    @FindBy(xpath = "//*[contains(text(),'Item:')]")
    private List<WebElement> itemNumberInfoLabel;

    @FindBy(xpath = "//*[contains(text(),'Apply changes')]")
    private WebElement applySettingsButton;

    @FindBy(xpath = "//*[text()='Auction']/parent::a")
    private WebElement auctionButton;

    @FindBy(xpath = "//span[contains(text(),'Not finding')]")
    private WebElement interferingMessageField;

    @FindBy(xpath = "//h3[contains(text(),'No exact match')]")
    private WebElement noMatchesMessageField;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public void clickWishListOnFirstProduct() {
        wishListIcons.get(0).click();
    }

    public void clickOnFirstProduct() { productsList.get(1).click(); }

    public WebElement getFirstProduct() { return productsList.get(1); }

    public void clickOnFilterSettings() { filterSettings.click(); }

    public WebElement getFilterSettings() {
        return filterSettings;
    }

    public void clickOnCustomizeButton() { customizeButton.click(); }

    public void clickOnItemNumberButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", itemNumberButton);
    }

    public void clickOnApplySettingsButton() { applySettingsButton.click(); }

    public boolean isItemNumberInfoVisible() { return itemNumberInfoLabel.get(0).isDisplayed(); }

    public void clickOnFilterCheckBox() { filterCheckBox.click(); }

    public boolean isNoMatchesMessageFieldVisible() { return noMatchesMessageField.isDisplayed(); }

    public void clickOnAuctionButton() { auctionButton.click(); }
}
