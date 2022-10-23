package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(id = "isCartBtn_btn")
    private WebElement addToCartButton;

    @FindBy(xpath = "//span[text()='Brand:']/../../../../*/*/*/*/*/span")
    private WebElement brandOfProduct;

    @FindBy(xpath = "//div[text()='Save this seller']/..")
    private WebElement saveThisSellerButton;

    @FindBy(xpath = "//*[contains(text(),'Place bid')]")
    private WebElement placeBidButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddToCartButton() { addToCartButton.click(); }

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    public WebElement getBrandOfProduct() {
        return brandOfProduct;
    }

    public void clickSaveThisSellerButton() { saveThisSellerButton.click(); }

    public boolean isPlaceBidButtonVisible() { return placeBidButton.isDisplayed(); }
}
