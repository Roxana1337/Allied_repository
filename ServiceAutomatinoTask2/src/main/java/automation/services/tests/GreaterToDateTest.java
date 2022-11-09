package automation.services.tests;

import automation.core.UserPassGenerator;
import automation.services.actions.CurrencyActions;
import automation.services.actions.RegistrationLoginActions;
import automation.services.dto.BaseResponseDTO;
import automation.services.dto.CurrencyRangeResponseDTO;
import org.apache.http.Header;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Optional;

public class GreaterToDateTest {
    @Test
    public void test() {
        BaseResponseDTO registrationResult = RegistrationLoginActions.registerNewUser(UserPassGenerator.numberUCLCUserPass(), UserPassGenerator.numberUCLCUserPass());
        String dateTo = "dateto";
        String date = "24.12.2022";
        String charCodes = "charcodes";
        String HUF = "HUF";

        System.out.println(registrationResult.getErrorDescription());
        registrationResult.getResponseHeaders().stream().forEach(System.out::println);


        String authToken = "";
        Optional<Header> optionalAuthTokenHeader = registrationResult.getResponseHeaders().stream()
                .filter(header -> header.getName().equals("AuthToken")).findFirst();
        if (optionalAuthTokenHeader.isPresent()) {
            Header header = optionalAuthTokenHeader.get();
            authToken = header.getValue();
        }

        HashMap<String, String> authTokens = new HashMap<>();
        authTokens.put("authToken", authToken);
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put(dateTo, date);
        queryParams.put(charCodes, HUF);

        CurrencyRangeResponseDTO resultFromCRA = CurrencyActions.getCurrencyRanges(queryParams, authTokens);
        System.out.println(resultFromCRA.getErrorDescription());
        resultFromCRA.getResponseHeaders().stream().forEach(System.out::println);
        Assert.assertEquals(resultFromCRA.getResponseStatusCode(),400);
        Assert.assertTrue(resultFromCRA.getErrorDescription().contains("future date is not valid"));
    }
}
