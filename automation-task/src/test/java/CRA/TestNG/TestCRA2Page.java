package CRA.TestNG;

import CRA.cucumber.pom.CRARegistrationPage;
import CRA.cucumber.pom.HomePage;
import CRA.cucumber.pom.LimitedVersionPage;
import CRA.cucumber.pom.LoginCredentialsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class TestCRA2Page {
    private WebDriver driver;

    CRARegistrationPage craRegistrationPage;
    LoginCredentialsPage loginCredentialsPage;
    LimitedVersionPage limitedVersionPage;
    HomePage homePage;
    WebDriverWait wait;
    String existingUsername = "User123456";
    String existingPassword = "Password123456";
    String badRequest400firstPart = "400 Bad Request. Reason: '";
    String badRequest400secondPartOld = "' date is too old, the oldest available currency date is 01.01.1994";
    String badRequest400secondPartFuture = "' future date is not valid";


    @BeforeMethod
    public void firstPageLogin() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://cra.alliedtesting.md/registration");
        wait = new WebDriverWait(driver, Duration.ofSeconds(3L));
        craRegistrationPage = new CRARegistrationPage(driver);
        loginCredentialsPage = new LoginCredentialsPage(driver);
        limitedVersionPage = new LimitedVersionPage(driver);
        homePage = new HomePage(driver);
        loginCredentialsPage.enterUsername("qatraining");
        loginCredentialsPage.enterPassword("0Gx5");
        loginCredentialsPage.pressLogin();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
        craRegistrationPage.enterValidUsername("User123456");
        craRegistrationPage.enterValidPassword("Password123456");
        craRegistrationPage.loginButtonPress();
    }

//    @AfterMethod
//    public void quitDriver() {
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
//        driver.quit();
//    }

//    @Test
//    public void waitingTimeNegative() {
//        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(10L));
//        homePage.fromDateCurrencyFill("10.10.2022");
//        homePage.toDateCurrencyFill("18.10.2022");
//        homePage.currencyRatesButtonPress();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
//        Assert.assertTrue(homePage.setCurrencyRatesAlertDisplayed());
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
//        homePage.fromDateCurrencyHistoryFill("10.10.2022");
//        homePage.toDateCurrencyHistoryFill("18.10.2022");
//        homePage.currencyHistoryButtonPress();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
//        Assert.assertTrue(homePage.setCurrencyRatesAlertDisplayed());
//
//        homePage.logOutButtonPress();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
//        craRegistrationPage.enterValidUsername(existingUsername);
//        craRegistrationPage.enterValidPassword(existingPassword);
//        craRegistrationPage.loginButtonPress();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
//        homePage.fromDateCurrencyFill("10.10.2022");
//        homePage.toDateCurrencyFill("18.10.2022");
//        Assert.assertTrue(homePage.currenciesListShow());
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
//        homePage.fromDateCurrencyHistoryFill("10.10.2022");
//        homePage.toDateCurrencyHistoryFill("18.10.2022");
//        homePage.currencyHistoryButtonPress();
//        Assert.assertTrue(homePage.currenciesHistoryChartShow());
//
//    }
//
//    @Test
//    public void waitingTimePositive() {
//        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(9L));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30L));
//        homePage.fromDateCurrencyFill("10.10.2022");
//        homePage.toDateCurrencyFill("18.10.2022");
//        homePage.currencyRatesButtonPress();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
//        Assert.assertTrue(homePage.currenciesListShow());
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
//
//        homePage.fromDateCurrencyHistoryFill("10.10.2022");
//        homePage.toDateCurrencyHistoryFill("18.10.2022");
//        homePage.currencyHistoryButtonPress();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
//        Assert.assertTrue(homePage.currenciesHistoryChartShow());
//    }

    @Test
    public void currencyNominal() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
        homePage.charCodeBoxFill("HUF");
        homePage.currencyRatesButtonPress();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
        Assert.assertTrue(homePage.currenciesListShow());


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
        WebElement getCurrencyElementHUF = driver.findElement(By.xpath("//*[@id=\"currenciesList\"]/div/button"));
        String getCurrencyStringHUF = getCurrencyElementHUF.getText();
        String currencyValueStringHUF = getCurrencyStringHUF.substring(getCurrencyStringHUF.length()-6);
        double currencyValueDoubleHUF = Double.parseDouble(currencyValueStringHUF);
        System.out.println(currencyValueDoubleHUF);
        Assert.assertTrue(currencyValueDoubleHUF >= 0.04);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
        homePage.clearCurrecies();
        homePage.charCodeBoxFill("MKD");
        homePage.currencyRatesButtonPress();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
        Assert.assertTrue(homePage.currenciesListShow());

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
        WebElement getCurrencyElementMKD = driver.findElement(By.xpath("//*[@id=\"currenciesList\"]/div/button"));
        String getCurrencyStringMKD = getCurrencyElementMKD.getText();
        String currencyValueStringMKD = getCurrencyStringMKD.substring(getCurrencyStringMKD.length()-6);
        double currencyValueDoubleMKD = Double.parseDouble(currencyValueStringMKD);
        System.out.println(currencyValueDoubleMKD);
        Assert.assertTrue(currencyValueDoubleMKD >= 0.3);

    }

    @Test
    public void olderFromDate() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
        homePage.fromDateCurrencyFill("31.12.1993");
        homePage.currencyRatesButtonPress();
        wait.until(ExpectedConditions.visibilityOf(homePage.fromDateTooOldAlertWebElementDisplayed()));
        System.out.println(homePage.fromDateTooOldAlertText());
        Assert.assertTrue((badRequest400firstPart + homePage.fromDateTooOldAlertWebElementDisplayed().getText()
                + badRequest400secondPartOld).contains("31.12.1993"));
