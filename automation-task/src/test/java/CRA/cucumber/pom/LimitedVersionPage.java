package CRA.cucumber.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LimitedVersionPage {
    public LimitedVersionPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//button[contains(@onclick, 'limited')]")
    private WebElement limitedVersionPageButton;
    @FindBy(xpath = "//*[@id=\"signUpButton\"]")
    private WebElement signUpButton;
    public void limitedVersionButton() {
        limitedVersionPageButton.click();
    }
    public boolean signUpDisplayed() {
        return signUpButton.isDisplayed();
    }
    public void signUpButtonPush() {
        signUpButton.click();
    }
}
