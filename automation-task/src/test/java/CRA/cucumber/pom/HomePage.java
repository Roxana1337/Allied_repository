package CRA.cucumber.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HomePage {
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//*[@id=\"logoutButton\"]")
    private WebElement logOutButton;

    @FindBy(xpath = "//*[@id=\"unregisterButton\"]")
    private WebElement unregisterButton;
    @FindBy(xpath = "//*[@id=\"fromDateSearchParam\"]")
    private WebElement fromDateCurrency;
    @FindBy(xpath = "//*[@id=\"toDateSearchParam\"]")
    private WebElement toDateCurrency;
    @FindBy(xpath = "//*[@id=\"getCurrencyRatesButton\"]")
    private WebElement currencyRatesButton;
    @FindBy(xpath = "//*[@id=\"onGetCurrencyRatesFailAlert\"]")
    private WebElement currencyRatesAlert;
    @FindBy(xpath = "//*[@id=\"currenciesHistoryFromDate\"]")
    private WebElement fromDateCurrencyHistory;
    @FindBy(xpath = "//*[@id=\"currenciesHistoryToDate\"]")
    private WebElement toDateCurrencyHistory;
    @FindBy(xpath = "//*[@id=\"getCurrenciesHistoryButton\"]")
    private WebElement currencyHistoryButton;
    @FindBy(xpath = "//*[@id=\"currenciesList\"]")
    private WebElement currenciesList;
    @FindBy(xpath = "//*[@id=\"currencyChart\"]")
    private WebElement currenciesHistoryChart;
    @FindBy(xpath = "//*[@id=\"charCodesSearchParam\"]")
    private WebElement charCodeBox;
    @FindBy(xpath = "//*[@id=\"currenciesList\"]/div/button")
    private WebElement currencyValue;
    @FindBy(xpath = "//*[@id=\"clearCurrencyRatesButton\"]")
    private WebElement clearCurrencyRatesButton;
    @FindBy(id = "onGetCurrencyRatesFailAlert")
    private WebElement fromDateTooOldAlert;
    @FindBy(xpath = "//*[@id=\"onGetCurrencyRatesFailAlert\"]")
    private WebElement toDateTooOldAlert;
    @FindBy(xpath = "//*[@id=\"currenciesList\"]/*")
    private List<WebElement> charDataList;
    public boolean logOutButtonDisplayed() {
        return logOutButton.isDisplayed();
    }

    public void logOutButtonPress() {
        logOutButton.click();
    }


    public void unregisterButtonPress() {
        unregisterButton.click();
    }

    public void fromDateCurrencyFill(String fromDate) {
        fromDateCurrency.clear();
        fromDateCurrency.sendKeys(fromDate);
    }

    public String fromDateTextInsideBox() {
        return fromDateCurrency.getText();
    }

    public void toDateCurrencyFill(String toDate) {
        toDateCurrency.clear();
        toDateCurrency.sendKeys(toDate);
    }

    public String toDateTextInsideBox() {
        return toDateCurrency.getText();
    }

    public void fromDateCurrencyHistoryFill(String fromDateHistory) {
        fromDateCurrencyHistory.clear();
        fromDateCurrencyHistory.sendKeys(fromDateHistory);
    }

    public void toDateCurrencyHistoryFill(String toDateHistory) {
        toDateCurrencyHistory.clear();
        toDateCurrencyHistory.sendKeys(toDateHistory);
    }

    public void currencyRatesButtonPress() {
        currencyRatesButton.click();
    }

    public void currencyHistoryButtonPress() {
        currencyHistoryButton.click();
    }

    public boolean setCurrencyRatesAlertDisplayed() {
        return currencyRatesAlert.isDisplayed();
    }

    public boolean currenciesListShow() {
        return currenciesList.isDisplayed();
    }

    public boolean currenciesHistoryChartShow() {
        return currenciesHistoryChart.isDisplayed();
    }

    public void charCodeBoxFill(String charCode) {
        charCodeBox.clear();
        charCodeBox.sendKeys(charCode);
    }

    public void clearCurrecies() {
        clearCurrencyRatesButton.click();
    }

    public WebElement fromDateTooOldAlertWebElementDisplayed() {
        fromDateTooOldAlert.isDisplayed();
        return fromDateTooOldAlert;
    }

    public boolean fromDateTooOldAlertDisplayed() {
        return fromDateTooOldAlert.isDisplayed();
    }

    public String fromDateTooOldAlertText() {
        fromDateTooOldAlert.getTagName();
        return String.valueOf(fromDateTooOldAlert);
    }


    public WebElement toDateTooOldAlertWebElementDisplayed() {
        toDateTooOldAlert.isDisplayed();
        return toDateTooOldAlert;
    }

    public boolean toDateTooOldAlertDisplayed() {
        return toDateTooOldAlert.isDisplayed();
    }

    public String firstTextDate(){
        WebElement first = charDataList.get(0);
        return first.getText().substring(6,16);
    }
    public String lastTextDate(){
        WebElement last = charDataList.get(charDataList.size()-1);
        return last.getText().substring(6,16);
    }

    public String toDateTextBoxFilledIn() {
        toDateCurrency = charDataList.get(0);
        return toDateCurrency.getText().substring(6,16);
    }

    public String fromDateTextBoxFilledIn() {
        fromDateCurrency = charDataList.get(0);
        return fromDateCurrency.getText().substring(6,16);
    }

}
