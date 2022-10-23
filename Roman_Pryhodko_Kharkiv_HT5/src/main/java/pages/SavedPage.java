package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SavedPage extends BasePage {

    @FindBy(xpath = "//*[text()=' Seller']/..")
    private WebElement sellersButton;

    @FindBy(xpath = "//*[@id=\"followPeople\"]/div/div/div[2]/ul/li[1]/a")
    private WebElement seller;

    @FindBy(xpath = "//*[contains(text(),'Your feed is currently empty')]")
    private WebElement emptySavedMessageField;

    public SavedPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnSellersButton() { sellersButton.click(); }

    public boolean isSellersButtonVisible() { return sellersButton.isDisplayed(); }

    public void clickOnSeller() { seller.click(); }

    public WebElement getSeller() {
        return seller;
    }

    public boolean isEmptySavedMessageFieldVisible() { return emptySavedMessageField.isDisplayed(); }

}
