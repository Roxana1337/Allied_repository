package CRA.cucumber.stepDefinitions;

import CRA.cucumber.pom.CRARegistrationPage;
import CRA.cucumber.pom.HomePage;
import CRA.cucumber.pom.LimitedVersionPage;
import CRA.cucumber.pom.LoginCredentialsPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class FirstPageLoginSD {

    WebDriver driver;
    CRARegistrationPage craRegistrationPage;
    LoginCredentialsPage loginCredentialsPage;
    LimitedVersionPage limitedVersionPage;
    HomePage homePage;
    String myGeneratedUser;

    @Before
    public void firstPageLogin() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://cra.alliedtesting.md/registration");
        craRegistrationPage = new CRARegistrationPage(driver);
        loginCredentialsPage = new LoginCredentialsPage(driver);
        limitedVersionPage = new LimitedVersionPage(driver);
        homePage = new HomePage(driver);
        loginCredentialsPage.enterUsername("qatraining");
        loginCredentialsPage.enterPassword("0Gx5");
        loginCredentialsPage.pressLogin();
        myGeneratedUser = craRegistrationPage.userGenerator();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
    }

    @After
    public void quitDriver() {
        driver.quit();
        driver = null;
    }

    @When("Enter first page username.")
    public void enter_first_page_username() {
        craRegistrationPage.enterValidUsername(craRegistrationPage.userGenerator());
    }

    @And("Enter first page password.")
    public void enter_first_page_password() {
        craRegistrationPage.enterValidPassword("Password1");
    }

    @And("Register button is pressed.")
    public void register_button_is_pressed() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
        craRegistrationPage.registerButton();
    }

    @Then("Home page is opened.")
    public void home_page_is_opened() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
        Assert.assertTrue(homePage.logOutButtonDisplayed());
    }

    @When("^Enter invalid username. ([^\"]*)$")
    public void enter_invalid_username_usernameFirst(String usernameFirst) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
        craRegistrationPage.enterValidUsername(usernameFirst);
    }

    @And("Enter valid password.")
    public void enter_valid_password() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
        craRegistrationPage.enterValidPassword("Password1");
    }


    @Then("Registration error message is displayed.")
    public void registrationErrorMessageIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[. = 'Registration failed!']")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
        Assert.assertTrue(craRegistrationPage.registrationFailedDisplayed());
    }

    @When("Enter valid username.")
    public void enter_valid_username() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
        craRegistrationPage.enterValidUsername(craRegistrationPage.userGenerator());
    }

    @And("^Enter invalid password. ([^\"]*)$")
    public void enter_invalid_password_password2(String invalidPassword) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
        craRegistrationPage.enterValidPassword(invalidPassword);
    }


    @Given("Enter a valid user to be remembered.")
    public void enterAValidUserToBeRemembered() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
        craRegistrationPage.enterValidUsername(myGeneratedUser);
    }

    @And("Enter valid password for this user.")
    public void enterValidPasswordForThisUser() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
        craRegistrationPage.enterValidPassword("Password1");
    }
    @And("Press sign out button.")
    public void pressSignOutButton() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
        homePage.logOutButtonPress();
    }
    @Then("Enter same username.")
    public void enterSameUsername() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
        craRegistrationPage.enterValidUsername(myGeneratedUser);
    }

    @Then("Enter same password.")
    public void enterSamePassword() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
        craRegistrationPage.enterValidPassword("Password1");
    }

    @When("Limited Version button is pressed.")
    public void limitedVersionButtonIsPressed() {
        limitedVersionPage.limitedVersionButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
    }

    @Then("Limited version page is opened.")
    public void limitedVersionPageIsOpened() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
        Assert.assertTrue(limitedVersionPage.signUpDisplayed());
    }

    @And("We can also return to registration page.")
    public void weCanAlsoReturnToRegistrationPage() {
        limitedVersionPage.signUpButtonPush();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
        Assert.assertTrue(craRegistrationPage.isUsernameBoxDisplayed());
    }
}

