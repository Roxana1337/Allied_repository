package my.first.selenium.project.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    @FindBy(id = "username")
    private WebElement userNameTextBox;
    @FindBy(id = "password")
    private WebElement passwordTextBox;
    @FindBy(id = "register")
    private WebElement registerButton;
    @FindBy(id = "login")
    private WebElement loginButton;
    @FindBy(id = "limitedVersionLogin")
    private WebElement limitedVersionLoginButton;

    @FindBy(id = "environmentname")
    private WebElement firstPageUsername;
    @FindBy(id = "environmentpassword")
    private WebElement firstPagePassword;
    @FindBy(id = "envlogin")
    private WebElement firstPageLoginButton;



    public RegistrationPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public void enterFirstPageUsername(String environmentname) {
        firstPageUsername.clear();
        firstPageUsername.sendKeys(environmentname);
    }

    public void enterFirstPagePassword(String environmentpassword) {
        firstPagePassword.clear();
        firstPagePassword.sendKeys(environmentpassword);
    }

    public void firstPageLogin() {
        firstPageLoginButton.click();
    }
    public void enterUsername(String username) {
        userNameTextBox.clear();
        userNameTextBox.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordTextBox.clear();
        passwordTextBox.sendKeys(password);
    }

    public void register() {
        registerButton.click();
    }

    public void login() {
        loginButton.click();
    }

    public void setLimitedVersionLogin() {
        limitedVersionLoginButton.click();
    }

}

//Registration page main:
//        RegistrationPage registrationPage = new RegistrationPage(driver);
//
//        registrationPage.enterFirstPageUsername("qatraining");
//        registrationPage.enterFirstPagePassword("0Gx5");
//        registrationPage.firstPageLogin();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
//        registrationPage.enterUsername("User45");
//        registrationPage.enterPassword("Password45");
//        registrationPage.register();