//        400 Bad Request. Reason: '31.12.1993' date is too old, the oldest available currency date is 01.01.1994
    }

    @Test
    public void olderToDate() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
        homePage.fromDateCurrencyFill("10.10.2022");
        homePage.toDateCurrencyFill("31.12.1993");
        homePage.charCodeBoxFill("MKD");
        homePage.currencyRatesButtonPress();
        wait.until(ExpectedConditions.visibilityOf(homePage.toDateTooOldAlertWebElementDisplayed()));
        Assert.assertTrue((badRequest400firstPart + homePage.toDateTooOldAlertWebElementDisplayed().getText()
                + badRequest400secondPartOld).contains("31.12.1993"));    }

    @Test
    public void validFromDate() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
        homePage.fromDateCurrencyFill("10.10.2022");
        homePage.toDateCurrencyFill("12.10.2022");
        homePage.charCodeBoxFill("MKD");
        homePage.currencyRatesButtonPress();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
        Assert.assertTrue(homePage.currenciesListShow());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
        Date d1 = new Date();
        Date d2 = new Date();
        String d1formatted = new SimpleDateFormat("dd.MM.yyyy").format(d1);
        String d2formatted = new SimpleDateFormat("dd.MM.yyyy").format(d2);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
        Assert.assertTrue(homePage.fromDateTextInsideBox().contains(d1formatted));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
        Assert.assertTrue(homePage.toDateTextInsideBox().contains(d2formatted));
        //de completat cu verificare la assert de datele aduse si currency corect
    }

//    @Test
//    public void validToDate() {
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
//        homePage.toDateCurrencyFill("10.10.2022");
//        homePage.charCodeBoxFill("MKD");
//        homePage.currencyRatesButtonPress();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
//        Assert.assertTrue(homePage.currenciesListShow());
//    }

    @Test
    public void futureFromDate() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
        homePage.fromDateCurrencyFill("30.10.2022");
        homePage.charCodeBoxFill("MKD");
        homePage.currencyRatesButtonPress();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
        wait.until(ExpectedConditions.visibilityOf(homePage.toDateTooOldAlertWebElementDisplayed()));
        Assert.assertTrue((badRequest400firstPart + homePage.toDateTooOldAlertWebElementDisplayed().getText()
                + badRequest400secondPartFuture).contains("30.10.2022"));
        //here the actual error displayed is "500 - internal server error. Reason: Undefined"
    }

    @Test
    public void defaultFromDate() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
        homePage.toDateCurrencyFill("20.10.2022");
        homePage.charCodeBoxFill("MKD");
        homePage.currencyRatesButtonPress();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
        Assert.assertTrue(homePage.currenciesListShow());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
        LocalDate d1 = LocalDate.parse(homePage.firstTextDate(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        LocalDate d2 = LocalDate.parse(homePage.lastTextDate(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());
        Assert.assertTrue(homePage.currenciesListShow());
        Assert.assertTrue(diff.toDays() <= 30);
    }

    @Test
    public void greaterToDate() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
        homePage.toDateCurrencyFill("30.10.2022");
        homePage.charCodeBoxFill("MKD");
        homePage.currencyRatesButtonPress();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
        wait.until(ExpectedConditions.visibilityOf(homePage.toDateTooOldAlertWebElementDisplayed()));
        Assert.assertTrue((badRequest400firstPart + homePage.toDateTooOldAlertWebElementDisplayed().getText()
                + badRequest400secondPartFuture).contains("30.10.2022"));
        //here the actual error displayed is "500 - internal server error. Reason: Undefined"
    }

    @Test
    public void defaultToDate() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
        homePage.fromDateCurrencyFill("01.10.2022");
        homePage.charCodeBoxFill("MKD");
        homePage.currencyRatesButtonPress();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
        Assert.assertTrue(homePage.currenciesListShow());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
        LocalDate d3 = LocalDate.parse(homePage.toDateTextBoxFilledIn(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        Assert.assertEquals(LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")), d3);
//        this last Assert will fail because the 'To' box is not filled in with the current date
    }

    @Test
    public void datePeriod60DatesDisplayed() {
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(10L));
        homePage.fromDateCurrencyFill("01.07.2022");
        homePage.toDateCurrencyFill("01.10.2022");
        homePage.currencyRatesButtonPress();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
        LocalDate d1 = LocalDate.parse(homePage.firstTextDate(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        LocalDate d2 = LocalDate.parse(homePage.lastTextDate(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());
        Assert.assertTrue(diff.toDays() <= 60);
    }

    @Test
    public void emptyCharCodes() {
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(10L));
        homePage.fromDateCurrencyFill("01.09.2022");
        homePage.toDateCurrencyFill("02.09.2022");
        homePage.currencyRatesButtonPress();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
        List<WebElement> numberOfCurrencies = driver.findElements(By.className("col-md-12"));
        System.out.println(numberOfCurrencies.size());
        Assert.assertTrue(homePage.currenciesListShow());
    }

    @Test
    public void myMethod() {

    }
}
