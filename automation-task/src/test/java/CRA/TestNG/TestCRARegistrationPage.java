package CRA.TestNG;


import CRA.cucumber.pom.CRARegistrationPage;
import CRA.cucumber.pom.HomePage;
import CRA.cucumber.pom.LimitedVersionPage;
import CRA.cucumber.pom.LoginCredentialsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.time.Duration;

public class TestCRARegistrationPage {
    private WebDriver driver;

    CRARegistrationPage craRegistrationPage;
    LoginCredentialsPage loginCredentialsPage;
    LimitedVersionPage limitedVersionPage;
    HomePage homePage;


    @BeforeMethod
    public void firstPageLogin() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://cra.alliedtesting.md/registration");
        craRegistrationPage = new CRARegistrationPage(driver);
        loginCredentialsPage = new LoginCredentialsPage(driver);
        limitedVersionPage = new LimitedVersionPage(driver);
        homePage = new HomePage(driver);
        loginCredentialsPage.enterUsername("qatraining");
        loginCredentialsPage.enterPassword("0Gx5");
        loginCredentialsPage.pressLogin();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
    }

    @Test
    public void validUserValidPassword() {
        craRegistrationPage.enterValidUsername("User0012334");
        craRegistrationPage.enterValidPassword("Password1");
        craRegistrationPage.registerButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(homePage.logOutButtonDisplayed());
    }

    @DataProvider(name = "InvalidUsernameDataProvider")
    public Object[][] getInvalidUsernames() {
        return new Object[][]{
                {"Us0", "Password1"},
                {"user970", "Password1"},
                {"USER970", "Password1"},
                {"USERSVSDBD", "Password1"},
                {"", "Password1"},
                {"Ușer9700", "Password1"}
        };
    }

    @Test(dataProvider = "InvalidUsernameDataProvider")
    public void invalidUsernameTest(String invalidUsername, String validPassword) {
        craRegistrationPage.enterValidUsername(invalidUsername);
        craRegistrationPage.enterValidPassword(validPassword);
        craRegistrationPage.registerButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(craRegistrationPage.registrationFailedDisplayed());
    }

    @DataProvider(name = "InvalidPasswordDataProvider")
    public Object[][] getInvalidPasswords() {
        return new Object[][]{
                {"User181197", "Pass1"},
                {"User181197", "password1"},
                {"User181197", "PASSWORD1"},
                {"User181197", "Password"},
                {"User181197", ""},
                {"User181197", "Pașșword1"}
        };
    }

    @Test(dataProvider = "InvalidPasswordDataProvider")
    public void invalidPasswordTest(String validUsername, String invalidPassword) {
        craRegistrationPage.enterValidUsername(validUsername);
        craRegistrationPage.enterValidPassword(invalidPassword);
        craRegistrationPage.registerButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(craRegistrationPage.registrationFailedDisplayed());
    }

    @Test
    public void sameUsernameAndPassword() {
        craRegistrationPage.enterValidUsername("Username00000000");
        craRegistrationPage.enterValidPassword("Password1");
        craRegistrationPage.registerButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(craRegistrationPage.registrationFailedDisplayed());
    }

    @Test
    public void limitedVersionURL() {
        limitedVersionPage.limitedVersionButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(limitedVersionPage.signUpDisplayed());
    }



}
