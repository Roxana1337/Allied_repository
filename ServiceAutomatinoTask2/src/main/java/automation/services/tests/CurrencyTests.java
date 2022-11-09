package automation.services.tests;

import automation.services.actions.CurrencyActions;
import automation.services.dto.CurrencyNameResponseDTO;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CurrencyTests {
    @DataProvider(name = "Languages")
    public Object[][] getLanguages() {
        return new Object[][] {
                {"en", "10.11.2021"},
                {"ru", "10.11.2021"},
                {"ro", "10.11.2021"}
        };
    }
    @Test(dataProvider = "Languages")
    public void currencyTest(String language, String date) {
        CurrencyNameResponseDTO result = CurrencyActions
                .getCurrencyNames(language, date);
        Assert.assertEquals(result.getResponseStatusCode(), 200);
        Assert.assertFalse(result.getCurrencyNames().isEmpty());
        System.out.println(result.getCurrencyNames());
    }
}



