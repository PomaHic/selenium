package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='userid']")
    private WebElement emailInput;

    @FindBy(xpath = "//button[@id='signin-continue-btn']")
    private WebElement continueButton;

    @FindBy(xpath = "//input[@id='pass']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@id='sgnBt']")
    private WebElement signInButton;

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    @FindBy(xpath = "//p[@id='errormsg']")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void clickOnContinueButton() { continueButton.click(); }

    public void enterPassword(String password) { passwordInput.sendKeys(password); }

    public void clickOnSignInButton() { signInButton.click(); }

    public WebElement getPasswordInput() { return passwordInput; }

    public boolean isErrorMessageVisible() { return errorMessage.isDisplayed(); }
}
