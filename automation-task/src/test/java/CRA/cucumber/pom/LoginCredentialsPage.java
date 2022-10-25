package CRA.cucumber.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginCredentialsPage {
    @FindBy(xpath = "//*[@id=\"environmentname\"]")
    private WebElement firstPageUsername;
    @FindBy(xpath = "//*[@id=\"environmentpassword\"]")
    private WebElement firstPagePassword;
    @FindBy(xpath = "//*[@id=\"envlogin\"]")
    private WebElement loginButton;

    public LoginCredentialsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        firstPageUsername.clear();
        firstPageUsername.sendKeys(username);
    }

    public void enterPassword(String password) {
        firstPagePassword.clear();
        firstPagePassword.sendKeys(password);
    }

    public void pressLogin() {
        loginButton.click();
    }
}
