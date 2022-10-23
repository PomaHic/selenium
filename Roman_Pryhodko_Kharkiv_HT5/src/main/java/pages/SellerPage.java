package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SellerPage extends BasePage {

    @FindBy(xpath = "//*[text()='Saved Seller']/..")
    private List<WebElement> removeSellerButton;

    public SellerPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnRemoveSellerButton() { removeSellerButton.get(1).click(); }
}
