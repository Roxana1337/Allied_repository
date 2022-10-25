package CRA.cucumber.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class CRARegistrationPage {
    @FindBy(xpath = "//*[@id=\"username\"]")
    private WebElement regPageUsername;
    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement regPagePassword;
    @FindBy(xpath = "//*[@id=\"register\"]")
    private WebElement registerButton;

    @FindBy(xpath = "//*[. = 'Registration failed!']")
    private WebElement registrationFailedMessage;
    @FindBy(xpath = "//*[@id=\"login\"]")
    private WebElement loginButton;
//    @FindBy(xpath = "")

    public CRARegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void usernameBoxPress() {
        regPageUsername.click();
    }
    public void passwordBoxPress() {
        regPagePassword.click();
    }

    public void enterValidUsername(String validUsername) {
        regPageUsername.clear();
        regPageUsername.sendKeys(validUsername);
    }

    public void enterValidPassword(String validPassword) {
        regPagePassword.clear();
        regPagePassword.sendKeys(validPassword);
    }

    public void registerButton() {
        registerButton.click();
    }


    public boolean registrationFailedDisplayed() {
        return registrationFailedMessage.isDisplayed();
    }

    public boolean isUsernameBoxDisplayed() {
        return regPageUsername.isDisplayed();
    }

    public void loginButtonPress() {
        loginButton.click();
    }

    public String userGenerator() {
        final String lowercase = "abcdefghijklmnopqrstuvwxyz";
        final String uppercase = lowercase.toUpperCase();
        final String number = "1234567890";
        final String allChars = lowercase + uppercase + number;
        int rightLimit = allChars.length();
        int targetStringLength = 20;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for(int i = 0; i < targetStringLength; i++) {
            int randomUser = random.nextInt(rightLimit);
            buffer.append(allChars.charAt(randomUser));
        }
        String generatedUser = buffer.toString();
        return generatedUser;
    }

}
