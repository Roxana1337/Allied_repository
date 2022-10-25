package my.first.selenium.project.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Demoqa {
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[1]/div[2]/input")
    private WebElement firstNameTextBox;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[1]/div[4]/input")
    private WebElement lastNameTextBox;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[2]/input")
    private WebElement userEmailTextBox;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[4]/div[2]/input")
    private WebElement userPhoneNumber;

    @FindBy(id = "dateOfBirthInput")
    private WebElement userDateOfBirth;

    @FindBy(xpath = "//*[@id=\"subjectsInput\"]")
    private WebElement subjectTextBox;

    @FindBy(className = "form-control-file")
    private WebElement chooseFile;

    @FindBy(id = "currentAddress")
    private WebElement userAddress;

    @FindBy(xpath = "//*[@id=\"state\"]/div/div[1]/div[1]")
    private WebElement selectStateDropdown;

    @FindBy(xpath = "//*[@id=\"react-select-3-input\"]")
    private WebElement selectStateName;

    @FindBy(xpath = "//*[@id=\"city\"]/div/div[1]/div[1]")
    private WebElement selectCityDropdown;

    @FindBy(xpath = "//*[@id=\"react-select-4-input\"]")
    private WebElement selectCityName;

    @FindBy(xpath = "//*[@id=\"submit\"]")
    private WebElement submitButton;

    public Demoqa(WebDriver webdriver) {
        PageFactory.initElements(webdriver, this);
    }

    public void enterFirstName(String firstName) {
        firstNameTextBox.clear();
        firstNameTextBox.sendKeys(firstName);

    }

    public void enterLastName(String lastName) {
        lastNameTextBox.clear();
        lastNameTextBox.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        userEmailTextBox.clear();
        userEmailTextBox.sendKeys(email);
    }

    public void enterPhoneNumber(String phoneNumber) {
        userPhoneNumber.clear();
        userPhoneNumber.sendKeys(phoneNumber);
    }

    public void enterDateOFBirth() {
        userDateOfBirth.click();

    }

    public void enterSubject(String subject) {
        subjectTextBox.click();
        subjectTextBox.sendKeys(subject);
        subjectTextBox.sendKeys(Keys.RETURN);
    }

    public void enterPicture(String picturePath) {
        chooseFile.sendKeys(picturePath);
    }

    public void enterAddress(String address) {
        userAddress.click();
        userAddress.sendKeys(address);

    }

    public void selectState() {
        selectStateDropdown.click();
    }

    public void setSelectStateName(String stateName1) {
        selectStateName.clear();
        selectStateName.sendKeys(stateName1);
        selectStateName.sendKeys(Keys.ENTER);
    }

    public void selectCity() {
        selectCityDropdown.click();

    }

    public void selectCityName(String cityName) {
        selectCityName.clear();
        selectCityName.sendKeys(cityName);
        selectCityName.sendKeys(Keys.ENTER);
    }

    public void pressSubmitButton() {
        submitButton.sendKeys(Keys.RETURN);
    }



}
