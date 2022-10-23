package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(xpath = "//div[@class='cart-bucket']")
    private List<WebElement> productsInCart;

    @FindBy(xpath = "//button/span/span[contains(text(),'Remove')]/../..")
    private WebElement removeButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnRemoveButton() { removeButton.click(); }

    public int amountOfProductsInCart() { return productsInCart.size(); }
}
